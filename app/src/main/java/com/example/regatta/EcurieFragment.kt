package com.example.regatta

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewTreeLifecycleOwner
import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.example.regatta.dao.AppDatabase
import com.example.regatta.dao.PersonneDao
import com.example.regatta.databinding.FragmentEcurieBinding
import com.example.regatta.modele.Personne
import com.example.regatta.view_model.RaceViewModel


class EcurieFragment : Fragment() {

    private lateinit var personneDao: PersonneDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_ecurie, container, false)

        var binding = DataBindingUtil.inflate<FragmentEcurieBinding>(inflater, R.layout.fragment_ecurie, container, false)

        var vm = ViewModelProvider(this).get(RaceViewModel::class.java)
        binding.model = vm

        /*
        var context = InstrumentationRegistry.getInstrumentation().targetContext
        var db:AppDatabase = Room.inMemoryDatabaseBuilder(context , AppDatabase::class.java).allowMainThreadQueries().build()
        personneDao = db.personneDao()
        personneDao.insert(Personne(0,"B.", "John", 36))
        */


        /**
         * le two-way binding n'est pas encore ok donc on doit reinjecter le ViewModel
         * avec LiveData, les lignes suivantes peuvent être supprimées
         * video TP BestFinger 1 @ 53min Design Pattern Singleton, Observer-Observable, DAO
         */
        /*binding.btnEcurieNext.setOnClickListener {
            Log.i("MLS", "clic sur le bouton nouvelle équipe")
            vm.ecurieSuivante()
            binding.model = vm
        }*/

        /**
         * definition de l'observer qui surveille l'observable ecurie_id
         * si changement, l'observeur recoit la valeur de l'element observable
         * ici, elle n'est pas utilisée en particulier,
         * car on demande à recharger l'ensemble de la vm dans le model de IHM
         */
        vm.ecurie_id.observe(viewLifecycleOwner, {
            valeur -> binding.model = vm
        })

        return binding.root
    }

}
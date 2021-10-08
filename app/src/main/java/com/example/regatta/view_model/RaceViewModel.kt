package com.example.regatta.view_model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.regatta.R

class RaceViewModel : ViewModel() {

    // donnee observable
    var ecurie_id = MutableLiveData<Int>()

    var bateau = "Banque Populaire"
    var skipper = "Jack"
    var image = ""

    init {
        ecurie_id.value = 0
        //image = R.drawable.logo.toString()
    }

    fun ecurieSuivante()
    {
        Log.i("MLS", "dans le ViewModel, on recherche une nouvelle ecurie")
        ecurie_id.value = lanceDe()
        skipper = "Jack "+ecurie_id.value
        bateau = "Tango Zoulo "+ecurie_id.value
    }

    private fun lanceDe(): Int
    {
        val valeur = (1..6).random()
        return valeur
    }
}
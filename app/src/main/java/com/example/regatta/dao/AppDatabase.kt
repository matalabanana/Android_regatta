package com.example.regatta.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.regatta.modele.Personne

@Database(entities = arrayOf(Personne::class), version  = 1)
abstract class AppDatabase : RoomDatabase()
{

    abstract fun personneDao(): PersonneDao

    companion object {
        /**
         * methode static
         * design pattern singleton pour recuperer la bdd
         * il n'existe que 1 seule instance de cet objet
         */

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase?
        {
            synchronized(this) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "ma_base_de_donnees"
                    ).fallbackToDestructiveMigration()
                        .addCallback(object : RoomDatabase.Callback() {
                            override fun onCreate(db: SupportSQLiteDatabase) {
                                super.onCreate(db)
                            }
                        }).build()
                }
                return INSTANCE
            }
        }
    }
}
package com.example.regatta.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.regatta.modele.Personne

@Dao
interface PersonneDao {

    /**
     * ajoute suspend pour les requetes dont on attend une reponse
     * et ralentissent le thread principal
     * get() retourne un observable donc pas besoin de suspend
     */


    /*
    @Insert
    fun insert(personne: Personne)

    @Query("SELECT * FROM Personne WHERE id = :the_id")
    suspend fun get(the_id:Long):Personne

    @Query("SELECT * FROM Personne Order by nom, prenom")
    fun get(): LiveData<List<Personne>>

    @Update
    fun update(personne : Personne)

    @Delete
    fun delete(personne : Personne)

    @Query("SELECT COUNT(*) FROM Personne")
    suspend fun count(): Long

    */
}
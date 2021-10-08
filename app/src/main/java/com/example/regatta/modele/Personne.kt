package com.example.regatta.modele

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Personne (
    @PrimaryKey(autoGenerate = true)
    var id:Long,
    var nom:String="",
    var prenom: String="",
    var age:Long,
)
package com.example.regatta.modele

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Bateau (
    @PrimaryKey(autoGenerate = true)
    var id:Long,
    var nom:String="",
    var vitesse:Int = 10,
    var cap:Int = 10
)
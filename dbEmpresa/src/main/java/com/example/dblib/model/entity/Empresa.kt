package com.example.dblib.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Empresa(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val nombre: String,
    val direccion: String,
    val email: String,
    val telefono: String,
    val urlFoto: String
)

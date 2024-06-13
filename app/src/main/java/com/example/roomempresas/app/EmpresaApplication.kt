package com.example.roomempresas.app

import android.app.Application
import com.example.dblib.datasource.AppDatabase
import com.example.dblib.repository.EmpresaRepository

class EmpresaApplication : Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { EmpresaRepository(database.empresaDao()) }
}
package com.example.dblib.repository

import androidx.annotation.WorkerThread
import com.example.dblib.dao.EmpresaDao
import com.example.dblib.model.entity.Empresa
import kotlinx.coroutines.flow.Flow

class EmpresaRepository(private val empresaDao: EmpresaDao) {
    val allEmpresas: Flow<List<Empresa>> = empresaDao.getAllFlow()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(empresa: Empresa) {
        empresaDao.insertAll(empresa)
    }
}
package com.example.dblib.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.dblib.model.entity.Empresa
import kotlinx.coroutines.flow.Flow

@Dao
interface EmpresaDao {
    @Query("SELECT * FROM empresa")
    fun getAllFlow(): Flow<List<Empresa>>

    @Insert
    fun insertAll(vararg empresas: Empresa)
}
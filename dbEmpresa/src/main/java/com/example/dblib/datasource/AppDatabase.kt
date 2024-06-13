package com.example.dblib.datasource

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.dblib.dao.EmpresaDao
import com.example.dblib.model.entity.Empresa

@Database(entities = [Empresa::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun empresaDao(): EmpresaDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "empresas_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
package com.example.roomempresas.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.dblib.model.entity.Empresa
import com.example.dblib.repository.EmpresaRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class EmpresaViewModel(private val repository: EmpresaRepository) : ViewModel() {
    val allEmpresas: Flow<List<Empresa>> = repository.allEmpresas

    fun insert(empresa: Empresa) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(empresa)
    }

    class EmpresaViewModelFactory(private val repository: EmpresaRepository) : ViewModelProvider.Factory {
        override fun <T: ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(EmpresaViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return EmpresaViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }

    companion object{
        private const val TAG="ProductViewModel"
    }
}
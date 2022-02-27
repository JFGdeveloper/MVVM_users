package com.javidev.mvvm_user_yayo.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.javidev.mvvm_user_yayo.dataLayer.repository.UserRepository_
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


// el viewModel es el que tiene la logica de caso de uso de la app
// tengo que crear aqui los metodos para llamar a los repositoris
// se hace en una corrutina
@HiltViewModel
class ViewModel
@Inject constructor( private val userRepositoryImpl: UserRepository_): ViewModel()
{
    fun getUser(){
        viewModelScope.launch(Dispatchers.IO){
            val user = userRepositoryImpl.getNewUser()
            print("EL USUARIO LLAMADO EN VIEWMODEL ES: $user")
        }

    }


    // siguiente: INYECTA ESTE VIEWMODEL EN LA ACTIVITY,
    // para esto tienes que tener la libreria de hilt navegacion compose


}
package com.javidev.mvvm_user_yayo.mvvm
import androidx.lifecycle.ViewModel
import com.javidev.mvvm_user_yayo.dataLayer.repository.UserRepository_
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


// el viewModel es el que tiene la logica de caso de uso de la app
// tengo que crear aqui los metodos para llamar a los repositoris
// se hace en una corrutina
@HiltViewModel
class UserViewModel
@Inject
constructor( private val userRepositoryImpl: UserRepository_): ViewModel() {

}
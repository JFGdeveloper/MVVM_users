package com.javidev.mvvm_user_yayo.mvvm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.javidev.mvvm_user_yayo.dataLayer.model.User
import com.javidev.mvvm_user_yayo.dataLayer.repository.UserRepository_
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


// el viewModel es el que tiene la logica de caso de uso de la app
// tengo que crear aqui los metodos para llamar a los repositoris
// se hace en una corrutina
@HiltViewModel
class UserViewModel
@Inject
constructor( private val userRepositoryImpl: UserRepository_): ViewModel()
{

    fun getUser(){
        viewModelScope.launch(Dispatchers.IO){
            val user = userRepositoryImpl.getNewUser()
            Log.d("viewModel",user.toString())
        }

    }


    // variable para un posible composable de espera
    private val _isLoading by lazy { MutableLiveData<Boolean>(false) }


    val isloading: LiveData<Boolean> get() = _isLoading

    // devuelve usuarios
    val users: LiveData<List<User>> by lazy {  userRepositoryImpl.getAll() }

    fun addUser(){
        if (_isLoading.value == false)
            viewModelScope.launch(Dispatchers.IO){
                _isLoading.value = true
                userRepositoryImpl.getNewUser()
                _isLoading.value = false
            }
    }

    fun deleteUser(user: User){
        viewModelScope.launch (Dispatchers.IO){
            userRepositoryImpl.deleteUser(user)
        }
    }


    /*
    // variable para un posible composable de espera
    private val _isLoading by lazy { MutableLiveData<Boolean>(false) }
    val isloading: LiveData<Boolean> get() = _isLoading

    // devuelve usuarios
    val users: LiveData<List<User>> by lazy {  userRepo.getAll() }

    fun addUser(){
        if (_isLoading.value == false)
            viewModelScope.launch(Dispatchers.IO){
                _isLoading.value = true
                userRepo.getNewUser()
                _isLoading.value = false
            }
    }

    fun deleteUser(user: User){
        viewModelScope.launch (Dispatchers.IO){
            userRepo.deleteUser(user)
        }
    }

     */


}

/* coloca esta funcion arriba dentro del viewModel y te sirve para test con un log
 fun getUser(){
        viewModelScope.launch(Dispatchers.IO){
            val user = userRepositoryImpl.getNewUser()
            Log.d("viewModel",user.toString())
        }

    }

*/
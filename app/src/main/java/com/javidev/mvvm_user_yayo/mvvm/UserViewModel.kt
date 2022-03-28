package com.javidev.mvvm_user_yayo.mvvm

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
constructor(
    private val userRepo: UserRepository_
) : ViewModel() {

    private val _isLoading: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>(false)
    }

    val isLoading: LiveData<Boolean> get() = _isLoading


    val users: LiveData<List<User>> by lazy {
        userRepo.getAllUsers()
    }


    fun addUser() {
        if (_isLoading.value == false)
            viewModelScope.launch(Dispatchers.IO) {
                _isLoading.postValue(true)
                userRepo.getNewUser()
                _isLoading.postValue(false)
            }
    }

    fun deleteUser(toDelete: User) {
        viewModelScope.launch(Dispatchers.IO) {
            userRepo.deleteUser(toDelete);
        }
    }

}
package com.javidev.mvvm_user_yayo.dataLayer.repository

import androidx.lifecycle.LiveData
import com.javidev.mvvm_user_yayo.dataLayer.dataSource.RestDataSource_
import com.javidev.mvvm_user_yayo.dataLayer.model.User
import com.javidev.mvvm_user_yayo.dataLayer.model.UserDao_
import javax.inject.Inject


interface UserRepository_{
    suspend fun getNewUser(): User  // lo obtengo de la api
    suspend fun deleteUser(toDelete: User) // lo borro de la db de Room
    fun getAll(): LiveData<List<User>>
}

// Los repositorios tienen dependencia de las apis la cuales van a usar para su
// logica y llamarlas por eso injectamos las dependencias

class UserRepositoryImpl
@Inject constructor(
    private val dataSource: RestDataSource_,
    private val userDao: UserDao_
    ): UserRepository_ {
    override suspend fun getNewUser(): User {
        TODO("Not yet implemented")
    }

    override suspend fun deleteUser(toDelete: User) {
        TODO("Not yet implemented")
    }

    override fun getAll(): LiveData<List<User>> {
        TODO("Not yet implemented")
    }


}


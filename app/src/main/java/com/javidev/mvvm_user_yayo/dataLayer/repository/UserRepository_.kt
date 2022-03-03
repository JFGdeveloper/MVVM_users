package com.javidev.mvvm_user_yayo.dataLayer.repository

import androidx.lifecycle.LiveData
import androidx.room.Delete
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

    // llama a la api y lo guarda en Room
    override suspend fun getNewUser(): User {
        val name = dataSource.getUserName().results[0].name!!
        val location = dataSource.getUserLocation().results[0].location!!
        val picture = dataSource.getUserPicture().results[0].picture!!
        val user = User(name = name.first, lastname = name.last, city = location.city, thumbnail = picture.thumbnail)
        userDao.insert(user) // al obtenerla de la api la guardo en Room
        return user
    }

    // borra de Room
    override suspend fun deleteUser(toDelete: User) = userDao.delete(toDelete)

    // devuelve una lista de Room
    override fun getAll(): LiveData<List<User>> = userDao.getAll()
}


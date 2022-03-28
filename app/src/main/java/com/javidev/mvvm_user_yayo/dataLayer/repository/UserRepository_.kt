package com.javidev.mvvm_user_yayo.dataLayer.repository

import androidx.lifecycle.LiveData
import com.javidev.mvvm_user_yayo.dataLayer.dataSource.RestDataSource_
import com.javidev.mvvm_user_yayo.dataLayer.model.User
import com.javidev.mvvm_user_yayo.dataLayer.model.UserDao
import kotlinx.coroutines.delay
import javax.inject.Inject


interface UserRepository_ {
    suspend fun getNewUser(): User  // lo obtengo de la api
    suspend fun deleteUser(toDelete: User) // lo borro de la db de Room
    fun getAllUsers(): LiveData<List<User>>
}

// Los repositorios tienen dependencia de las apis la cuales van a usar para su
// logica y llamarlas por eso injectamos las dependencias

class UserRepositoryImpl
@Inject constructor(
    private val dataSource: RestDataSource_,
    private val userDao: UserDao
) : UserRepository_ {
    override suspend fun getNewUser(): User {
        delay(3000)
        val name = dataSource.getUserName().results[0].name!!
        val location = dataSource.getUserLocation().results[0].location!!
        val picture = dataSource.getUserPicture().results[0].picture!!
        val user = User(name.first, name.last, location.city, picture.thumbnail)
        userDao.insert(user)
        return user
    }

    override fun getAllUsers() = userDao.getAll()

    override suspend fun deleteUser(toDelete: User) = userDao.delete(toDelete)

}


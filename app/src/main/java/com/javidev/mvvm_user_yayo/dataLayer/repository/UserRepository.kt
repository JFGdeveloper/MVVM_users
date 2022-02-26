package com.javidev.mvvm_user_yayo.dataLayer.repository

import com.javidev.mvvm_user_yayo.dataLayer.dataSource.RestDataSource
import com.javidev.mvvm_user_yayo.dataLayer.model.User
import javax.inject.Inject


interface UserRepository{
    suspend fun getNewUser(): User
}

// Los repositorios tienen dependencia de las apis la cuales van a usar para su
// logica y llamarlas por eso injectamos las dependencias

class UserRepositoryImpl @Inject constructor(
    private val dataSource: RestDataSource
): UserRepository {
    override suspend fun getNewUser(): User {
        val name = dataSource.getUserName().result[0].name!!
        val location = dataSource.getUserLocation().result[0].location!!
        val picture = dataSource.getUserPicture().result[0].picture!!
        val user = User(name = name.first, lastname = name.last,city = location.city, thumbnail = picture.thumbnail  )
        return  user
    }
}
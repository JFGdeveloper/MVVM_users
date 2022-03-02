package com.javidev.mvvm_user_yayo.dataLayer.repository

import com.javidev.mvvm_user_yayo.dataLayer.dataSource.RestDataSource_
import com.javidev.mvvm_user_yayo.dataLayer.model.User
import javax.inject.Inject


interface UserRepository_{
    suspend fun getNewUser(): User
}

// Los repositorios tienen dependencia de las apis la cuales van a usar para su
// logica y llamarlas por eso injectamos las dependencias

class UserRepositoryImpl
@Inject constructor(private val dataSource: RestDataSource_): UserRepository_ {

    override suspend fun getNewUser(): User {
        val name = dataSource.getUserName().results[0].name!!
        val location = dataSource.getUserLocation().results[0].location!!
        val picture = dataSource.getUserPicture().results[0].picture!!

        return User(
            name = name.first,
            lastname = name.last,
            city = location.city,
            thumbnail = picture.thumbnail
        )
    }
}


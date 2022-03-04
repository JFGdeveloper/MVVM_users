package com.javidev.mvvm_user_yayo.dataLayer.dataSource

import androidx.room.Database
import androidx.room.RoomDatabase
import com.javidev.mvvm_user_yayo.dataLayer.model.User
import com.javidev.mvvm_user_yayo.dataLayer.model.UserDao_

// tenemos que inicializar esta base de datos y para eso uso HILT
@Database(entities = [User::class], version = 1)
abstract class DbDataSource: RoomDatabase(){
    abstract fun userDao(): UserDao_
}


//
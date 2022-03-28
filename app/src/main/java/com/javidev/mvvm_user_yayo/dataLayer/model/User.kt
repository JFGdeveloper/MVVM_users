package com.javidev.mvvm_user_yayo.dataLayer.model

import androidx.lifecycle.LiveData
import androidx.room.*

// HE COMBERTIDO EL USER EN UNA TABLA DE ROMM

@Entity(tableName = "user")
data class User(
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "lastName") val lastName: String,
    @ColumnInfo(name = "city") val city: String,
    @ColumnInfo(name = "thumbnail") val thumbnail: String,
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

// PARA ACCEDER A LA TABLA NECESITO UN DAO Y SERA UN INTERFACE

@Dao
interface UserDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User)

    @Query("SELECT * FROM user ORDER BY id DESC")
    fun getAll(): LiveData<List<User>>

    @Delete
    fun delete(user: User)
}
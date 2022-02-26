package com.javidev.mvvm_user_yayo.dataLayer.model

data class User(
    val name: String,
    val lastname: String,
    val city: String,
    val thumbnail: String,
    val id: Int = 0
)

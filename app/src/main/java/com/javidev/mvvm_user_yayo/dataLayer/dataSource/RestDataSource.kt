package com.javidev.mvvm_user_yayo.dataLayer.dataSource

import com.javidev.mvvm_user_yayo.dataLayer.model.ApiResponse
import retrofit2.http.GET

// peticiones a la api como necesito 3 diseño 3

interface RestDataSource {
    @GET("?inc=name")
    suspend fun getUserName(): ApiResponse

    @GET("?inc=location")
    suspend fun getUserLocation(): ApiResponse

    @GET("?inc=picture")
    suspend fun getUserPicture(): ApiResponse
}
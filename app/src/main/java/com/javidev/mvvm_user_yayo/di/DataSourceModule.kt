package com.javidev.mvvm_user_yayo.di

import com.javidev.mvvm_user_yayo.dataLayer.dataSource.RestDataSource_
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

// 6 cramos la carperta di
// al ser un modulo instalado en singletoncomponent
// puedo usar los metodos en toda la app

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {

    @Singleton
    @Provides
    @Named("BaseUrl")
    fun provideBaseUrl() = "https://randomuser.me/api/"

    @Singleton
    @Provides
    fun provideRetrofit(@Named("BaseUrl") baseUrl: String): Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
    }


    @Singleton
    @Provides
    fun restDataSource(retrofit: Retrofit): RestDataSource_ =
        retrofit.create(RestDataSource_::class.java)


}
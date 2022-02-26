package com.javidev.mvvm_user_yayo.di

import com.javidev.mvvm_user_yayo.dataLayer.dataSource.RestDataSource_
import com.javidev.mvvm_user_yayo.dataLayer.repository.UserRepositoryImpl
import com.javidev.mvvm_user_yayo.dataLayer.repository.UserRepository_
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

// 7 cramos la carperta di
// al ser un modulo instalado en singletoncomponent
// puedo usar los metodos en toda la app

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Provides
    abstract fun userRepositoty(repo: UserRepositoryImpl): UserRepository_

}
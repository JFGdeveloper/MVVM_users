package com.javidev.mvvm_user_yayo.di

import android.content.Context
import androidx.room.Room
import com.javidev.mvvm_user_yayo.dataLayer.dataSource.DbDataSource
import com.javidev.mvvm_user_yayo.dataLayer.dataSource.RestDataSource_
import com.javidev.mvvm_user_yayo.dataLayer.model.UserDao_
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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


    // INYECCIONES PARA ROMM

    // con esto instancio la bd de romm que yo he creado
    @Singleton
    @Provides
    fun dbDataSource(@ApplicationContext context: Context): DbDataSource{
        return Room.databaseBuilder(context,DbDataSource::class.java,"user_dataSource")
            .fallbackToDestructiveMigration()
            .build()
    }

    // devuelve un userDao de la bd que he creado
    @Singleton
    @Provides
    fun userDao(db: DbDataSource): UserDao_ = db.userDao()





}
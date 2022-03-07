package com.example.whiterabit_employedetails.di

import android.content.Context
import com.example.whiterabit_employedetails.Data.entities.local.AppDatabase
import com.example.whiterabit_employedetails.Data.entities.local.EmployeeDao
import com.example.whiterabit_employedetails.Data.entities.remote.EmployeeRemoteDataSource
import com.example.whiterabit_employedetails.Data.entities.remote.EmployeeService
import com.example.whiterabit_employedetails.Data.entities.repository.EmployeeRepository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson) : Retrofit = Retrofit.Builder()
        .baseUrl("http://www.mocky.io/v2/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun provideCharacterService(retrofit: Retrofit): EmployeeService = retrofit.create(EmployeeService::class.java)

    @Singleton
    @Provides
    fun provideCharacterRemoteDataSource(employeeService: EmployeeService) = EmployeeRemoteDataSource(employeeService)

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context) = AppDatabase.getDatabase(appContext)

    @Singleton
    @Provides
    fun provideCharacterDao(db: AppDatabase) = db.employeeDao()

    @Singleton
    @Provides
    fun provideRepository(remoteDataSource: EmployeeRemoteDataSource,
                          localDataSource: EmployeeDao) =
        EmployeeRepository(remoteDataSource, localDataSource)
}
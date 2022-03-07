package com.example.whiterabit_employedetails.Data.entities.repository

import com.example.whiterabit_employedetails.Data.entities.EmployeeList
import com.example.whiterabit_employedetails.Data.entities.local.EmployeeDao
import com.example.whiterabit_employedetails.Data.entities.remote.EmployeeRemoteDataSource
import com.example.whiterabit_employedetails.utils.performGetOperation
import javax.inject.Inject

class EmployeeRepository @Inject constructor(
    private val remoteDataSource: EmployeeRemoteDataSource,
    private val localDataSource: EmployeeDao
) {
    fun getCharacters() = performGetOperation(
        databaseQuery = { localDataSource.getAllEmployees() },
        networkCall = { remoteDataSource.getEmployees() },
        saveCallResult = { localDataSource.insertAll(it) }
    )
}
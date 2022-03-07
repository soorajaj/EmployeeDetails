package com.example.whiterabit_employedetails.Data.entities.remote

import com.example.whiterabit_employedetails.Data.entities.EmployeeList
import retrofit2.Response
import retrofit2.http.GET

interface EmployeeService {
    @GET("5d565297300000680030a986")
    suspend fun getAllEmployees() : Response<EmployeeList>
}
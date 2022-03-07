package com.example.whiterabit_employedetails.Data.entities.remote

import javax.inject.Inject

class EmployeeRemoteDataSource @Inject constructor(
    private val employeeService: EmployeeService
): BaseDataSource() {

    suspend fun getEmployees() = getResult { employeeService.getAllEmployees() }
}
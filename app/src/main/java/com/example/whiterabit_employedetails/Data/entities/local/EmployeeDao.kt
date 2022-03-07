package com.example.whiterabit_employedetails.Data.entities.local

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.whiterabit_employedetails.Data.entities.EmployeeList

interface EmployeeDao {
    @Query("SELECT * FROM employeeList")
    fun getAllEmployees() : LiveData<List<Character>>

    @Query("SELECT * FROM employeeList WHERE id = :id")
    fun getEmployee(id: Int): LiveData<EmployeeList>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(employees: EmployeeList)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(employee: EmployeeList)

}
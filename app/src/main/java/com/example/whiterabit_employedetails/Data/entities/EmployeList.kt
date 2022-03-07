package com.example.whiterabit_employedetails.Data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "employeeList")
data class EmployeeList(
    @PrimaryKey
    val id:Int,
    val name:String,
    val username:String,
    val email:String,
    val profile_image:String,
    val address:List<Address>,
    val phone: String,
    val website:String,
    val company:List<Company>
)

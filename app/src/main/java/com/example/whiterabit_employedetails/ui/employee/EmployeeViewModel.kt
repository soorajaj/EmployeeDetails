package com.example.whiterabit_employedetails.ui.employee

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.whiterabit_employedetails.Data.entities.repository.EmployeeRepository

class EmployeeViewModel @ViewModelInject constructor(
    private val repository: EmployeeRepository
) : ViewModel() {

    val characters = repository.getCharacters()
}
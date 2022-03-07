package com.example.whiterabit_employedetails.Data.entities.local

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.example.whiterabit_employedetails.Data.entities.EmployeeList

@Database(entities = [EmployeeList::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun employeeDao() :EmployeeDao
    companion object {
        @Volatile private var instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase =
            instance ?: synchronized(this) { instance ?: buildDatabase(context).also { instance = it } }

        private fun buildDatabase(appContext: Context) =
            Room.databaseBuilder(appContext, AppDatabase::class.java, "employees")
                .fallbackToDestructiveMigration()
                .build()
    }

}
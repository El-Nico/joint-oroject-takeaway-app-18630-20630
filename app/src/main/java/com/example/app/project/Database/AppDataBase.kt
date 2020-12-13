package com.example.app.project.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.app.project.DAO.CartDao
import com.example.app.project.Entity.FoodItemTable

@Database(entities = [FoodItemTable::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {
    abstract fun cartDao(): CartDao?

    companion object {
        private var instance: AppDataBase? = null
        @JvmStatic
        fun getAppDatabase(context: Context): AppDataBase? {
            if (instance == null) {
                instance = Room.databaseBuilder(context.applicationContext,
                        AppDataBase::class.java,
                        "foodapp-cart-db")
                        .allowMainThreadQueries()
                        .build()
            }
            return instance
        }
    }
}
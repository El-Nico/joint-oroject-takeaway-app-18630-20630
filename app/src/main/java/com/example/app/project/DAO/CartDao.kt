package com.example.app.project.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.app.project.Entity.FoodItemTable

@Dao
interface CartDao {
    @get:Query("Select * FROM FoodItemTable")
    val allFoodItems: Array<FoodItemTable>

    @Insert
    fun insertFoodItem(vararg foodItemTables: FoodItemTable): LongArray

    @Query("Delete FROM FoodItemTable")
    fun deleteFoodItemTable()
}
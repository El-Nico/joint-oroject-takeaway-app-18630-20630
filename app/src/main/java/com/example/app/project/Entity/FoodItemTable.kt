package com.example.app.project.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class FoodItemTable {
    @JvmField
    @PrimaryKey(autoGenerate = true)
    var id = 0

    @JvmField
    @ColumnInfo(name = "food_name")
    var foodName: String? = null

    @JvmField
    @ColumnInfo(name = "price")
    var price: String? = null

    @JvmField
    @ColumnInfo(name = "image")
    var image = 0
}
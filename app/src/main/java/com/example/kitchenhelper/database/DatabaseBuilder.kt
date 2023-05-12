package com.example.kitchenhelper.database

import android.content.Context
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import com.example.kitchenhelper.dao.FoodItemDAO
import com.example.kitchenhelper.dao.RecipeDAO
import com.example.kitchenhelper.dao.UserDAO

abstract class DatabaseBuilder : RoomDatabase() {
    abstract fun userDAO(): UserDAO?
    abstract fun foodItemDAO(): FoodItemDAO?
    abstract fun recipeDAO(): RecipeDAO?

    companion object {
        @Volatile
        private var INSTANCE: DatabaseBuilder? = null
        fun getDatabase(context: Context): DatabaseBuilder? {
            if (INSTANCE == null) {
                synchronized(DatabaseBuilder::class.java) {//remove java to the end of class if it doesn't work right
                    if (INSTANCE == null) {
                        INSTANCE = databaseBuilder(
                            context.applicationContext,
                            DatabaseBuilder::class.java,//same here
                            "myDatabase"
                        )
                            .fallbackToDestructiveMigration().build()
                    }
                }
            }
            return INSTANCE
        }
    }
}
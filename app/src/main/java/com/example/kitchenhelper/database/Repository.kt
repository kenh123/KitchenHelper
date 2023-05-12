package com.example.kitchenhelper.database

import android.app.Application
import com.example.kitchenhelper.dao.FoodItemDAO
import com.example.kitchenhelper.dao.RecipeDAO
import com.example.kitchenhelper.dao.UserDAO

class Repository() {

    private var userDAO: UserDAO? = null
    private var foodItemDAO: FoodItemDAO? = null
    private var recipeDAO: RecipeDAO? = null

    constructor(app : Application) : this() {
        val db : DatabaseBuilder? = DatabaseBuilder.getDatabase(app.applicationContext)

        if (db != null) {
            userDAO = db.userDAO()
            foodItemDAO = db.foodItemDAO()
            recipeDAO = db.recipeDAO()
        }



    }
}
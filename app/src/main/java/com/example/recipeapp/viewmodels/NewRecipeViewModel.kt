package com.example.recipeapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipeapp.database.Recipe
import com.example.recipeapp.database.RecipeDatabase
import kotlinx.coroutines.launch

class NewRecipeViewModel(application: Application) : AndroidViewModel(application) {
    private val recipeDao = RecipeDatabase.getDatabase(application).recipeDao()
    
    fun saveRecipe(title: String, ingredients: String, instructions: String) {
        viewModelScope.launch {
            val recipe = Recipe(
                title = title,
                ingredients = ingredients,
                instructions = instructions
            )
            recipeDao.insertRecipe(recipe)
        }
    }
}
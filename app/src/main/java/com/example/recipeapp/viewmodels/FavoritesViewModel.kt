package com.example.recipeapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.recipeapp.database.Recipe
import com.example.recipeapp.database.RecipeDatabase

class FavoritesViewModel(application: Application) : AndroidViewModel(application) {
    private val recipeDao = RecipeDatabase.getDatabase(application).recipeDao()
    val favoriteRecipes: LiveData<List<Recipe>> = recipeDao.getFavoriteRecipes()
}

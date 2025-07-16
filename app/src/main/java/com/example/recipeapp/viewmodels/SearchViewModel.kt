package com.example.recipeapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import com.example.recipeapp.database.Recipe
import com.example.recipeapp.database.RecipeDatabase

class SearchViewModel(application: Application) : AndroidViewModel(application) {
    private val recipeDao = RecipeDatabase.getDatabase(application).recipeDao()
    private val searchQuery = MutableLiveData<String>()
    
    val searchResults: LiveData<List<Recipe>> = searchQuery.switchMap { query ->
        recipeDao.searchRecipes(query)
    }
    
    fun searchRecipes(query: String) {
        searchQuery.value = query
    }
}
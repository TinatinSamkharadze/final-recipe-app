package com.example.recipeapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.recipeapp.adapters.Category

class CategoriesViewModel(application: Application) : AndroidViewModel(application) {
    private val _categories = MutableLiveData<List<Category>>()
    val categories: LiveData<List<Category>> = _categories
    
    init {
        _categories.value = listOf(
            Category("Georgian"),
            Category("Italian"),
            Category("Mexican"),
            Category("Asian"),
            Category("American"),
            Category("French")
        )
    }
}
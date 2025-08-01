package com.example.recipeapp.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipes")
data class Recipe(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val ingredients: String,
    val instructions: String,
    val category: String = "",
    val isFavorite: Boolean = false
)
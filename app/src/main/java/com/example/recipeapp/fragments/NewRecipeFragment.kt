package com.example.recipeapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.recipeapp.databinding.FragmentNewRecipeBinding
import com.example.recipeapp.viewmodels.NewRecipeViewModel

class NewRecipeFragment : Fragment() {
    private var _binding: FragmentNewRecipeBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: NewRecipeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewRecipeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        viewModel = ViewModelProvider(this)[NewRecipeViewModel::class.java]
        
        binding.btnSaveRecipe.setOnClickListener {
            val title = binding.etRecipeName.text.toString()
            val ingredients = binding.etIngredients.text.toString()
            val instructions = binding.etInstructions.text.toString()
            
            if (title.isNotEmpty() && ingredients.isNotEmpty() && instructions.isNotEmpty()) {
                viewModel.saveRecipe(title, ingredients, instructions)
                clearFields()
            }
        }
    }

    private fun clearFields() {
        binding.etRecipeName.text.clear()
        binding.etIngredients.text.clear()
        binding.etInstructions.text.clear()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

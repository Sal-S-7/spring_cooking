package com.example.spring_cooking.service;

import com.example.spring_cooking.model.Recipe;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeService {

    private final List<Recipe> recipes = new ArrayList<>();
    private long nextId = 1;

    public List<Recipe> getAllRecipes() {
        return recipes;
    }

    public Recipe getRecipeById(Long id) {
        for (Recipe r : recipes) {
            if (r.getId().equals(id)) {
                return r;
            }
        }
        return null;
    }

    public void saveRecipe(Recipe recipe) {
        if (recipe.getId() == null) {
            recipe.setId(nextId++);
            recipes.add(recipe);
        } else {
            Recipe existing = getRecipeById(recipe.getId());
            if (existing != null) {
                existing.setName(recipe.getName());
                existing.setIngredients(recipe.getIngredients());
                existing.setInstructions(recipe.getInstructions());
                existing.setCategory(recipe.getCategory());
            }
        }
    }

    public void deleteRecipe(Long id) {
        for (int i = 0; i < recipes.size(); i++) {
            if (recipes.get(i).getId().equals(id)) {
                recipes.remove(i);
                break;
            }
        }
    }
}

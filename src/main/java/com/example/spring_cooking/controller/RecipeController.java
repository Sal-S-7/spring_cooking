package com.example.spring_cooking.controller;

import com.example.spring_cooking.model.Recipe;
import com.example.spring_cooking.model.Category;
import com.example.spring_cooking.service.RecipeService;
import com.example.spring_cooking.service.CategoryService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/recipes")
public class RecipeController {

    private final RecipeService recipeService;
    private final CategoryService categoryService;

    public RecipeController(RecipeService recipeService, CategoryService categoryService) {
        this.recipeService = recipeService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public String listRecipes(Model model) {
        model.addAttribute("recipes", recipeService.getAllRecipes());
        return "recipes/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("recipe", new Recipe());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "recipes/form";
    }

    @PostMapping("/add")
    public String addRecipe(@ModelAttribute Recipe recipe, @RequestParam Long categoryId) {
        Category cat = categoryService.getCategoryById(categoryId);
        recipe.setCategory(cat);
        recipeService.saveRecipe(recipe);
        return "redirect:/recipes";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Recipe recipe = recipeService.getRecipeById(id);
        model.addAttribute("recipe", recipe);
        model.addAttribute("categories", categoryService.getAllCategories());
        return "recipes/form";
    }

    @PostMapping("/edit/{id}")
    public String editRecipe(@PathVariable Long id, @ModelAttribute Recipe recipe, @RequestParam Long categoryId) {
        recipe.setId(id);
        Category cat = categoryService.getCategoryById(categoryId);
        recipe.setCategory(cat);
        recipeService.saveRecipe(recipe);
        return "redirect:/recipes";
    }

    @GetMapping("/delete/{id}")
    public String deleteRecipe(@PathVariable Long id) {
        recipeService.deleteRecipe(id);
        return "redirect:/recipes";
    }

    @GetMapping("/{id}")
    public String viewRecipeDetails(@PathVariable Long id, Model model) {
        Recipe recipe = recipeService.getRecipeById(id);
        model.addAttribute("recipe", recipe);
        return "recipes/detail";
    }
}

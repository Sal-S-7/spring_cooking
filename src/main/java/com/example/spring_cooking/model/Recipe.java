package com.example.spring_cooking.model;

public class Recipe {
    private Long id;
    private String name;
    private String ingredients;
    private String instructions;
    private Category category;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getIngredients() { return ingredients; }

    public void setIngredients(String ingredients) { this.ingredients = ingredients; }

    public String getInstructions() { return instructions; }

    public void setInstructions(String instructions) { this.instructions = instructions; }

    public Category getCategory() { return category; }

    public void setCategory(Category category) { this.category = category; }
}

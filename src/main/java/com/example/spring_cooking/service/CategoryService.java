package com.example.spring_cooking.service;

import com.example.spring_cooking.model.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    private final List<Category> categories = new ArrayList<>();
    private long nextId = 1;

    public List<Category> getAllCategories() {
        return categories;
    }

    public Category getCategoryById(Long id) {
        for (Category c : categories) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    public void saveCategory(Category category) {
        if (category.getId() == null) {
            category.setId(nextId++);
            categories.add(category);
        } else {
            Category existing = getCategoryById(category.getId());
            if (existing != null) {
                existing.setName(category.getName());
                existing.setDescription(category.getDescription());
            }
        }
    }

    public void deleteCategory(Long id) {
        categories.removeIf(c -> c.getId().equals(id));
    }
}

package edu.ijse.pos_system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.ijse.pos_system.entity.Category;

@Service
public interface CategoryService {
    Category createCategory(Category category);
    Category updateCategory(Category category);
    void deleteCategory(Long id);
    Category getCategory(Long id);
    List<Category> getAllCategories();
}

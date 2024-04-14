package com.santanu.TastyTracks.service;

import com.santanu.TastyTracks.Exception.RestaurantException;
import com.santanu.TastyTracks.model.Category;

import java.util.List;

public interface CategoryService {
    public Category createCategory(String name, Long userId) throws RestaurantException;

    public List<Category> findCategoryByRestaurantId(Long restaurantId) throws RestaurantException;

    public Category findCategoryById(Long id) throws RestaurantException;
}

package com.santanu.TastyTracks.service;

import com.santanu.TastyTracks.Exception.RestaurantException;
import com.santanu.TastyTracks.model.IngredientCategory;
import com.santanu.TastyTracks.model.IngredientsItem;

import java.util.List;

public interface IngredientsService {
    public IngredientCategory createIngredientsCategory(String name, Long restaurantId) throws RestaurantException;

    public IngredientCategory findIngredientsCategoryById(Long id) throws Exception;

    public List<IngredientCategory> findIngredientsCategoryByRestaurantId(Long id) throws Exception;

    public List<IngredientsItem> findRestaurantsIngredients(Long restaurantId);

    public IngredientsItem createIngredientsItem(Long restaurantId, String ingredientName, Long ingredientCategoryId) throws Exception;

    public IngredientsItem updateStock(Long id) throws Exception;
}
package com.santanu.TastyTracks.service;

import com.santanu.TastyTracks.Exception.FoodException;
import com.santanu.TastyTracks.Exception.RestaurantException;
import com.santanu.TastyTracks.model.Category;
import com.santanu.TastyTracks.model.Food;
import com.santanu.TastyTracks.model.Restaurant;
import com.santanu.TastyTracks.request.CreateFoodRequest;

import java.util.List;

public interface FoodService {
    public Food createFood(CreateFoodRequest req, Category category, Restaurant restaurant) throws FoodException, RestaurantException;

    void deleteFood(Long foodId) throws FoodException;

    public List<Food> getRestaurantsFood(Long restaurantId, boolean isVegetarian, boolean isNonVeg, boolean isSeasonal, String foodCategory) throws FoodException;

    public List<Food> searchFood(String keyword);

    public Food findFoodById(Long foodId) throws FoodException;

    public Food updateAvailabilityStatus(Long foodId) throws FoodException;
}

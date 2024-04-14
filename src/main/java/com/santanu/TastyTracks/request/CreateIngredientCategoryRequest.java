package com.santanu.TastyTracks.request;

import lombok.Data;

@Data
public class CreateIngredientCategoryRequest {
    private Long restaurantId;
    private String name;
}


package com.santanu.TastyTracks.controller;

import com.santanu.TastyTracks.Exception.RestaurantException;
import com.santanu.TastyTracks.dto.RestaurantDto;
import com.santanu.TastyTracks.model.Restaurant;
import com.santanu.TastyTracks.model.User;
import com.santanu.TastyTracks.service.RestaurantService;
import com.santanu.TastyTracks.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;
    @Autowired
    private UserService userService;

    @GetMapping("/search")
    public ResponseEntity<List<Restaurant>> findRestaurantByName(
            @RequestParam String keyword) {
        List<Restaurant> restaurant = restaurantService.searchRestaurant(keyword);
        return ResponseEntity.ok(restaurant);
    }

    @GetMapping()
    public ResponseEntity<List<Restaurant>> getAllRestaurants() {
        List<Restaurant> restaurants = restaurantService.getAllRestaurant();
        return ResponseEntity.ok(restaurants);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> findRestaurantById(
            @PathVariable Long id) throws RestaurantException {
        Restaurant restaurant = restaurantService.findRestaurantById(id);
        return ResponseEntity.ok(restaurant);
    }

    @PutMapping("/{id}/add-favorites")
    public ResponseEntity<RestaurantDto> addToFavorite(
            @RequestHeader("Authorization") String jwt,
            @PathVariable Long id) throws Exception {
        User user = userService.findUserProfileByJwt(jwt);
        RestaurantDto restaurant = restaurantService.addToFavorites(id, user);
        return ResponseEntity.ok(restaurant);
    }
}

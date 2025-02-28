package com.santanu.TastyTracks.controller;

import com.santanu.TastyTracks.Exception.RestaurantException;
import com.santanu.TastyTracks.Exception.UserException;
import com.santanu.TastyTracks.model.Restaurant;
import com.santanu.TastyTracks.model.User;
import com.santanu.TastyTracks.request.CreateRestaurantRequest;
import com.santanu.TastyTracks.response.ApiResponse;
import com.santanu.TastyTracks.service.RestaurantService;
import com.santanu.TastyTracks.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/restaurants")
public class AdminRestaurantController {
    @Autowired
    private RestaurantService restaurantService;
    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody CreateRestaurantRequest req, @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserProfileByJwt(jwt);
        System.out.println("----TRUE___-----" + jwt);
        Restaurant restaurant = restaurantService.createRestaurant(req, user);
        return ResponseEntity.ok(restaurant);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable Long id, @RequestBody CreateRestaurantRequest req, @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserProfileByJwt(jwt);
        Restaurant restaurant = restaurantService.updateRestaurant(id, req);
        return ResponseEntity.ok(restaurant);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteRestaurantById(@PathVariable("id") Long restaurantId, @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserProfileByJwt(jwt);
        restaurantService.deleteRestaurant(restaurantId);
        ApiResponse res = new ApiResponse("Restaurant Deleted with id Successfully", true);
        return ResponseEntity.ok(res);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Restaurant> updateRestaurantStatus(
            @RequestHeader("Authorization") String jwt,
            @PathVariable Long id) throws RestaurantException, UserException {
        Restaurant restaurant = restaurantService.updateRestaurantStatus(id);
        return ResponseEntity.ok(restaurant);
    }

    @GetMapping("/user")
    public ResponseEntity<Restaurant> findRestaurantByUserId(
            @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserProfileByJwt(jwt);
        Restaurant restaurant = restaurantService.getRestaurantsByUserId(user.getId());
        return ResponseEntity.ok(restaurant);
    }
}
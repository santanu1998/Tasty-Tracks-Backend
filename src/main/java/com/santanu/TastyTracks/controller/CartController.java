package com.santanu.TastyTracks.controller;

import com.santanu.TastyTracks.Exception.CartException;
import com.santanu.TastyTracks.Exception.CartItemException;
import com.santanu.TastyTracks.Exception.FoodException;
import com.santanu.TastyTracks.Exception.UserException;
import com.santanu.TastyTracks.model.Cart;
import com.santanu.TastyTracks.model.CartItem;
import com.santanu.TastyTracks.model.User;
import com.santanu.TastyTracks.request.AddCartItemRequest;
import com.santanu.TastyTracks.request.UpdateCartItemRequest;
import com.santanu.TastyTracks.service.CartService;
import com.santanu.TastyTracks.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private UserService userService;

    @PutMapping("/cart/add")
    public ResponseEntity<CartItem> addItemToCart(@RequestBody AddCartItemRequest req, @RequestHeader("Authorization") String jwt) throws UserException, FoodException, CartException, CartItemException {
        CartItem cart = cartService.addItemToCart(req, jwt);
        return ResponseEntity.ok(cart);
    }

    @PutMapping("/cart-item/update")
    public ResponseEntity<CartItem> updateCartItemQuantity(@RequestBody UpdateCartItemRequest req, @RequestHeader("Authorization") String jwt) throws CartItemException {
        CartItem cart = cartService.updateCartItemQuantity(req.getCartItemId(), req.getQuantity());
        return ResponseEntity.ok(cart);
    }

    @DeleteMapping("/cart-item/{id}/remove")
    public ResponseEntity<Cart> removeItemFromCart(@PathVariable Long id, @RequestHeader("Authorization") String jwt) throws UserException, CartException, CartItemException {
        Cart cart = cartService.removeItemFromCart(id, jwt);
        return ResponseEntity.ok(cart);
    }

    @GetMapping("/cart/total")
    public ResponseEntity<Double> calculateCartTotals(@RequestParam Long cartId, @RequestHeader("Authorization") String jwt) throws UserException, CartException {
        User user = userService.findUserProfileByJwt(jwt);
        Cart cart = cartService.findCartByUserId(user.getId());
        double total = cartService.calculateCartTotals(cart);
        return ResponseEntity.ok(total);
    }

    @GetMapping("/cart/")
    public ResponseEntity<Cart> findUserCart(@RequestHeader("Authorization") String jwt) throws UserException, CartException {
        User user = userService.findUserProfileByJwt(jwt);
        Cart cart = cartService.findCartByUserId(user.getId());
        return ResponseEntity.ok(cart);
    }

    @PutMapping("/cart/clear")
    public ResponseEntity<Cart> clearCart(@RequestHeader("Authorization") String jwt) throws UserException, CartException {
        User user = userService.findUserProfileByJwt(jwt);
        Cart cart = cartService.clearCart(user.getId());
        return ResponseEntity.ok(cart);
    }
}

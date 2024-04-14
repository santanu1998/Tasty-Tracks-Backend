package com.santanu.TastyTracks.service;

import com.santanu.TastyTracks.Exception.CartException;
import com.santanu.TastyTracks.Exception.CartItemException;
import com.santanu.TastyTracks.Exception.FoodException;
import com.santanu.TastyTracks.Exception.UserException;
import com.santanu.TastyTracks.model.Cart;
import com.santanu.TastyTracks.model.CartItem;
import com.santanu.TastyTracks.request.AddCartItemRequest;

public interface CartService {
    public CartItem addItemToCart(AddCartItemRequest req, String jwt) throws UserException, FoodException, CartException, CartItemException;

    public CartItem updateCartItemQuantity(Long cartItemId, int quantity) throws CartItemException;

    public Cart removeItemFromCart(Long cartItemId, String jwt) throws UserException, CartException, CartItemException;

    public Long calculateCartTotals(Cart cart) throws UserException;

    public Cart findCartById(Long id) throws CartException;

    public Cart findCartByUserId(Long userId) throws CartException, UserException;

    public Cart clearCart(Long userId) throws CartException, UserException;
}

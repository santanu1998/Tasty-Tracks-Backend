package com.santanu.TastyTracks.service;

import com.santanu.TastyTracks.Exception.CartException;
import com.santanu.TastyTracks.Exception.OrderException;
import com.santanu.TastyTracks.Exception.RestaurantException;
import com.santanu.TastyTracks.Exception.UserException;
import com.santanu.TastyTracks.model.Order;
import com.santanu.TastyTracks.model.PaymentResponse;
import com.santanu.TastyTracks.model.User;
import com.santanu.TastyTracks.request.CreateOrderRequest;
import com.stripe.exception.StripeException;

import java.util.List;

public interface OrderService {
    public PaymentResponse createOrder(CreateOrderRequest order, User user) throws UserException, RestaurantException, CartException, StripeException;

    public Order updateOrder(Long orderId, String orderStatus) throws OrderException;

    public void cancelOrder(Long orderId) throws OrderException;

    public List<Order> getUserOrders(Long userId) throws OrderException;

    public List<Order> getOrdersOfRestaurant(Long restaurantId, String orderStatus) throws OrderException, RestaurantException;
}

package com.santanu.TastyTracks.controller;

import com.santanu.TastyTracks.Exception.CartException;
import com.santanu.TastyTracks.Exception.OrderException;
import com.santanu.TastyTracks.Exception.RestaurantException;
import com.santanu.TastyTracks.Exception.UserException;
import com.santanu.TastyTracks.model.Order;
import com.santanu.TastyTracks.model.PaymentResponse;
import com.santanu.TastyTracks.model.User;
import com.santanu.TastyTracks.request.CreateOrderRequest;
import com.santanu.TastyTracks.service.OrderService;
import com.santanu.TastyTracks.service.UserService;
import com.stripe.exception.StripeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;

    @PostMapping("/order")
    public ResponseEntity<PaymentResponse> createOrder(@RequestBody CreateOrderRequest order,
                                                       @RequestHeader("Authorization") String jwt)
            throws UserException, RestaurantException,
            CartException,
            StripeException,
            OrderException {
        User user = userService.findUserProfileByJwt(jwt);
        System.out.println("req user " + user.getEmail());
        if (order != null) {
            PaymentResponse res = orderService.createOrder(order, user);
            return ResponseEntity.ok(res);

        } else throw new OrderException("Please provide valid request body");
    }

    @GetMapping("/order/user")
    public ResponseEntity<List<Order>> getAllUserOrders(@RequestHeader("Authorization") String jwt) throws OrderException, UserException {

        User user = userService.findUserProfileByJwt(jwt);

        if (user.getId() != null) {
            List<Order> userOrders = orderService.getUserOrders(user.getId());
            return ResponseEntity.ok(userOrders);
        } else {
            return new ResponseEntity<List<Order>>(HttpStatus.BAD_REQUEST);
        }
    }


}

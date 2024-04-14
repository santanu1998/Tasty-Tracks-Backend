package com.santanu.TastyTracks.service;

import com.santanu.TastyTracks.model.Notification;
import com.santanu.TastyTracks.model.Order;
import com.santanu.TastyTracks.model.Restaurant;
import com.santanu.TastyTracks.model.User;

import java.util.List;

public interface NotificationService {
    public Notification sendOrderStatusNotification(Order order);

    public void sendRestaurantNotification(Restaurant restaurant, String message);

    public void sendPromotionalNotification(User user, String message);

    public List<Notification> findUsersNotification(Long userId);
}

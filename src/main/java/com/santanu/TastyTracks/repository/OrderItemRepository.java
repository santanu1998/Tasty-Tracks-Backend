package com.santanu.TastyTracks.repository;

import com.santanu.TastyTracks.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}

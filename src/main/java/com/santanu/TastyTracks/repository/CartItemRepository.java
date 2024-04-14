package com.santanu.TastyTracks.repository;

import com.santanu.TastyTracks.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}

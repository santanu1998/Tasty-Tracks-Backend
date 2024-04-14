package com.santanu.TastyTracks.request;

import com.santanu.TastyTracks.model.Address;
import lombok.Data;

@Data
public class CreateOrderRequest {
    private Long restaurantId;
    private Address deliveryAddress;
}

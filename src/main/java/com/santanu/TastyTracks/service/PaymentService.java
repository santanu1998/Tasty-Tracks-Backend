package com.santanu.TastyTracks.service;

import com.santanu.TastyTracks.model.Order;
import com.santanu.TastyTracks.model.PaymentResponse;
import com.stripe.exception.StripeException;

public interface PaymentService {

    public PaymentResponse generatePaymentLink(Order order) throws StripeException;

}

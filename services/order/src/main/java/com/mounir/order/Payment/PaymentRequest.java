package com.mounir.order.Payment;

import com.mounir.order.Customer.CustomerResponse;
import com.mounir.order.Order.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        CustomerResponse customer
) {
}

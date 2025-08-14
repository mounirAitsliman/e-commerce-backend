package com.mounir.order.Kafka;

import com.mounir.order.Customer.CustomerResponse;
import com.mounir.order.Order.PaymentMethod;
import com.mounir.order.Product.PurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customerResponse,
        List<PurchaseResponse> products

) {
}

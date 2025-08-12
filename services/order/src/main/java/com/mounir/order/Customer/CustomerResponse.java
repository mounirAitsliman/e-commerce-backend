package com.mounir.order.Customer;

public record CustomerResponse(
        String id,
        String firstName,
        String lastName,
        String email
) {
}

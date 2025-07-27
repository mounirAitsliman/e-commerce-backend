package com.mounir.ecomerce.Cusumer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CustumerRequest(
         String id,
         @NotNull(message = "Custumer firstname is required")
         String firstname,
         @NotNull(message = "Custumer lastname is required")
         String lastname,
         @Email(message = "Custumer email is not a valid email address")
         String email,
         Address adress
) {
}

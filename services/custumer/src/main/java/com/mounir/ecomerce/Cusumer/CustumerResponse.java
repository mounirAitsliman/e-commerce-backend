package com.mounir.ecomerce.Cusumer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CustumerResponse (
        String id,
        String firstname,
        String lastname,
        String email,
        Address adress
){
}

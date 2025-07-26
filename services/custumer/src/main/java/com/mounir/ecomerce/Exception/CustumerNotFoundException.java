package com.mounir.ecomerce.Exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CustumerNotFoundException extends RuntimeException {
    private final String msg;
}

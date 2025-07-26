package com.mounir.ecomerce.CustumerController;

import com.mounir.ecomerce.Cusumer.Custumer;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class CustumerMapper {
    public Custumer toCustumer(CustumerRequest request){
        if (request == null){
            return null;
        }
    return Custumer.builder()
                    .id(request.id())
            .firstname(request.firstname())
            .lastname(request.lastname())
            .email(request.email())
            .adress(request.adress())
            .build();

    }
}

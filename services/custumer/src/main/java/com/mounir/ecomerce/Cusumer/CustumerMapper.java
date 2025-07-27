package com.mounir.ecomerce.Cusumer;

import org.springframework.stereotype.Service;

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
    public CustumerResponse fromCustumer(Custumer custumer){
        return new CustumerResponse(
                custumer.getId(),
                custumer.getFirstname(),
                custumer.getLastname(),
                custumer.getEmail(),
                custumer.getAdress()
        );
    }
}

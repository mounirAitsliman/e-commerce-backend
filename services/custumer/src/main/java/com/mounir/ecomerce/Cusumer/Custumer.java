package com.mounir.ecomerce.Cusumer;

import com.mounir.ecomerce.Cusumer.Address;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Document
public class Custumer {

    @Id
    private String id;
    private String firstname;
    private String lastname;
    private String email;
    private Address adress;
}

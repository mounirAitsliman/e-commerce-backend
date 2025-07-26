package com.mounir.ecomerce.CustumerController;

import com.mounir.ecomerce.Cusumer.Custumer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustumerRepository extends MongoRepository<Custumer,String> {
}

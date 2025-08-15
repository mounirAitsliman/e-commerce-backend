package com.mounir.order.Customer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(
        name = "custumer-service",
        url = "{application.config.custumer-url}"
)
public interface CustomerClient {

    @GetMapping("/{custumer-id}")
    Optional<CustomerResponse> findCustomerById(@PathVariable("custumer-id") String custumerId);
}

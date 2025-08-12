package com.mounir.order.Order;

import com.mounir.order.Customer.CustomerClient;
import com.mounir.order.Exception.BusinessException;
import com.mounir.order.Product.ProductClient;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderMapper orderMapper;
    public Integer createdOrder( OrderRequest orderRequest) {
        //Check custumer --> Open feign
        var custumer = this.customerClient.findCustomerById(orderRequest.customerId())
                .orElseThrow(() -> new BusinessException("Cannot create order:: No custumer exists with the provided ID::"));
        //purshase the products ---> product-ms
        this.productClient.purchaseProducts(orderRequest.products());
        // persist order
        var order = this.orderRepository.save(orderMapper.toOrder(orderRequest));
        for (P)
        // persist order lines

        //start payment process

        // send order confirmation --> notification -ms (kafka)
        return null;
    }
}

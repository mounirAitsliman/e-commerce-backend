package com.mounir.order.Order;

import com.mounir.order.Customer.CustomerClient;
import com.mounir.order.Exception.BusinessException;
import com.mounir.order.OrderLine.OrderLineRequest;
import com.mounir.order.OrderLine.OrderLineService;
import com.mounir.order.Product.ProductClient;
import com.mounir.order.Product.PurchaseRequest;
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
    private final OrderLineService orderLineService;
    public Integer createdOrder( OrderRequest orderRequest) {
        var custumer = this.customerClient.findCustomerById(orderRequest.customerId())
                .orElseThrow(() -> new BusinessException("Cannot create order:: No custumer exists with the provided ID::"));
        this.productClient.purchaseProducts(orderRequest.products());
        var order = this.orderRepository.save(orderMapper.toOrder(orderRequest));
        for (PurchaseRequest purchaseRequest : orderRequest.products()){
            orderLineService.saveOrderLine(
                    new OrderLineRequest(
                            null,
                            order.getId(),
                            purchaseRequest.productId(),
                            purchaseRequest.quantity()
                    )
            );
        }

        // todo start payment process

        // send order confirmation --> notification -ms (kafka)
        return null;
    }
}

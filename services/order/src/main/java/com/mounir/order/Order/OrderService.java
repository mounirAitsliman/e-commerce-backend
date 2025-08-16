package com.mounir.order.Order;

import com.mounir.order.Customer.CustomerClient;
import com.mounir.order.Exception.BusinessException;
import com.mounir.order.Kafka.OrderConfirmation;
import com.mounir.order.Kafka.OrderProducer;
import com.mounir.order.OrderLine.OrderLineRequest;
import com.mounir.order.OrderLine.OrderLineService;
import com.mounir.order.Payment.PaymentClient;
import com.mounir.order.Payment.PaymentRequest;
import com.mounir.order.Product.ProductClient;
import com.mounir.order.Product.PurchaseRequest;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderMapper orderMapper;
    private final OrderLineService orderLineService;
    private final OrderProducer orderProducer;
    private final PaymentClient  paymentClient;
    public Integer createdOrder( OrderRequest orderRequest) {
        var custumer = this.customerClient.findCustomerById(orderRequest.customerId())
                .orElseThrow(() -> new BusinessException("Cannot create order:: No custumer exists with the provided ID::"));
        var purchasedProducts =this.productClient.purchaseProducts(orderRequest.products());
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
        var paymentRequest = new PaymentRequest(
                orderRequest.amount(),
                orderRequest.paymentMethod(),
                order.getId(),
                order.getReference(),
                custumer
        );
        paymentClient.requestOrderPayment(paymentRequest);
        orderProducer.sendOrderConfirmation(
                new OrderConfirmation(
                        orderRequest.reference(),
                        orderRequest.amount(),
                        orderRequest.paymentMethod(),
                        custumer,
                        purchasedProducts
                )
        );
        return order.getId();
    }

    public List<OrderResponse> findAll() {
        return orderRepository.findAll()
                .stream()
                .map(orderMapper::fromOrder)
                .collect(Collectors.toList());
    }

    public OrderResponse findById(Integer orderId) {
        return orderRepository.findById(orderId)
                .map(orderMapper::fromOrder)
                .orElseThrow(()-> new EntityNotFoundException(String.format("No order found with the provided ID: %d",orderId)));
    }
}

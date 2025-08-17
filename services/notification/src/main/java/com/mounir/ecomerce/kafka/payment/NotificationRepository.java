package com.mounir.ecomerce.kafka.payment;

import com.mounir.ecomerce.notification.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificationRepository extends MongoRepository<Notification,String> {
}

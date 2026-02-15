package com.ecommerce.catalog_service.service;


import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.ecommerce.catalog_service.event.ProductCreatedEvent;

@Service
public class KafkaProducerService {

    private static final String TOPIC = "product-created";

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendProductCreatedEvent(ProductCreatedEvent event) {

        kafkaTemplate.send(TOPIC, event.getProductId().toString(), event);

        System.out.println("Kafka event sent for productId: " + event.getProductId());
    }
}


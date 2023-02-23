package com.speak.speakpostgresql.service;

import com.speak.speakpostgresql.model.GlobalObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaProdeucerService {

    private KafkaTemplate<String, GlobalObject> kafkaTemplate;

    public KafkaProdeucerService(KafkaTemplate<String, GlobalObject> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendObject(GlobalObject object){
        Message<GlobalObject> message = MessageBuilder.withPayload(object)
                .setHeader(KafkaHeaders.TOPIC,"post")
                .setHeader("CUSTOM_HEADER", "post")
                .build();
        kafkaTemplate.send(message);
    }

    public void deleteObject(GlobalObject object){
        Message<GlobalObject> message = MessageBuilder.withPayload(object)
                .setHeader(KafkaHeaders.TOPIC,"post")
                .setHeader("CUSTOM_HEADER", "delete")
                .build();

        kafkaTemplate.send(message);
    }
}

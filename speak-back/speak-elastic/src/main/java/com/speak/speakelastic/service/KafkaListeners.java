package com.speak.speakelastic.service;

import com.speak.speakelastic.documents.GlobalObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    private final GObjectService gObjectService;

    @Autowired
    public KafkaListeners(GObjectService gObjectService) {
        this.gObjectService = gObjectService;
    }

    /**
     * This function listens for any message in the topic post
     * at which case it adds the message to the elasticsearch database
     *
     * @param object
     */
    @KafkaListener(
            topics = "post",
            groupId = "myGroup"

    )
    public void postListener(GlobalObject object,@Header("CUSTOM_HEADER") String header) {
        System.out.println(object.toString());
        System.out.println(header);
        if(header.contains("post")){
        this.gObjectService.save(object);}
        else  if(header.contains("delete")){
            this.gObjectService.delete(object.getId());
        }

    }


}

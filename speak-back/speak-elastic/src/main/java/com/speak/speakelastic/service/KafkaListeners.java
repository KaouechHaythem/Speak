package com.speak.speakelastic.service;

import com.speak.speakelastic.documents.GlobalObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
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
    public void postListener(GlobalObject object) {
        System.out.println(object.toString());
        this.gObjectService.save(object);

    }

    /**
     * This function listens for any message in the delete post
     * at which case it delets the message from the elasticsearch database
     *
     * @param object
     */
    @KafkaListener(
            topics = "delete",
            groupId = "deleteID"

    )
    public void deleteListener(GlobalObject object) {
        this.gObjectService.delete(object.getId());

    }
}

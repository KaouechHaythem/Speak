package com.speak.speakpostgresql.service;

import com.speak.speakpostgresql.model.GlobalObject;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PreRemove;
import java.net.URISyntaxException;

/**
 * synchrinise postgresql database with elasticsearch by listening to any change in the entities
 */

public class ListenerService {
    @Autowired
    private RestGateService restGateService;
    @Autowired
    private KafkaProdeucerService kafkaProdeucerService;


    @PostPersist
    void onPostPersist(GlobalObject object) throws URISyntaxException {
      //  this.restGateService.postObject(object);
        //send post request via kafka
        this.kafkaProdeucerService.sendObject(object);

    }


    @PostUpdate
    void onPostUpdate(GlobalObject object) throws URISyntaxException {
        //this.restGateService.putObject(object);


    }


    @PreRemove
    void onPreRemove(GlobalObject object) {
       // this.restGateService.deleteObject(object.getId());
        //send delete command via kafka
        this.kafkaProdeucerService.deleteObject(object);

    }


}
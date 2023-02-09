package com.speak.speakelastic.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.speak.speakelastic.documents.GlobalObject;
import com.speak.speakelastic.repository.GObjectRepository;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GObjectService {
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private final GObjectRepository gObjectRepository;
    private final RestHighLevelClient client;

    @Autowired
    public GObjectService(GObjectRepository gObjectRepository, RestHighLevelClient client) {
        this.gObjectRepository = gObjectRepository;

        this.client = client;
    }

    /**
     * save an object to the database
     *
     * @param object
     */
    public void save(GlobalObject object) {
        gObjectRepository.save(object);
    }

    /**
     * search an object by description
     *
     * @param description
     * @return
     */
    public List<GlobalObject> searchByDescription(final String description) {
        return gObjectRepository.findByDescriptionLike(description);
    }

    /**
     * delete an object
     *
     * @param id
     */
    public void delete(String id) {
        gObjectRepository.deleteById(id);
    }

    /**
     * find one object by id
     *
     * @param id
     * @return
     */
    public GlobalObject getOne(String id) {
        return gObjectRepository.findById(id).orElse(null);
    }
}

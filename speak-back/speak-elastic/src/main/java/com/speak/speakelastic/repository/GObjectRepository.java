package com.speak.speakelastic.repository;

import com.speak.speakelastic.documents.GlobalObject;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GObjectRepository extends ElasticsearchRepository<GlobalObject, String> {

@Query("{\"bool\":" +
        " {\"must\":" +
        " [" +
        "{\"match\": {\"type\": \"?2\"}" +
        "}" +
        "," +
        "{\"bool\":{\"should\":[{\"match\": {\"description\": \"?0\"}}," +
        "{\"match\": {\"name\": \"?1\"}}]}" +
        "}" +
        "]" +
        "}" +
        "}")
    List<GlobalObject> findByDescriptionOrNameAndTypeLike(String description,String name,String type);


}

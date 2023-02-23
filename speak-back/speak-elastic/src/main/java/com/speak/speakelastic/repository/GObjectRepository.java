package com.speak.speakelastic.repository;

import com.speak.speakelastic.documents.GlobalObject;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GObjectRepository extends ElasticsearchRepository<GlobalObject, String> {


    List<GlobalObject> findByDescriptionLike(String content);


}

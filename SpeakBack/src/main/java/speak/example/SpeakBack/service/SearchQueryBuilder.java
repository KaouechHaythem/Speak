package speak.example.SpeakBack.service;

import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import speak.example.SpeakBack.Documents.Post;

import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.matchQuery;
import static org.elasticsearch.index.query.QueryBuilders.multiMatchQuery;

@Service
public class SearchQueryBuilder {
    NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
            .withQuery(multiMatchQuery("hi")
                    .field("content")
                    .field("id")
                    .type(MultiMatchQueryBuilder.Type.BEST_FIELDS))
            .build();

}

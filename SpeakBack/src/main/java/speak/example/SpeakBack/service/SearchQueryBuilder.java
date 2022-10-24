package speak.example.SpeakBack.service;

import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

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

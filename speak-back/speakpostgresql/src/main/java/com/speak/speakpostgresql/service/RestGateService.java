package com.speak.speakpostgresql.service;

import com.speak.speakpostgresql.model.GlobalObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * send requests to elasticsearch microservice
 */
@Service
public class RestGateService {
    @Value("${base.url}")
    public String baseURL;
    private final RestTemplate restTemplate;
    MultiValueMap<String, String> bodyValues = new LinkedMultiValueMap<>();
    WebClient client = WebClient.create();

    public RestGateService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public void postObject(GlobalObject object) throws URISyntaxException {
        bodyValues.add("id", object.getId());
        bodyValues.add("name", object.getName());
        bodyValues.add("description", object.getDescription());
        bodyValues.add("type", object.getType());
        String response = client.post()
                .uri(new URI(baseURL + "saveObject"))

                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .accept(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromFormData(bodyValues))
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    public void putObject(GlobalObject object) throws URISyntaxException {
        bodyValues.add("id", object.getId());
        bodyValues.add("name", object.getName());
        bodyValues.add("description", object.getDescription());
        bodyValues.add("type", object.getType());
        String response = client.put()
                .uri(new URI(baseURL + "saveObject"))

                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .accept(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromFormData(bodyValues))
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    public void deleteObject(String id) {
        client.method(HttpMethod.DELETE)
                .uri(baseURL + id)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    public List<GlobalObject> search(String searchTerm) throws UnsupportedEncodingException {
        return this.restTemplate.getForObject(baseURL + "search/" + searchTerm, List.class);

    }

}



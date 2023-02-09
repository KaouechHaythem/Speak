package com.speak.speakpostgresql.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
/**
 * configure kafka topic
 */
public class KafkaTopicConfig {
    @Bean
    public NewTopic postTopic() {

        return TopicBuilder.name("post").build();
    }

    @Bean
    public NewTopic deleteTopic() {
        return TopicBuilder.name("delete").build();
    }
}

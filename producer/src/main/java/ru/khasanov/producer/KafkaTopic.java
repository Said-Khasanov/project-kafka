package ru.khasanov.producer;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopic {
    @Bean
    public NewTopic mainTopic() {
        return TopicBuilder
                .name("main-topic")
                .partitions(10)
                .replicas(1)
                .build();
    }
}

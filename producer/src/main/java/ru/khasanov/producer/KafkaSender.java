package ru.khasanov.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import ru.khasanov.common.Message;

@RequiredArgsConstructor
@Component
@Slf4j
public class KafkaSender {
    private final KafkaTemplate<String, Message> kafkaTemplate;

    public void send(String topic, Message message) {
        log.info("Sending message: {}", message);
        kafkaTemplate.send(topic, message);
    }
}

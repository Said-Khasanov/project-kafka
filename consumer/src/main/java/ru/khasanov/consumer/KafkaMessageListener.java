package ru.khasanov.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.khasanov.common.Message;

@RequiredArgsConstructor
@Component
@Slf4j
public class KafkaMessageListener {
    private final MessageRepository messageRepository;

    @KafkaListener(topics = "main-topic", groupId = "main-group",
            containerFactory = "userKafkaListenerContainerFactory")
    public void listen(Message message) {
        log.info("Received Message: {}", message);
        Message saved = messageRepository.save(message);
        log.info("Saved Message: {}", saved);
    }
}

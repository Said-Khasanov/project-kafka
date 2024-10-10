package ru.khasanov.consumer;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.khasanov.common.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {
}

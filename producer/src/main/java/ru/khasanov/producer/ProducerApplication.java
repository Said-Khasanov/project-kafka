package ru.khasanov.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import ru.khasanov.common.Message;

import static java.lang.Thread.sleep;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@Slf4j
public class ProducerApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ProducerApplication.class, args);
        KafkaSender kafkaSender = context.getBean(KafkaSender.class);
        runSenderLoop(kafkaSender);
    }

    private static void runSenderLoop(KafkaSender kafkaSender) {
        Message message = Message.builder()
                .text("I'm alive")
                .build();

        while (true) {
            kafkaSender.send("main-topic", message);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                log.error(e.getMessage());
                break;
            }
        }
    }
}

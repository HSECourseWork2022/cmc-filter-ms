package dev.hse.template.kafka;

import dev.hse.template.pojo.TemplateFiltered;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j(topic = "[sourcename][filter][outcome]")
@Service
@RequiredArgsConstructor
public class KafkaProducerService {

    @Value("${filter.source}.${filter.subtheme}.filters.outcome")
    private String outputTopic;
    private final KafkaTemplate<String, TemplateFiltered> kafkaTemplate;

    public void send(TemplateFiltered templateFiltered) {
        log.info("Sending to '{}' topic", outputTopic);
        kafkaTemplate.send(outputTopic, templateFiltered);
    }
}

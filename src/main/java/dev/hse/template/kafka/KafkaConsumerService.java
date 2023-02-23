package dev.hse.template.kafka;

import dev.hse.template.pojo.TemplateRaw;
import dev.hse.template.service.ProcessingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j(topic = "[sourcename][filter][income]")
@Service
@RequiredArgsConstructor
public class KafkaConsumerService {

    private final ProcessingService processingService;

    @KafkaListener(topics = "${filter.source}.${filter.subtheme}.producers.outcome")
    public void consume(TemplateRaw templateRaw) {
        log.info("Got from kafka: {} ", templateRaw);
        processingService.process(templateRaw);
    }
}

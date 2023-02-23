package dev.hse.template.service;

import dev.hse.template.kafka.KafkaProducerService;
import dev.hse.template.pojo.TemplateFiltered;
import dev.hse.template.pojo.TemplateRaw;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j(topic = "[sourcename][filter][processing]")
@Service
@RequiredArgsConstructor
public class ProcessingService {

    private final KafkaProducerService kafkaProducerService;

    public void process(TemplateRaw templateRaw) {
        TemplateFiltered templateFiltered = new TemplateFiltered();
        templateFiltered.setTimestamp(templateRaw.getTimestamp());
        kafkaProducerService.send(templateFiltered);
    }
}

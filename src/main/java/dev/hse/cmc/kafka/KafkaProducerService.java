package dev.hse.cmc.kafka;

import dev.hse.cmc.pojo.CryptoCurrencyFiltered;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j(topic = "[cmc][filter][outcome]")
@Service
@RequiredArgsConstructor
public class KafkaProducerService {

    @Value("${filter.source}.${filter.subtheme}.filters.outcome")
    private String outputTopic;
    private final KafkaTemplate<String, CryptoCurrencyFiltered> kafkaTemplate;

    public void send(CryptoCurrencyFiltered cryptoCurrencyFiltered) {
        log.info("Sending to '{}' topic", outputTopic);
        kafkaTemplate.send(outputTopic, cryptoCurrencyFiltered);
    }
}

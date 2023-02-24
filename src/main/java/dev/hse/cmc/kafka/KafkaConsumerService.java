package dev.hse.cmc.kafka;

import dev.hse.cmc.pojo.CryptoCurrencyData;
import dev.hse.cmc.process.ProcessingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j(topic = "[cmc][filter][income]")
@Service
@RequiredArgsConstructor
public class KafkaConsumerService {

    private final ProcessingService processingService;

    @KafkaListener(topics = "${filter.source}.${filter.subtheme}.producers.outcome")
    public void consume(CryptoCurrencyData cryptoCurrencyData) {
        log.info("Got from kafka: {} ", cryptoCurrencyData);
        processingService.process(cryptoCurrencyData);
    }
}

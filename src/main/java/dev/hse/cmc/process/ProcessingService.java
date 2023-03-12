package dev.hse.cmc.process;

import dev.hse.cmc.kafka.KafkaProducerService;
import dev.hse.cmc.pojo.CryptoCurrencyData;
import dev.hse.cmc.pojo.CryptoCurrencyFiltered;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j(topic = "[cmc][filter][processing]")
@Service
@RequiredArgsConstructor
public class ProcessingService {

    private final KafkaProducerService kafkaProducerService;

    public void process(CryptoCurrencyData cryptoCurrencyData) {
        CryptoCurrencyFiltered filtered = FilterMapper.INSTANCE.creatingFilteredFromRawData(
            cryptoCurrencyData);
        kafkaProducerService.send(filtered);
    }
}

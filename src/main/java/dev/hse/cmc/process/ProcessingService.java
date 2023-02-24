package dev.hse.cmc.process;

import dev.hse.cmc.kafka.KafkaProducerService;
import dev.hse.cmc.pojo.CryptoCurrencyData;
import dev.hse.cmc.pojo.CryptoCurrencyFiltered;
import java.time.ZoneId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j(topic = "[cmc][filter][processing]")
@Service
@RequiredArgsConstructor
public class ProcessingService {

    private final KafkaProducerService kafkaProducerService;

    public void process(CryptoCurrencyData cryptoCurrencyData) {
        CryptoCurrencyFiltered filtered = CryptoCurrencyFiltered.builder()
            .symbol(cryptoCurrencyData.getSymbol())
            .vendor(1L)
            .observedAt(cryptoCurrencyData.getQuote().getUsd().getLast_updated().toInstant().atZone(
                ZoneId.of("UTC+3")).toLocalDateTime())
            .maxSupply((long) cryptoCurrencyData.getMax_supply())
            .circulatingSupply((long) cryptoCurrencyData.getCirculating_supply())
            .totalSupply((long) cryptoCurrencyData.getTotal_supply())
            .volume24h(cryptoCurrencyData.getQuote().getUsd().getVolume_24h())
            .marketCap(cryptoCurrencyData.getQuote().getUsd().getMarket_cap())
            .build();

        kafkaProducerService.send(filtered);
    }
}

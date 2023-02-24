package dev.hse.cmc.kafka.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import dev.hse.cmc.kafka.serialization.utils.JsonMapperUtils;
import dev.hse.cmc.pojo.CryptoCurrencyFiltered;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serializer;

@Slf4j(topic = "[cmc][filter][kafka-serializer]")
public class FilteredModelSerializer implements Serializer<CryptoCurrencyFiltered> {

    private final JsonMapper mapper = JsonMapperUtils.getJsonMapper();

    @Override
    public byte[] serialize(String s, CryptoCurrencyFiltered cryptoCurrencyFiltered) {
        try {
            return mapper.writeValueAsBytes(cryptoCurrencyFiltered);
        } catch (JsonProcessingException e) {
            log.error("Error occurred while serializing ", e);
            throw new RuntimeException(e);
        }
    }
}
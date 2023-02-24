package dev.hse.cmc.kafka.serialization;

import com.fasterxml.jackson.databind.json.JsonMapper;
import dev.hse.cmc.kafka.serialization.utils.JsonMapperUtils;
import dev.hse.cmc.pojo.CryptoCurrencyData;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Deserializer;

@Slf4j(topic = "[cmc][filter][kafka-deserializer]")
public class RawModelDeserializer implements Deserializer<CryptoCurrencyData> {

    private final JsonMapper mapper = JsonMapperUtils.getJsonMapper();

    @Override
    public CryptoCurrencyData deserialize(String s, byte[] bytes) {
        try {
            return mapper.readValue(bytes, CryptoCurrencyData.class);
        } catch (IOException e) {
            log.error("Error occurred while deserializing ", e);
            return null;
        }
    }
}
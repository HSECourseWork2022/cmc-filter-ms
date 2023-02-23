package dev.hse.template.kafka.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import dev.hse.template.kafka.serialization.utils.JsonMapperUtils;
import dev.hse.template.pojo.TemplateFiltered;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serializer;

@Slf4j(topic = "[sourcename][filter][kafka-serializer]")
public class FilteredModelSerializer implements Serializer<TemplateFiltered> {

    private final JsonMapper mapper = JsonMapperUtils.getJsonMapper();

    @Override
    public byte[] serialize(String s, TemplateFiltered templateFiltered) {
        try {
            return mapper.writeValueAsBytes(templateFiltered);
        } catch (JsonProcessingException e) {
            log.error("Error occurred while serializing ", e);
            throw new RuntimeException(e);
        }
    }
}
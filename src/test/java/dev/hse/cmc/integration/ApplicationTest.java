package dev.hse.cmc.integration;

import dev.hse.cmc.integration.common.AbstractIntegrationTest;
import dev.hse.cmc.kafka.KafkaProducerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class ApplicationTest extends AbstractIntegrationTest {

    @Autowired
    private KafkaProducerService userKafkaProducer;

    @Test
    void testProduceAndConsumeKafkaMessage() {
    }
}



package dev.hse.cmc.integration;

import dev.hse.cmc.common.TestConstants;
import dev.hse.cmc.integration.common.AbstractIntegrationTest;
import dev.hse.cmc.kafka.KafkaConsumerService;
import dev.hse.cmc.kafka.KafkaProducerService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

class ApplicationTest extends AbstractIntegrationTest {

    @MockBean
    private KafkaProducerService producerService;
    @Autowired
    private KafkaConsumerService consumerService;

    @Test
    void testProduceAndConsumeKafkaMessage() {
        consumerService.consume(TestConstants.TEST_RAW_DATA);
        Mockito.verify(producerService).send(TestConstants.FILTERED_TEST_DATA);
    }
}



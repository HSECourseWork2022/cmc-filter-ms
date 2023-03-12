package dev.hse.cmc.unit;

import dev.hse.cmc.common.TestConstants;
import dev.hse.cmc.pojo.CryptoCurrencyFiltered;
import dev.hse.cmc.process.FilterMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FilterMapperTest {

    @Test
    void filterMapperShouldMapFieldsCorrectly() {
        CryptoCurrencyFiltered actual = FilterMapper.INSTANCE.creatingFilteredFromRawData(
            TestConstants.TEST_RAW_DATA);
        Assertions.assertEquals(TestConstants.FILTERED_TEST_DATA, actual);
    }

}

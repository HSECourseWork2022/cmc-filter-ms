package dev.hse.cmc.common;

import dev.hse.cmc.pojo.CryptoCurrencyData;
import dev.hse.cmc.pojo.CryptoCurrencyFiltered;
import dev.hse.cmc.pojo.Quote;
import dev.hse.cmc.pojo.USD;
import java.sql.Date;
import java.time.Instant;
import java.time.ZoneId;

public class TestConstants {

    public static final CryptoCurrencyData TEST_RAW_DATA = CryptoCurrencyData.builder()
        .symbol("symbol")
        .circulating_supply(12)
        .max_supply(13)
        .quote(Quote.builder()
            .usd(USD.builder()
                .last_updated(Date.from(Instant.now()))
                .market_cap(13)
                .price(13)
                .volume_24h(14)
                .build())
            .build())
        .total_supply(321)
        .build();

    public static final CryptoCurrencyFiltered FILTERED_TEST_DATA = CryptoCurrencyFiltered.builder()
        .symbol(TEST_RAW_DATA.getSymbol())
        .vendor(1L)
        .observedAt(TEST_RAW_DATA.getQuote().getUsd().getLast_updated().toInstant().atZone(
            ZoneId.of("UTC+3")).toLocalDateTime())
        .maxSupply((long) TEST_RAW_DATA.getMax_supply())
        .circulatingSupply((long) TEST_RAW_DATA.getCirculating_supply())
        .totalSupply((long) TEST_RAW_DATA.getTotal_supply())
        .volume24h(TEST_RAW_DATA.getQuote().getUsd().getVolume_24h())
        .marketCap(TEST_RAW_DATA.getQuote().getUsd().getMarket_cap())
        .priceUSD(TEST_RAW_DATA.getQuote().usd.getPrice())
        .build();
}

package dev.hse.cmc.process;

import dev.hse.cmc.pojo.CryptoCurrencyData;
import dev.hse.cmc.pojo.CryptoCurrencyFiltered;
import java.time.LocalDateTime;
import java.time.ZoneId;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FilterMapper {

    FilterMapper INSTANCE = Mappers.getMapper(FilterMapper.class);

    @Mapping(target = "vendor", constant = "1l")
    @Mapping(target = "maxSupply", source = "max_supply")
    @Mapping(target = "circulatingSupply", source = "circulating_supply")
    @Mapping(target = "totalSupply", source = "total_supply")
    @Mapping(target = "priceUSD", source = "quote.usd.price")
    @Mapping(target = "volume24h", source = "quote.usd.volume_24h")
    @Mapping(target = "marketCap", source = "quote.usd.market_cap")
    @Mapping(target = "observedAt", expression = "java(mapLastUpdated(cryptoCurrencyData))")
    CryptoCurrencyFiltered creatingFilteredFromRawData(CryptoCurrencyData cryptoCurrencyData);

    default LocalDateTime mapLastUpdated(CryptoCurrencyData cryptoCurrencyData) {
        return cryptoCurrencyData.getQuote().getUsd().getLast_updated().toInstant()
            .atZone(ZoneId.of("UTC+3")).toLocalDateTime();
    }

}

package dev.hse.cmc.process;

import dev.hse.cmc.pojo.CryptoCurrencyData;
import dev.hse.cmc.pojo.CryptoCurrencyFiltered;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FilterMapper {

    FilterMapper INSTANCE = Mappers.getMapper(FilterMapper.class);

    @Mapping(target = "vendor", constant = "1l")
    @Mapping(target = "observedAt", expression = "java(cryptoCurrencyData.getQuote().getUsd().getLast_updated().toInstant().atZone(java.time.ZoneId.of(\"UTC+3\")).toLocalDateTime())")
    @Mapping(target = "maxSupply", expression = "java((long)cryptoCurrencyData.getMax_supply())")
    @Mapping(target = "circulatingSupply", expression = "java((long)cryptoCurrencyData.getCirculating_supply())")
    @Mapping(target = "totalSupply", expression = "java((long)cryptoCurrencyData.getTotal_supply())")
    @Mapping(target = "priceUSD", expression = "java(cryptoCurrencyData.getQuote().usd.getPrice())")
    @Mapping(target = "volume24h", expression = "java(cryptoCurrencyData.getQuote().getUsd().getVolume_24h())")
    @Mapping(target = "marketCap", expression = "java(cryptoCurrencyData.getQuote().getUsd().getMarket_cap())")
    CryptoCurrencyFiltered creatingFilteredFromRawData(CryptoCurrencyData cryptoCurrencyData);

}

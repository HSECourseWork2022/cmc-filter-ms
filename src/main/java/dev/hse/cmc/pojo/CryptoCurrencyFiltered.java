package dev.hse.cmc.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CryptoCurrencyFiltered {

    @JsonProperty("symbol")
    String symbol;
    @JsonProperty("vendor")
    Long vendor;
    @JsonProperty("observed_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC+3")
    LocalDateTime observedAt;
    @JsonProperty("max_supply")
    Long maxSupply;
    @JsonProperty("circulating_supply")
    Long circulatingSupply;
    @JsonProperty("total_supply")
    Long totalSupply;
    @JsonProperty("price_usd")
    Double priceUSD;
    @JsonProperty("volume_24h")
    Double volume24h;
    @JsonProperty("market_cap")
    Double marketCap;
}

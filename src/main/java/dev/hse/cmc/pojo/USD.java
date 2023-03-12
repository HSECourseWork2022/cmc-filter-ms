package dev.hse.cmc.pojo;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class USD {

    private double price;
    private double volume_24h;
    private double volume_change_24h;
    private double percent_change_1h;
    private double percent_change_24h;
    private double percent_change_7d;
    private double percent_change_30d;
    private double market_cap;
    private int market_cap_dominance;
    private double fully_diluted_market_cap;
    private Date last_updated;
}

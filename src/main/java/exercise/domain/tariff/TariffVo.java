package exercise.domain.tariff;

import lombok.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TariffVo {
    BigInteger id;
    BigInteger brandId;
    BigInteger productId;
    OffsetDateTime startDate;
    OffsetDateTime endDate;
    BigDecimal price;
    String currencyCode;
    String currencySymbol;
    Integer currencyDecimals;
}

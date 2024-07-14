package exercise.domain.tariff.command;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.OffsetDateTime;

@Builder
@Value
public class CreateTariffCommand {
    BigInteger brandId;
    BigInteger productId;
    OffsetDateTime startDate;
    OffsetDateTime endDate;
    BigDecimal price;
    String currencyCode;
}

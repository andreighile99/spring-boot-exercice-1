package exercise.domain.tariff.query;

import lombok.Builder;
import lombok.Value;

import java.math.BigInteger;
import java.time.OffsetDateTime;

@Value
@Builder
public class SearchTariffByDateBrandAndProductQuery {
    OffsetDateTime date;
    BigInteger brandId;
    BigInteger productId;
}

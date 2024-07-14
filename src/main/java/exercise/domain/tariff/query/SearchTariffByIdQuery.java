package exercise.domain.tariff.query;

import lombok.Builder;
import lombok.Value;

import java.math.BigInteger;

@Value
@Builder
public class SearchTariffByIdQuery {
    BigInteger id;
}

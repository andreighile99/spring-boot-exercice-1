package exercise.domain.tariff.command;

import lombok.Builder;
import lombok.Value;

import java.math.BigInteger;

@Builder
@Value
public class DeleteTariffCommand {
    BigInteger id;
}

package exercise.domain.tariff;

import exercise.domain.tariff.command.CreateTariffCommand;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TariffEntityMapper {
    TariffVo map(Tariff entity);

    Tariff map(CreateTariffCommand command);
}

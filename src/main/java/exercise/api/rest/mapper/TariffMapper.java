package exercise.api.rest.mapper;

import exercise.domain.tariff.TariffVo;
import exercise.domain.tariff.command.CreateTariffCommand;
import exercise.model.CreateTariffRequest;
import exercise.model.TariffDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TariffMapper {
    TariffDto map(TariffVo tariffVo);

    CreateTariffCommand map(CreateTariffRequest request);

    //UpdateTariffCommand map(UpdateTariffRequest request);
}

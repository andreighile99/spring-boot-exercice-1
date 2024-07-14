package exercise.domain.tariff.command;

import exercise.domain.tariff.Tariff;
import exercise.domain.tariff.TariffEntityMapper;
import exercise.domain.tariff.TariffVo;
import exercise.domain.tariff.TariffRepository;
import exercise.exception.tariff.TariffCreateException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CreateTariffHandler {
    private final CreateTariffValidator validator;
    private final TariffRepository tariffRepository;
    private final TariffEntityMapper tariffEntityMapper;


    public TariffVo handle(CreateTariffCommand command) throws TariffCreateException {

        validator.validate(command);

        Tariff tariffEntity = tariffRepository.save(Tariff.builder()
                    .brandId(command.getBrandId())
                    .productId(command.getProductId())
                    .startDate(command.getStartDate())
                    .endDate(command.getEndDate())
                    .price(command.getPrice())
                    .currencyCode(command.getCurrencyCode())
                    .build());

        return tariffEntityMapper.map(tariffEntity);

    }
}

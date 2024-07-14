package exercise.domain.tariff.command;

import exercise.domain.tariff.Tariff;
import exercise.domain.tariff.TariffEntityMapper;
import exercise.domain.tariff.TariffRepository;
import exercise.domain.tariff.TariffVo;
import exercise.exception.tariff.TariffSearchException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class UpdateTariffPriceByIdHandler {
    private final UpdateTariffPriceByIdValidator validator;
    private final TariffRepository repository;
    private final TariffEntityMapper mapper;

    public TariffVo handle(UpdateTariffPriceByIdCommand command) {
        validator.validate(command);

        Optional<Tariff> tariffOptional = repository.findById(command.getId());

        if(tariffOptional.isEmpty()){
            throw new TariffSearchException("Tariff with ID: " + command.getId() + "was not found");
        }

        Tariff tariff = tariffOptional.get();

        tariff.setPrice(command.getPrice());

        Tariff savedTariff = repository.save(tariff);

        return mapper.map(savedTariff);
    }

}

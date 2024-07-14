package exercise.domain.tariff.command;

import exercise.domain.tariff.TariffRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DeleteTariffHandler {
    private final DeleteTariffValidator validator;
    private final TariffRepository repository;

    public void handle(DeleteTariffCommand command) {
        validator.validate(command);

        repository.deleteById(command.getId());
    }

}

package exercise.domain.tariff.command;

import exercise.exception.tariff.TariffDeleteException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DeleteTariffValidator {

    public void validate(DeleteTariffCommand command) {
        if (command.getId() == null) {
            throw new TariffDeleteException("Id cannot be null");
        }
    }
}

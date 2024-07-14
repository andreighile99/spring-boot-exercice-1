package exercise.domain.tariff.query;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SearchTariffByIdValidator {

    public void validate(SearchTariffByIdQuery query) {

        //ID is already marked as required in openapi definition
        if (query.getId() == null) {
            throw new IllegalArgumentException("Id is required");
        }
    }
}

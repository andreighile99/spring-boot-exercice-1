package exercise.domain.tariff.query;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SearchTariffByDateBrandAndProductValidator {

    public void validate(SearchTariffByDateBrandAndProductQuery query) {

        if (query.getDate() == null) {
            throw new IllegalArgumentException("Date is required");
        }

        if (query.getBrandId() == null) {
            throw new IllegalArgumentException("Brand is required");
        }

        if (query.getProductId() == null) {
            throw new IllegalArgumentException("Product is required");
        }
    }
}

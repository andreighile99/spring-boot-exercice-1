package exercise.domain.tariff.query;

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
public class SearchTariffByDateBrandAndProductHandler {
    private final SearchTariffByDateBrandAndProductValidator validator;
    private final TariffRepository repository;
    private final TariffEntityMapper mapper;

    public TariffVo handle(SearchTariffByDateBrandAndProductQuery query) {
        validator.validate(query);

        Optional<Tariff> tariff = repository.findByBrandIdAndProductIdAndDateBetween(query.getBrandId(), query.getProductId(), query.getDate());

        if(tariff.isEmpty()){
            throw new TariffSearchException("Tariff not found");
        }

        return mapper.map(tariff.get());

    }
}

package exercise.application.process;

import exercise.domain.tariff.TariffVo;
import exercise.domain.tariff.query.SearchTariffByDateBrandAndProductHandler;
import exercise.domain.tariff.query.SearchTariffByDateBrandAndProductQuery;
import exercise.domain.tariff.query.SearchTariffByIdHandler;
import exercise.domain.tariff.query.SearchTariffByIdQuery;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class TariffProcessIoImpl implements TariffProcessIo {

    private final SearchTariffByIdHandler searchTariffByIdHandler;
    private final SearchTariffByDateBrandAndProductHandler searchTariffByDateBrandAndProductHandler;

    @Override
    public TariffVo getTariffById(SearchTariffByIdQuery query) {

        return searchTariffByIdHandler.handle(query);
    }

    @Override
    public TariffVo getTariffByDateBrandAndProduct(SearchTariffByDateBrandAndProductQuery query) {
        return searchTariffByDateBrandAndProductHandler.handle(query);
    }
}

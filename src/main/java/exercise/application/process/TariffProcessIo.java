package exercise.application.process;

import exercise.domain.tariff.TariffVo;
import exercise.domain.tariff.query.SearchTariffByDateBrandAndProductQuery;
import exercise.domain.tariff.query.SearchTariffByIdQuery;

public interface TariffProcessIo {
    TariffVo getTariffById(SearchTariffByIdQuery id);
    TariffVo getTariffByDateBrandAndProduct(SearchTariffByDateBrandAndProductQuery query);
}

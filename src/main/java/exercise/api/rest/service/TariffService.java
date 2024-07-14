package exercise.api.rest.service;

import exercise.application.dispatcher.TariffDispatcherIo;
import exercise.application.process.TariffProcessIo;
import exercise.domain.tariff.TariffVo;
import exercise.domain.tariff.command.CreateTariffCommand;
import exercise.domain.tariff.command.DeleteTariffCommand;
import exercise.domain.tariff.command.UpdateTariffPriceByIdCommand;
import exercise.domain.tariff.query.SearchTariffByDateBrandAndProductQuery;
import exercise.domain.tariff.query.SearchTariffByIdQuery;
import exercise.model.CreateTariffRequest;
import exercise.model.CurrencyDto;
import exercise.model.UpdateTariffPriceByIdRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.OffsetDateTime;

@Service
@AllArgsConstructor
public class TariffService {
    private final TariffDispatcherIo tariffDispatcher;
    private final TariffProcessIo tariffProcess;
    private final CurrencyService currencyService;

    public TariffVo createTariff(CreateTariffRequest request) {

        CreateTariffCommand createTariffCommand = CreateTariffCommand.builder()
                .brandId(BigInteger.valueOf(request.getBrandId()))
                .productId(BigInteger.valueOf(request.getProductId()))
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .price(request.getPrice())
                .currencyCode(request.getCurrencyCode())
                .build();

        TariffVo tariffVo = tariffDispatcher.createTariff(createTariffCommand);

        CurrencyDto currency = currencyService.getCurrencyByCode(tariffVo.getCurrencyCode());

        tariffVo.setCurrencySymbol(currency.getSymbol());
        tariffVo.setCurrencyDecimals(currency.getDecimals());

        return tariffVo;
    }

    public TariffVo getTariffById(Integer id) {
        SearchTariffByIdQuery query = SearchTariffByIdQuery.builder()
                .id(BigInteger.valueOf(id))
                .build();

        TariffVo tariffVo = tariffProcess.getTariffById(query);

        CurrencyDto currency = currencyService.getCurrencyByCode(tariffVo.getCurrencyCode());

        tariffVo.setCurrencySymbol(currency.getSymbol());
        tariffVo.setCurrencyDecimals(currency.getDecimals());

        return tariffVo;
    }

    public TariffVo updateTariffPriceById(UpdateTariffPriceByIdRequest request) {
        UpdateTariffPriceByIdCommand updateTariffPriceByIdCommand = UpdateTariffPriceByIdCommand.builder()
                .id(BigInteger.valueOf(request.getId()))
                .price(request.getPrice())
                .build();

        TariffVo tariffVo = tariffDispatcher.updateTariffPriceById(updateTariffPriceByIdCommand);

        CurrencyDto currency = currencyService.getCurrencyByCode(tariffVo.getCurrencyCode());

        tariffVo.setCurrencySymbol(currency.getSymbol());
        tariffVo.setCurrencyDecimals(currency.getDecimals());

        return tariffVo;
    }

    public void deleteTariff(Integer id) {
        DeleteTariffCommand command = DeleteTariffCommand.builder()
                .id(BigInteger.valueOf(id))
                .build();

        tariffDispatcher.deleteTariff(command);
    }

    public TariffVo getTariffByDateBrandAndProduct(OffsetDateTime date, Integer brandId, Integer productId) {
        SearchTariffByDateBrandAndProductQuery query = SearchTariffByDateBrandAndProductQuery.builder()
                .date(date)
                .brandId(BigInteger.valueOf(brandId))
                .productId(BigInteger.valueOf(productId))
                .build();

        TariffVo tariffVo = tariffProcess.getTariffByDateBrandAndProduct(query);

        CurrencyDto currency = currencyService.getCurrencyByCode(tariffVo.getCurrencyCode());

        tariffVo.setCurrencySymbol(currency.getSymbol());
        tariffVo.setCurrencyDecimals(currency.getDecimals());

        return tariffVo;
    }

}

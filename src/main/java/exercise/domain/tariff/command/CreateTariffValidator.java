package exercise.domain.tariff.command;

import exercise.api.rest.service.CurrencyService;
import exercise.domain.tariff.TariffRepository;
import exercise.exception.tariff.TariffCreateException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CreateTariffValidator {
    TariffRepository tariffRepository;
    CurrencyService currencyService;

    public void validate(CreateTariffCommand command) throws TariffCreateException {

        //When creating a tariff, the fields length should be validated
        validateFieldsLength(command);

        Boolean isStartDateAfterEndDate = command.getStartDate().isAfter(command.getEndDate());
        //When creating a tariff, dates should be validated
        if (isStartDateAfterEndDate) {
            throw new TariffCreateException("Start date cannot be after end date");
        }

        Boolean isEndDateBeforeStartDate = command.getEndDate().isBefore(command.getStartDate());
        if(isEndDateBeforeStartDate){
            throw new TariffCreateException("End date cannot be before start date");
        }

        isTariffAlreadyPresent(command);

        //When creating a tariff, the currency code should be valid
        currencyService.getCurrencies().stream()
                .filter(currencyDto -> currencyDto.getCode().equals(command.getCurrencyCode()))
                .findFirst()
                .orElseThrow(() -> new TariffCreateException("Currency code is not valid"));

    }

    private void isTariffAlreadyPresent(CreateTariffCommand command) {
        //When a tariff is created its dates mus be valid, i.e. there are no tariffs for that pruductId-brandId for the period of time
        tariffRepository.findByBrandIdAndProductId(command.getBrandId(), command.getProductId())
                .stream()
                .filter(tariff -> tariff.getStartDate().isBefore(command.getEndDate()) && tariff.getEndDate().isAfter(command.getStartDate()))
                .findFirst()
                .ifPresent(tariff -> {
                    throw new TariffCreateException("Tariff already exists for the given brand, product and dates");
                });
    }

    private void validateFieldsLength(CreateTariffCommand command) throws TariffCreateException {
        if (command.getBrandId().toString().length() > 38) {
            throw new IllegalArgumentException("Brand ID cannot be more than 38 digits");
        }

        if (command.getProductId().toString().length() > 38) {
            throw new IllegalArgumentException("Product ID cannot be more than 38 digits");
        }

        if (command.getPrice().toString().length() > 38) {
            throw new IllegalArgumentException("Price cannot be more than 38 digits");
        }

        if (command.getCurrencyCode().length() > 3) {
            throw new IllegalArgumentException("Currency code cannot be more than 3 characters");
        }

    }

}


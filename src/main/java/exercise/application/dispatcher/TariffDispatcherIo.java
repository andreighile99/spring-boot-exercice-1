package exercise.application.dispatcher;

import exercise.domain.tariff.TariffVo;
import exercise.domain.tariff.command.CreateTariffCommand;
import exercise.domain.tariff.command.DeleteTariffCommand;
import exercise.domain.tariff.command.UpdateTariffPriceByIdCommand;

public interface TariffDispatcherIo {
    TariffVo createTariff(CreateTariffCommand command);

    TariffVo updateTariffPriceById(UpdateTariffPriceByIdCommand command);

    void deleteTariff(DeleteTariffCommand id);
}

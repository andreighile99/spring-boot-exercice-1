package exercise.application.dispatcher;

import exercise.domain.tariff.TariffVo;
import exercise.domain.tariff.command.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class TariffDispatcherIoImpl implements TariffDispatcherIo{

    private final CreateTariffHandler createTariffHandler;
    private final UpdateTariffPriceByIdHandler updateTariffPriceByIdHandler;
    private final DeleteTariffHandler deleteTariffHandler;

    @Override
    public TariffVo createTariff(CreateTariffCommand command) {
        return createTariffHandler.handle(command);
    }

    @Override
    public TariffVo updateTariffPriceById(UpdateTariffPriceByIdCommand command) {
        return updateTariffPriceByIdHandler.handle(command);
    }

    @Override
    public void deleteTariff(DeleteTariffCommand id) {
        deleteTariffHandler.handle(id);
    }
}

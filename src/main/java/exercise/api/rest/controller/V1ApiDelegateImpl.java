package exercise.api.rest.controller;

import exercise.api.rest.mapper.TariffMapper;
import exercise.api.rest.service.TariffService;
import exercise.domain.tariff.TariffVo;
import exercise.model.CreateTariffRequest;
import exercise.model.TariffDto;
import exercise.model.UpdateTariffPriceByIdRequest;
import exercise.rest.V1ApiDelegate;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
@AllArgsConstructor
public class V1ApiDelegateImpl implements V1ApiDelegate {

    private final TariffService tariffService;
    private final TariffMapper tariffMapper;

    @Override
    public ResponseEntity<TariffDto> createTariff(CreateTariffRequest request) {
        TariffVo tariffVo = tariffService.createTariff(request);
        return ResponseEntity.ok(tariffMapper.map(tariffVo));
    }

    @Override
    public ResponseEntity<TariffDto> getTariffById(Integer id) {
        TariffVo tariffVo = tariffService.getTariffById(id);
        return ResponseEntity.ok(tariffMapper.map(tariffVo));
    }

    @Override
    public ResponseEntity<TariffDto> updateTariffPriceById(UpdateTariffPriceByIdRequest request) {
        TariffVo tariffVo = tariffService.updateTariffPriceById(request);
        return ResponseEntity.ok(tariffMapper.map(tariffVo));
    }

    @Override
    public ResponseEntity<Void> deleteTariff(Integer id) {
        tariffService.deleteTariff(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<TariffDto> getTariffByDateBrandAndProduct(OffsetDateTime date, Integer brandId, Integer productId) {
        TariffVo tariffVo = tariffService.getTariffByDateBrandAndProduct(date, brandId, productId);
        return ResponseEntity.ok(tariffMapper.map(tariffVo));
    }
}

package com.virtualcave.spring_boot_exercise_1;

import exercise.domain.tariff.Tariff;
import exercise.domain.tariff.TariffEntityMapper;
import exercise.domain.tariff.TariffRepository;
import exercise.domain.tariff.TariffVo;
import exercise.domain.tariff.command.*;
import exercise.exception.tariff.TariffSearchException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.OffsetDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TariffHandlersTest {

    @Mock
    private TariffRepository tariffRepository;

    @Mock
    private TariffEntityMapper tariffEntityMapper;

    @Mock
    private CreateTariffValidator createTariffValidator;

    @Mock
    private UpdateTariffPriceByIdValidator updateTariffPriceByIdValidator;

    @Mock
    private DeleteTariffValidator deleteTariffValidator;

    @InjectMocks
    private CreateTariffHandler createTariffHandler;

    @InjectMocks
    private UpdateTariffPriceByIdHandler updateTariffPriceByIdHandler;

    @InjectMocks
    private DeleteTariffHandler deleteTariffHandler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createTariff_succeeds_whenValidCommand() {
        OffsetDateTime startDate = OffsetDateTime.now();
        OffsetDateTime endDate = startDate.plusDays(1);
        CreateTariffCommand command = CreateTariffCommand.builder()
                .brandId(BigInteger.valueOf(1))
                .productId(BigInteger.valueOf(1))
                .startDate(startDate)
                .endDate(endDate)
                .price(BigDecimal.valueOf(1))
                .currencyCode("EUR")
                .build();
        Tariff tariff = Tariff.builder()
                .id(BigInteger.valueOf(1))
                .brandId(BigInteger.valueOf(1))
                .productId(BigInteger.valueOf(1))
                .startDate(startDate)
                .endDate(endDate)
                .price(BigDecimal.valueOf(1))
                .currencyCode("EUR")
                .build();

        TariffVo expectedVo = TariffVo.builder().
                id(BigInteger.valueOf(1))
                .brandId(BigInteger.valueOf(1))
                .productId(BigInteger.valueOf(1))
                .startDate(startDate)
                .endDate(endDate)
                .price(BigDecimal.valueOf(1))
                .currencyCode("EUR")
                .build();

        when(tariffRepository.save(any(Tariff.class))).thenReturn(tariff);
        when(tariffEntityMapper.map(tariff)).thenReturn(expectedVo);

        TariffVo result = createTariffHandler.handle(command);

        assertEquals(expectedVo, result);
    }

    @Test
    void updateTariffPriceById_succeeds_whenValidCommand() {
        UpdateTariffPriceByIdCommand command = UpdateTariffPriceByIdCommand
                .builder()
                .id(BigInteger.valueOf(1))
                .price(BigDecimal.valueOf(5))
                .build();
        Tariff tariff = Tariff
                .builder()
                .id(BigInteger.valueOf(1))
                .price(BigDecimal.valueOf(5))
                .build();
        TariffVo expectedVo = TariffVo
                .builder()
                .id(BigInteger.valueOf(1))
                .price(BigDecimal.valueOf(5))
                .build();

        when(tariffRepository.findById(command.getId())).thenReturn(Optional.of(tariff));
        when(tariffRepository.save(tariff)).thenReturn(tariff);
        when(tariffEntityMapper.map(tariff)).thenReturn(expectedVo);

        TariffVo result = updateTariffPriceByIdHandler.handle(command);

        assertEquals(expectedVo, result);
    }

    @Test
    void updateTariffPriceById_throwsException_whenTariffNotFound() {
        UpdateTariffPriceByIdCommand command = UpdateTariffPriceByIdCommand
                .builder()
                .id(BigInteger.valueOf(999))
                .price(BigDecimal.valueOf(5))
                .build();

        when(tariffRepository.findById(command.getId())).thenReturn(Optional.empty());

        assertThrows(TariffSearchException.class, () -> updateTariffPriceByIdHandler.handle(command));
    }

    @Test
    void deleteTariff_succeeds_whenValidCommand() {
        DeleteTariffCommand command = DeleteTariffCommand
                .builder()
                .id(BigInteger.valueOf(1))
                .build();

        doNothing().when(tariffRepository).deleteById(command.getId());

        assertDoesNotThrow(() -> deleteTariffHandler.handle(command));
    }

    @Test
    void deleteTariff_throwsException_whenInvalidCommand() {
        DeleteTariffCommand command = DeleteTariffCommand
                .builder()
                .build();

        doThrow(new IllegalArgumentException()).when(tariffRepository).deleteById(command.getId());

        assertThrows(IllegalArgumentException.class, () -> deleteTariffHandler.handle(command));
    }
}
package exercise.domain.tariff;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

public interface TariffRepository extends JpaRepository<Tariff, BigInteger> {

    List<Tariff> findByBrandIdAndProductId(BigInteger brandId, BigInteger productId);

    @Query("SELECT t FROM Tariff t WHERE t.brandId = :brandId AND t.productId = :productId AND :date BETWEEN t.startDate AND t.endDate")
    Optional<Tariff> findByBrandIdAndProductIdAndDateBetween(BigInteger brandId, BigInteger productId, OffsetDateTime date);

}

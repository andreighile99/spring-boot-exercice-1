package exercise.domain.tariff;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.OffsetDateTime;

@Table(name = "T_RATES")
@Entity
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Tariff implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private BigInteger id;
    private BigInteger brandId;
    private BigInteger productId;
    private OffsetDateTime startDate;
    private OffsetDateTime endDate;
    private BigDecimal price;
    private String currencyCode;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public BigInteger getId() {
        return id;
    }

    @Column(name = "brand_id", length = 38)
    public BigInteger getBrandId() {
        return brandId;
    }

    @Column(name = "product_id", length = 38)
    public BigInteger getProductId() {
        return productId;
    }

    @Column(name = "start_date")
    public OffsetDateTime getStartDate() {
        return startDate;
    }

    @Column(name = "end_date")
    public OffsetDateTime getEndDate() {
        return endDate;
    }

    @Column(name = "price", length = 38, scale = 2)
    public BigDecimal getPrice() {
        return price;
    }

    @Column(name = "currency_code", length = 3)
    public String getCurrencyCode() {
        return currencyCode;
    }

}

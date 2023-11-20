package tech.saintbassanaga.gestiondestock.dtos;

import lombok.Builder;
import lombok.Data;
import lombok.Value;
import tech.saintbassanaga.gestiondestock.dtos.SaleLineDto;
import tech.saintbassanaga.gestiondestock.models.Sales;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

/**
 * DTO for {@link Sales}
 */
@Value
@Data
@Builder
public class SalesDto implements Serializable {
    UUID id;
    String code;
    Instant saleDate;
    Integer enterpriseId;
    String comments;
    List<SaleLineDto> saleLines;

    public SalesDto fromEntity(Sales sale) {
        if (sale == null)
            return null;

        return SalesDto.builder()
                .id(sale.getId())
                .code(sale.getCode())
                .saleDate(sale.getSaleDate())
                .enterpriseId(sale.getEnterpriseId())
                .comments(sale.getComments())
                .build();
    }

    public Sales toEntity(SalesDto saleDto) {
        if (saleDto == null)
            return null;

        Sales sales = new Sales();
        sales.setId(saleDto.getId());
        sales.setCode(saleDto.getCode());
        sales.setSaleDate(saleDto.getSaleDate());
        sales.setEnterpriseId(saleDto.getEnterpriseId());
        sales.setComments(saleDto.getComments());

        return sales;
    }
}
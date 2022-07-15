package com.rodtech.javaalgteststips.javaalgteststips.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private String mainDescription;
    private Long code;
    private String commercialDescription;
    private String supplier;
    private String category;
    private String brand;
    private Integer quantity;
    private BigDecimal suggestedPrice;
    private BigDecimal suggestedMargin;
}

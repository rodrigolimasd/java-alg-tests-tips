package com.rodtech.javaalgteststips.javaalgteststips.stream.groupingby;

import com.rodtech.javaalgteststips.javaalgteststips.model.Person;
import com.rodtech.javaalgteststips.javaalgteststips.model.Product;
import com.rodtech.javaalgteststips.javaalgteststips.model.ProductPriceLevel;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@Log4j2
public class GroupingByTest {

    @Test
    public void shouldGroupAndCountListOfString() {
        // given
        var items =
                Arrays.asList("apple", "apple", "banana",
                        "apple", "orange", "banana", "papaya");

        //then
        var result =
                items.stream().collect(
                        Collectors.groupingBy(
                                Function.identity(), Collectors.counting()
                        )
                );

        //linked hashmap to keep ordination
        var finalMap = new LinkedHashMap<>();

        //Sort a map and add to finalMap
        result.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));

        assertEquals("Papaya should 1", 1L, finalMap.get("papaya"));
        assertEquals("Apple should 3", 3L, finalMap.get("apple"));
        assertEquals("Banana should 2", 2L, finalMap.get("banana"));
        assertEquals("Orage should 1", 1L, finalMap.get("orange"));
    }

    @Test
    public void shouldPricesAndMarginBeInLineWithTheLevel(){
        // given
        var listProd = getListProducts();
        var prodPriceLevel = getListProductsPriceLevels(listProd,
                Stream.of(1,2,3).collect(Collectors.toList()));

       var priceByLevels = prodPriceLevel.stream()
                .collect(Collectors.groupingBy(ProductPriceLevel::getLevel));

       // then
        assertEquals("Macbook level 1 price should be 13748.9 ",
                priceByLevels.get(1).stream()
                        .filter(p-> p.getProduct().getCode().equals(12345681L))
                        .findFirst().orElseThrow().getSellingPrice(), BigDecimal.valueOf(13748.9)
        );
        assertEquals("Macbook level 1 margin should be 71.5 ",
                priceByLevels.get(1).stream()
                        .filter(p-> p.getProduct().getCode().equals(12345681L))
                        .findFirst().orElseThrow().getProfitMargin(), BigDecimal.valueOf(71.5)
        );


    }

    private List<ProductPriceLevel> getListProductsPriceLevels(List <Product> products, List<Integer> levels){
        List<ProductPriceLevel> list = new ArrayList<>();

        products.forEach(p->
            levels.forEach(l-> {
                var percent = l * 10.0 / 100;
                var price = p.getSuggestedPrice().doubleValue();
                var priceLevel = price + (price * percent);
                var margin = p.getSuggestedMargin().doubleValue();
                var marginLevel = margin + (margin * percent);

                list.add(ProductPriceLevel.builder()
                        .level(l)
                        .product(p)
                        .sellingPrice(BigDecimal.valueOf(priceLevel))
                        .profitMargin(BigDecimal.valueOf(marginLevel))
                        .build());
            })
        );

        return  list;
    }


    private List<Product> getListProducts(){
        var p1 = Product.builder()
                .mainDescription("Macbook MID 2021 M1 256GB SSD 8GB RAM Retina A234F55")
                .quantity(3560)
                .commercialDescription("Macbook M1 256GB SSD 8GB RAM")
                .code(12345681L)
                .supplier("MTC")
                .category("Eletronics")
                .brand("Apple")
                .suggestedPrice(BigDecimal.valueOf(12499))
                .suggestedMargin(BigDecimal.valueOf(65))
                .build();

        var p2 = Product.builder()
                .mainDescription("Mouse Logitech MK577 Bluetooth 3T")
                .quantity(103456)
                .commercialDescription("Mouse Logitech MK380 B")
                .code(12345682L)
                .supplier("ABC")
                .category("Eletronics")
                .brand("Logitech")
                .suggestedPrice(BigDecimal.valueOf(250))
                .suggestedMargin(BigDecimal.valueOf(45))
                .build();

        var p3 = Product.builder()
                .mainDescription("Keyboard Logitech K380 Bluetooth 3T")
                .quantity(103456)
                .commercialDescription("Keyboard Logitech K380 B")
                .code(12345683L)
                .supplier("ABC")
                .category("Eletronics")
                .brand("Logitech")
                .suggestedPrice(BigDecimal.valueOf(430))
                .suggestedMargin(BigDecimal.valueOf(54))
                .build();

        var p4 = Product.builder()
                .mainDescription("Iphone 13 Pro Max 256GB Blue A54534")
                .quantity(345678)
                .commercialDescription("Iphone 13 Pro Max 256GB Blue")
                .code(12345684L)
                .supplier("MTC")
                .category("Eletronics")
                .suggestedPrice(BigDecimal.valueOf(7800))
                .suggestedMargin(BigDecimal.valueOf(68))
                .brand("Apple")
                .build();

        var p5 = Product.builder()
                .mainDescription("Monitor Samsung 21pol Black 144Hz F63558Gh56")
                .quantity(345678)
                .commercialDescription("Monitor Samsung 21pol Black")
                .code(12345684L)
                .supplier("TLH")
                .category("Eletronics")
                .suggestedPrice(BigDecimal.valueOf(950))
                .suggestedMargin(BigDecimal.valueOf(56))
                .brand("Samsung")
                .build();

        return Stream.of(p1, p2, p3, p4, p5).collect(Collectors.toList());
    }
}

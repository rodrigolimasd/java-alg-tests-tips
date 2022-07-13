package com.rodtech.javaalgteststips.javaalgteststips.stream.groupingby;

import com.rodtech.javaalgteststips.javaalgteststips.model.Person;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.springframework.test.util.AssertionErrors.assertEquals;

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

        assertEquals("Papaya should 1", finalMap.get("papaya"), 1L);
        assertEquals("Apple should 3", finalMap.get("apple"), 3L);
        assertEquals("Banana should 2", finalMap.get("banana"), 2L);
        assertEquals("Orage should 1", finalMap.get("orange"), 1L);
    }
}

package com.rodtech.javaalgteststips.javaalgteststips.stream.groupingby;

import com.rodtech.javaalgteststips.javaalgteststips.model.Person;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
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

        assertEquals("Papaya should 1", result.get("papaya"), 1L);
        assertEquals("Apple should 3", result.get("apple"), 3L);
        assertEquals("Banana should 2", result.get("banana"), 2L);
        assertEquals("Orage should 1", result.get("orange"), 1L);
    }
}

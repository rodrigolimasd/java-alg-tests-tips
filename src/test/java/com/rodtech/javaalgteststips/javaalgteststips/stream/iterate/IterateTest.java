package com.rodtech.javaalgteststips.javaalgteststips.stream.iterate;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.springframework.test.util.AssertionErrors.assertTrue;

public class IterateTest {

    @Test
    public void shouldInterateAndCreateNewStrem(){
        // given
        List<Integer> result = Stream.iterate(1, i -> i <= 20, i -> 2 * i)
                .collect(Collectors.toList());

        // then
        assertTrue("should be 1", result.get(0) == 1);
        assertTrue("should be 2", result.get(1) == 2);
        assertTrue("should be 4", result.get(2) == 4);
        assertTrue("should be 8", result.get(3) == 8);
        assertTrue("should be 16", result.get(4) == 16);

    }
}

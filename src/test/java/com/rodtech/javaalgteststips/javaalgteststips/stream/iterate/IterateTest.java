package com.rodtech.javaalgteststips.javaalgteststips.stream.iterate;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class IterateTest {

    @Test
    public void shouldInterateAndCreateNewStrem(){
        // given
        var result = Stream.iterate(1, i -> i <= 20, i -> 2 * i)
                .collect(Collectors.toList());

        // then
        assertThat(result).containsExactly(1,2,4,8,16);

    }
}

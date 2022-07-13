package com.rodtech.javaalgteststips.javaalgteststips.stream.reduce;

import com.rodtech.javaalgteststips.javaalgteststips.model.Person;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.springframework.test.util.AssertionErrors.assertEquals;

public class ReduceTest {

    @Test
    public void shouldSumAllAges() {
        // given
        var alex = new Person("Alex", 23);
        var john = new Person("John", 40);
        var peter = new Person("Peter", 32);
        var people = Arrays.asList(alex, john, peter);

        // then
        var sumAges = people
                .stream()
                .map(p-> BigDecimal.valueOf(p.getAge()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        assertEquals("Should be 95", BigDecimal.valueOf(95), sumAges);
    }
}

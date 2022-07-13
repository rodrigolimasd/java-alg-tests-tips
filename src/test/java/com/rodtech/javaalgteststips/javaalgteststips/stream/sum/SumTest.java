package com.rodtech.javaalgteststips.javaalgteststips.stream.sum;

import com.rodtech.javaalgteststips.javaalgteststips.model.Person;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.springframework.test.util.AssertionErrors.assertEquals;

public class SumTest {
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
                .mapToInt(Person::getAge)
                .sum();

        assertEquals("Should be 95", 95, sumAges);
    }
}

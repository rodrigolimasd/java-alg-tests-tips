package com.rodtech.javaalgteststips.javaalgteststips.stream.sum;

import com.rodtech.javaalgteststips.javaalgteststips.model.Person;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.util.AssertionErrors.assertEquals;

public class SumTest {
    @Test
    public void shouldSumAllAges() {
        // given
        Person alex = new Person("Alex", 23);
        Person john = new Person("John", 40);
        Person peter = new Person("Peter", 32);
        List<Person> people = Arrays.asList(alex, john, peter);

        // then
        Integer sumAges = people
                .stream()
                .mapToInt(Person::getAge)
                .sum();

        assertEquals("Should be 95", 95, sumAges);
    }
}

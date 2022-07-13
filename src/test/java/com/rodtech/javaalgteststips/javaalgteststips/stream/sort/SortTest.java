package com.rodtech.javaalgteststips.javaalgteststips.stream.sort;

import com.rodtech.javaalgteststips.javaalgteststips.model.Person;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

import static org.springframework.test.util.AssertionErrors.assertEquals;

public class SortTest {

    @Test
    public void shouldSortListByAge() {
        // given
        var alex = new Person("Alex", 23);
        var john = new Person("John", 40);
        var peter = new Person("Peter", 32);
        var people = Arrays.asList(alex, john, peter);

        // then
        people = people
                .stream()
                .sorted(Comparator.comparing(Person::getAge))
                .collect(Collectors.toList());

        assertEquals("Should be John", people.get(2), john);
    }
}

package com.rodtech.javaalgteststips.javaalgteststips.stream.sort;

import com.rodtech.javaalgteststips.javaalgteststips.model.Person;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.test.util.AssertionErrors.assertEquals;

public class SortTest {

    @Test
    public void shouldSortListByAge() {
        // given
        Person alex = new Person("Alex", 23);
        Person john = new Person("John", 40);
        Person peter = new Person("Peter", 32);
        List<Person> people = Arrays.asList(alex, john, peter);

        // then
        people = people
                .stream()
                .sorted(Comparator.comparing(Person::getAge))
                .collect(Collectors.toList());

        assertEquals("Should be John", people.get(2), john);
    }
}

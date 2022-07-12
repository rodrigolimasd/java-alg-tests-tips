package com.rodtech.javaalgteststips.javaalgteststips.stream.takewhile;

import com.rodtech.javaalgteststips.javaalgteststips.model.Person;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.test.util.AssertionErrors.assertTrue;

public class takeWhileTest {

    @Test
    public void shouldTakeAgeLessThan40() {
        // given
        Person alex = new Person("Alex", 23);
        Person john = new Person("John", 40);
        Person peter = new Person("Peter", 32);
        List<Person> people = Arrays.asList(alex, john, peter);

        // then
        List<Person> lessThan40 = people
                .stream()
                .sorted(Comparator.comparing(Person::getAge))
                .takeWhile(p-> p.getAge() < 40)
                .collect(Collectors.toList());

        assertTrue("Everyone should be under 40",
                lessThan40.stream().allMatch(p-> p.getAge() < 40));
        assertTrue("Should take 2 people", lessThan40.size()==2);
    }
}

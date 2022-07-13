package com.rodtech.javaalgteststips.javaalgteststips.stream.takedropwhile;

import com.rodtech.javaalgteststips.javaalgteststips.model.Person;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

import static org.springframework.test.util.AssertionErrors.assertTrue;

public class TakeDropWhileTest {

    @Test
    public void shouldTakeAgeLessThan40() {
        // given
        var alex = new Person("Alex", 23);
        var john = new Person("John", 40);
        var peter = new Person("Peter", 32);
        var people = Arrays.asList(alex, john, peter);

        // then
        var lessThan40 = people
                .stream()
                .sorted(Comparator.comparing(Person::getAge))
                .takeWhile(p-> p.getAge() < 40)
                .collect(Collectors.toList());

        assertTrue("Everyone should be under 40",
                lessThan40.stream().allMatch(p-> p.getAge() < 40));
        assertTrue("Should take 2 people", lessThan40.size()==2);
    }

    @Test
    public void shouldDropAgeGranThan40() {
        // given
        var alex = new Person("Alex", 23);
        var john = new Person("John", 40);
        var peter = new Person("Peter", 32);
        var people = Arrays.asList(alex, john, peter);

        // then
        var lessThan40 = people
                .stream()
                .sorted(Comparator.comparing(Person::getAge))
                .dropWhile(p-> p.getAge() < 40)
                .collect(Collectors.toList());

        assertTrue("Everyone should be 40 years old or older",
                lessThan40.stream().allMatch(p-> p.getAge() <= 40));
        assertTrue("Should take 1 people", lessThan40.size()==1);
    }
}

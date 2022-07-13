package com.rodtech.javaalgteststips.javaalgteststips.stream.minmax;

import com.rodtech.javaalgteststips.javaalgteststips.model.Person;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

import static org.springframework.test.util.AssertionErrors.assertEquals;

public class MinMaxTest {

    @Test
    public void whenListIsOfPersonObjectThenMinCanBeDoneUsingCustomComparatorThroughLambda() {
        // given
        var alex = new Person("Alex", 23);
        var john = new Person("John", 40);
        var peter = new Person("Peter", 32);
        var people = Arrays.asList(alex, john, peter);

        // then
        var minByAge = people
                .stream()
                .min(Comparator.comparing(Person::getAge))
                .orElseThrow(NoSuchElementException::new);

        assertEquals("Should be Alex", alex, minByAge);
    }

    @Test
    public void whenListIsOfPersonObjectThenMaxCanBeDoneUsingCustomComparatorThroughLambda() {
        // given
        var alex = new Person("Alex", 23);
        var john = new Person("John", 40);
        var peter = new Person("Peter", 32);
        var people = Arrays.asList(alex, john, peter);

        // then
        var minByAge = people
                .stream()
                .max(Comparator.comparing(Person::getAge))
                .orElseThrow(NoSuchElementException::new);

        assertEquals("Should be Alex", john, minByAge);
    }
}

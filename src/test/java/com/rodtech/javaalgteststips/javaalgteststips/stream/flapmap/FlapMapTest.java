package com.rodtech.javaalgteststips.javaalgteststips.stream.flapmap;

import com.rodtech.javaalgteststips.javaalgteststips.model.Person;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.test.util.AssertionErrors.assertEquals;

public class FlapMapTest {
    @Test
    public void shouldFindGrandsonRelative() {
        // given
        var alex = new Person("Alex", 23);
        var john = new Person("John", 40);
        var peterGrandSon = new Person("Peter Grandson", 18);
        var peter = new Person("Peter Jr", 32, peterGrandSon);
        peterGrandSon.setRelative(peter);
        var peterFather = new Person("Peter", 73, peter);
        var people = Arrays.asList(alex, john, peter, peterGrandSon, peterFather);

        // then
        var peterGrandSonFiltered = people
                .stream()
                .filter(p-> p.getName().equals("Peter")) //father
                .findFirst()
                .flatMap(a-> Optional.ofNullable(a.getRelative())) //son
                .flatMap(b-> Optional.ofNullable(b.getRelative())) // grandson
                .orElseThrow();

        assertEquals("Should be Peter Grandson", peterGrandSonFiltered, peterGrandSon);
    }
}

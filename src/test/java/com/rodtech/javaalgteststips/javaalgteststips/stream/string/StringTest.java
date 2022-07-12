package com.rodtech.javaalgteststips.javaalgteststips.stream.string;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    public void shouldReturnLinesOfString() {
        // given
        String multilineString = "I'm \n \n your \n father.";
        List<String> lines = multilineString.lines()
                .filter(line -> !line.isBlank())
                .map(String::strip)
                .collect(Collectors.toList());
        // then
        assertThat(lines).containsExactly("i'm", "your", "father. ");
    }
}

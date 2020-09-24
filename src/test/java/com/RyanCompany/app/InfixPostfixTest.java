package com.RyanCompany.app;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;
import java.util.stream.Stream;
import java.util.*;


class InfixPostfixTest
{
    static Stream<Arguments> input_to_infix_test_data() {
        return Stream.of(
                Arguments.of("2 + 3 - 1", Arrays.asList("2", "+", "3", "-", "1")),
                Arguments.of("4 + (2 - 1)", Arrays.asList("4", "+", "(", "2", "-", "1", ")")),
                Arguments.of("((1 + 1))", Arrays.asList("(", "(", "1", "+", "1", ")", ")")),
                Arguments.of("1 + -100 - 10 + (30 - 2)", Arrays.asList("1", "+", "-100", "-", "10", "+", "(", "30", "-", "2", ")"))
        );
    }

    @ParameterizedTest
    @MethodSource("input_to_infix_test_data")
    public void input_to_infix_test(String inputLine, List<String> expectedOutput)
    {
        InfixPostfix converter = new InfixPostfix();
        List<String> infixList = converter.input_to_infix(inputLine);
        assertEquals(infixList, expectedOutput);
    }

    static Stream<Arguments> infix_to_postfix_data() {
        return Stream.of(
                Arguments.of(Arrays.asList("1", "+", "1"), Arrays.asList("1", "1", "+")),
                Arguments.of(Arrays.asList("(", "2", "+", "2", ")", "*", "(", "3", "-", "5", ")"),
                        Arrays.asList("2", "2", "+", "3", "5", "-", "*")),
                Arguments.of(Arrays.asList("(", "(", "1", "+", "2", ")"), null)
                );
    }

    @ParameterizedTest
    @MethodSource("infix_to_postfix_data")
    public void infix_to_postfix_test(List<String> infixList, List<String> expectedOutput)
    {
        InfixPostfix converter = new InfixPostfix();
        List<String> postfixList = converter.infix_to_postfix(infixList);
        System.out.println(postfixList);
        assertEquals(postfixList, expectedOutput);
    }
}
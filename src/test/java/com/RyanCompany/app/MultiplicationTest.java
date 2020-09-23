package com.RyanCompany.app;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.Test;

public class MultiplicationTest
{
	private Multiply multiplicationOperator; 
	private Operand operandOne; 
	private Operand operandTwo;

    // Tests that the compute() method works for addition
    @ParameterizedTest
    @CsvSource({
            "5, 2, 10.0",
            "999, 1, 999.0",
            "-20, -4, 80.0",
            "33, -3, -99.0"
    })
    public void multiply_value_test(double inputOperandOne, double inputOperandTwo, double expectedResult)
    {
        operandOne = new Operand(inputOperandOne);
        operandTwo = new Operand(inputOperandTwo);
        multiplicationOperator = new Multiply(operandOne, operandTwo);
        double computationResult = multiplicationOperator.compute();
        assertTrue(computationResult == expectedResult);
    }

    // Tests that the stringify() method works for addition
    @ParameterizedTest
    @CsvSource({
            "5, 2, 5.0 * 2.0",
            "-10, 3, -10.0 * 3.0",
            "999, -20, 999.0 * -20.0",
            "4.2, -1.11, 4.2 * -1.11"
    })
    public void multiply_stringify_test(double inputOperandOne, double inputOperandTwo, String expectedResult)
    {
        operandOne = new Operand(inputOperandOne);
        operandTwo = new Operand(inputOperandTwo);
        multiplicationOperator = new Multiply(operandOne, operandTwo);
        String computationString = multiplicationOperator.stringify();
        assertEquals(computationString, expectedResult);
    }
} 
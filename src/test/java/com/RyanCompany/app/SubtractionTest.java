package com.RyanCompany.app;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.Test;

public class SubtractionTest
{
	private Subtract subtractionOperator; 
	private Operand operandOne; 
	private Operand operandTwo;

    // Tests that the compute() method works for addition
    @ParameterizedTest
    @CsvSource({
            "5, 2, 3.0",
            "999, 1, 998.0",
            "-50.5, 50.5, -101.0",
            "200.5, -3, 203.5"
    })
    public void subtraction_value_test(double inputOperandOne, double inputOperandTwo, double expectedResult)
    {
        operandOne = new Operand(inputOperandOne);
        operandTwo = new Operand(inputOperandTwo);
        subtractionOperator = new Subtract(operandOne, operandTwo);
        double computationResult = subtractionOperator.compute();
        assertTrue(computationResult == expectedResult);
    }

    // Tests that the stringify() method works for addition
    @ParameterizedTest
    @CsvSource({
            "5, 2, 5.0 - 2.0",
            "-10, 3, -10.0 - 3.0",
            "999, -20, 999.0 - -20.0",
            "4.2, -1.11, 4.2 - -1.11"
    })
    public void subtraction_stringify_test(double inputOperandOne, double inputOperandTwo, String expectedResult)
    {
        operandOne = new Operand(inputOperandOne);
        operandTwo = new Operand(inputOperandTwo);
        subtractionOperator = new Subtract(operandOne, operandTwo);
        String computationString = subtractionOperator.stringify();
        assertEquals(computationString, expectedResult);
    }
}
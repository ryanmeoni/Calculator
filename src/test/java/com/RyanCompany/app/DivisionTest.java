package com.RyanCompany.app;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.Test;

public class DivisionTest
{
	private Divide divisionOperator; 
	private Operand operandOne; 
	private Operand operandTwo;

    // Tests that the compute() method works for division
    @ParameterizedTest
    @CsvSource({
            "5, 2, 2.5",
            "999, 1, 999.0",
            "-50.5, 50.5, -1.0",
            "-500, -5, 100.0"
    })
    public void division_value_test(double inputOperandOne, double inputOperandTwo, double expectedResult)
    {
        operandOne = new Operand(inputOperandOne);
        operandTwo = new Operand(inputOperandTwo);
        divisionOperator = new Divide(operandOne, operandTwo);
        double computationResult = divisionOperator.compute();
        assertTrue(computationResult == expectedResult);
    }

    // Tests that the stringify() method works for division
    @ParameterizedTest
    @CsvSource({
            "5, 2, 5.0 / 2.0",
            "-10, 3, -10.0 / 3.0",
            "999, -20, 999.0 / -20.0",
            "4.2, -1.11, 4.2 / -1.11"
    })
    public void division_stringify_test(double inputOperandOne, double inputOperandTwo, String expectedResult)
    {
        operandOne = new Operand(inputOperandOne);
        operandTwo = new Operand(inputOperandTwo);
        divisionOperator = new Divide(operandOne, operandTwo);
        String computationString = divisionOperator.stringify();
        assertEquals(computationString, expectedResult);
    }
} 
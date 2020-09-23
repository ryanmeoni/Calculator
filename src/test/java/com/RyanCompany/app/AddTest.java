package com.RyanCompany.app;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.Test;

public class AddTest
{
	private Add additionOperator; 
	private Operand operandOne; 
	private Operand operandTwo;

    // Tests that the compute() method works for addition
    @ParameterizedTest
    @CsvSource({
            "5, 2, 7.0",
            "999, 1, 1000.0",
            "-50.5, 50.5, 0.0",
            "200.5, -3, 197.5"
    })
    public void addition_value_test(double inputOperandOne, double inputOperandTwo, double expectedResult)
    {
    	operandOne = new Operand(inputOperandOne);
    	operandTwo = new Operand(inputOperandTwo);
        additionOperator = new Add(operandOne, operandTwo);
    	double computationResult = additionOperator.compute();
    	assertTrue(computationResult == expectedResult);
    }

    // Tests that the stringify() method works for addition
    @ParameterizedTest
    @CsvSource({
            "5, 2, 5.0 + 2.0",
            "-10, 3, -10.0 + 3.0",
            "999, -20, 999.0 + -20.0",
            "4.2, -1.11, 4.2 + -1.11"
    })
    public void addition_stringify_test(double inputOperandOne, double inputOperandTwo, String expectedResult)
    {
    	operandOne = new Operand(inputOperandOne);
    	operandTwo = new Operand(inputOperandTwo);
        additionOperator = new Add(operandOne, operandTwo);
    	String computationString = additionOperator.stringify();
    	assertEquals(computationString, expectedResult);
    }
} 
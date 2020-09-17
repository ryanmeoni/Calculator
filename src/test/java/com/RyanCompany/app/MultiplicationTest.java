package com.RyanCompany.app;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MultiplicationTest
{
	private Multiply multiplicationOperator; 
	private Operand operandOne; 
	private Operand operandTwo;

    // Tests that the compute() method works for multiplication
    @Test
    public void Test_multiplication_by_value_001()
    {
    	operandOne = new Operand(5);
    	operandTwo = new Operand(23);
        multiplicationOperator = new Multiply(operandOne, operandTwo);
    	double computationResult = multiplicationOperator.compute();
    	assertTrue(computationResult == 115);
    }

    @Test
    public void Test_multiplication_by_value_002()
    {
        operandOne = new Operand(55);
        operandTwo = new Operand(-3);
        multiplicationOperator = new Multiply(operandOne, operandTwo);
        double computationResult = multiplicationOperator.compute();
        assertTrue(computationResult == -165);
    }

    // Tests that the stringify() method works for multiplication
    @Test 
    public void Test_multiplication_by_stringify_001()
    {
    	operandOne = new Operand(5);
    	operandTwo = new Operand(2);
        multiplicationOperator = new Multiply(operandOne, operandTwo);
    	String computationString = multiplicationOperator.stringify();
    	assertEquals(computationString, "5.0 * 2.0");
    }

    @Test 
    public void Test_multiplication_by_stringify_002()
    {
        operandOne = new Operand(999);
        operandTwo = new Operand(-5);
        multiplicationOperator = new Multiply(operandOne, operandTwo);
        String computationString = multiplicationOperator.stringify();
        assertEquals(computationString, "999.0 * -5.0");
    }
} 
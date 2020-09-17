package com.RyanCompany.app;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SubtractionTest
{
	private Subtract subtractionOperator; 
	private Operand operandOne; 
	private Operand operandTwo;

    // Tests that the compute() method works for subtraction
    @Test
    public void Test_subtraction_by_value_001()
    {
    	operandOne = new Operand(5);
    	operandTwo = new Operand(2);
        subtractionOperator = new Subtract(operandOne, operandTwo);
    	double computationResult = subtractionOperator.compute();
    	assertTrue(computationResult == 3);
    }

    @Test
    public void Test_subtraction_by_value_002()
    {
        operandOne = new Operand(55);
        operandTwo = new Operand(-3);
        subtractionOperator = new Subtract(operandOne, operandTwo);
        double computationResult = subtractionOperator.compute();
        assertTrue(computationResult == 58);
    }

    // Tests that the stringify() method works for subtraction
    @Test 
    public void Test_subtraction_by_stringify_001()
    {
    	operandOne = new Operand(5);
    	operandTwo = new Operand(2);
        subtractionOperator = new Subtract(operandOne, operandTwo);
    	String computationString = subtractionOperator.stringify();
    	assertEquals(computationString, "5.0 - 2.0");
    }

    @Test 
    public void Test_subtraction_by_stringify_002()
    {
        operandOne = new Operand(999);
        operandTwo = new Operand(-5);
        subtractionOperator = new Subtract(operandOne, operandTwo);
        String computationString = subtractionOperator.stringify();
        assertEquals(computationString, "999.0 - -5.0");
    }
} 
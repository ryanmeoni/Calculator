package com.RyanCompany.app;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class DivisionTest
{
	private Divide divisionOperator; 
	private Operand operandOne; 
	private Operand operandTwo;

    // Tests that the compute() method works for divison
    @Test
    public void Test_division_by_value_001()
    {
    	operandOne = new Operand(1);
    	operandTwo = new Operand(4);
        divisionOperator = new Divide(operandOne, operandTwo);
    	double computationResult = divisionOperator.compute();
    	assertTrue(computationResult == 0.25);
    }

    @Test
    public void Test_division_by_value_002()
    {
        operandOne = new Operand(-10);
        operandTwo = new Operand(2);
        divisionOperator = new Divide(operandOne, operandTwo);
        double computationResult = divisionOperator.compute();
        assertTrue(computationResult == -5);
    }

    // Tests that the stringify() method works for divison
    @Test 
    public void Test_division_by_stringify_001()
    {
    	operandOne = new Operand(5);
    	operandTwo = new Operand(2);
        divisionOperator = new Divide(operandOne, operandTwo);
    	String computationString = divisionOperator.stringify();
    	assertEquals(computationString, "5.0 / 2.0");
    }

    @Test 
    public void Test_division_by_stringify_002()
    {
        operandOne = new Operand(999);
        operandTwo = new Operand(-5);
        divisionOperator = new Divide(operandOne, operandTwo);
        String computationString = divisionOperator.stringify();
        assertEquals(computationString, "999.0 / -5.0");
    }
} 
package com.RyanCompany.app;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AddTest
{
	private Add additionOperator; 
	private Operand operandOne; 
	private Operand operandTwo;

    // Tests that the compute() method works for addition
    @Test
    public void additionValueOne_Test()
    {
    	operandOne = new Operand(5);
    	operandTwo = new Operand(2);
        additionOperator = new Add(operandOne, operandTwo);
    	double computationResult = additionOperator.compute();
    	assertTrue(computationResult == 7);
    }

    @Test
    public void additionValueTwo_Test()
    {
        operandOne = new Operand(11);
        operandTwo = new Operand(-6);
        additionOperator = new Add(operandOne, operandTwo);
        double computationResult = additionOperator.compute();
        assertTrue(computationResult == 5);
    }

    // Tests that the stringify() method works for addition
    @Test 
    public void additionStringifyOne_Test()
    {
    	operandOne = new Operand(5);
    	operandTwo = new Operand(2);
        additionOperator = new Add(operandOne, operandTwo);
    	String computationString = additionOperator.stringify();
    	assertEquals(computationString, "5.0 + 2.0");
    }

    @Test 
    public void additionStringifyTwo_Test()
    {
        operandOne = new Operand(999);
        operandTwo = new Operand(-5);
        additionOperator = new Add(operandOne, operandTwo);
        String computationString = additionOperator.stringify();
        assertEquals(computationString, "999.0 + -5.0");
    }
} 
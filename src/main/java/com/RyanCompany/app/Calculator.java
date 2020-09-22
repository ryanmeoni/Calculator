package com.RyanCompany.app;

import java.util.*;

public class Calculator
{
    Calculator() {}

    // Inputs: Console input line as a String
    // Outputs: List of two lists, one for operands and one for operators
    public List<List<String>> parse_input(String inputLine)
    {
        List<List<String>> result = new ArrayList<List<String>>();

        // Split input line by whitespace delimiters
        String[] inputTokens = inputLine.split("\\s+|)|(");

        // Two arrayLists to hold operators and operands in order. Used to build tree later
        List<String> operatorList = new ArrayList<String>();
        List<String> operandList = new ArrayList<String>();
        // Variables used to help parse input
        boolean validInput = true;
        double Number = Double.MIN_VALUE;

        for (int i = 0; i < inputTokens.length; i++)
        {
            String currToken = inputTokens[i];
            // Handle operators
            if (currToken.equals("+") || currToken.equals("-") || currToken.equals("*") || currToken.equals("/"))
            {
                operatorList.add(currToken);
            }

            // Handle operands, and checks for invalid input
            else
            {
                // Check if current token is a valid number
                try
                {
                    Number = Double.parseDouble(currToken);
                }
                catch (NumberFormatException e)
                {
                    validInput = false;
                }

                if (validInput)
                {
                    operandList.add(currToken);
                }

                // Immediately return null if invalid input
                else
                {
                    return null;
                }

            }
        }
        // Return a list containing the operand list and the operator list
        result.add(operandList);
        result.add(operatorList);
        return result;
    }

    // Inputs: List of operands in order and list of operators in order
    // Outputs: List of two lists, one for operands and one for operators
    public commandArg build_tree(List<String> operandList, List<String> operatorList)
    {
        if (operandList == null || operatorList == null) return null;

        // Check that operand count is exactly 1 more than the operator count, or for a single operand
        if (operandList.size() - 1 != operatorList.size() || operandList.size() <= 1)
        {
            return null;
        }

        commandArg leftChild = null;
        commandArg RightChild = null;
        commandArg root = null;
        for (int i = 0; i < operatorList.size(); i++)
        {
            //The first operator in operatorList needs the first two operands in operand list.
            //This is only true for very first iteration. In other iterations, we build the
            //expression tree moving upwards.
            if (i == 0)
            {
                Double leftOperandValue = Double.parseDouble(operandList.get(0));
                Double rightOperandValue = Double.parseDouble(operandList.get(1));
                Operand currLeftOperand = new Operand(leftOperandValue);
                Operand currRightOperand = new Operand(rightOperandValue);

                String firstOperator = operatorList.get(0);

                if (firstOperator.equals("+")) root = new Add(currLeftOperand, currRightOperand);
                if (firstOperator.equals("-")) root = new Subtract(currLeftOperand, currRightOperand);
                if (firstOperator.equals("/")) root = new Divide(currLeftOperand, currRightOperand);
                if (firstOperator.equals("*")) root = new Multiply(currLeftOperand, currRightOperand);
                leftChild = root;
            }


            //For every following operator, the previous operator node becomes the new left child, and the
            //next operand becomes the right child.
            else {
                //We use the i + 1 index to get each following operand due to getting two operands
                //in the very first iteration of the loop.
                Double rightOperandValue = Double.parseDouble(operandList.get(i + 1));
                Operand currRightOperand = new Operand(rightOperandValue);
                String currOperator = operatorList.get(i);
                if (currOperator.equals("+")) root = new Add(leftChild, currRightOperand);
                if (currOperator.equals("-")) root = new Subtract(leftChild, currRightOperand);
                if (currOperator.equals("/")) root = new Divide(leftChild, currRightOperand);
                if (currOperator.equals("*")) root = new Multiply(leftChild, currRightOperand);
                leftChild = root;
            }
        }
        return root;
    }
}
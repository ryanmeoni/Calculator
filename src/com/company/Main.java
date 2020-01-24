package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        //Get input line from console, split input line by whitespace (later parentheses as well) delimiters
        Scanner scan = new Scanner(System.in);
        String inputLine = scan.nextLine();
        String[] inputTokens = inputLine.split("\\s+");

        for (int i = 0; i < inputTokens.length; i++)
        {
            System.out.println(inputTokens[i]);
        }

        //Two arrayLists to hold operators and operands in order. Used to build tree later
        List<String> operatorList = new ArrayList<String>();
        List<Double> operandList = new ArrayList<Double>();
        //Variables used to help parse input
        boolean validInput = true;
        double Number = Double.MIN_VALUE;

        for (int i = 0; i < inputTokens.length; i++)
        {
            //Handle operators
            if (inputTokens[i].equals("+") || inputTokens[i].equals("-") || inputTokens[i].equals("*") || inputTokens[i].equals("/"))
            {
                operatorList.add(inputTokens[i]);
            }
            //Handle operands
            else
            {
                try
                {
                    Number = Double.parseDouble(inputTokens[i]);
                }

                catch (NumberFormatException e)
                {
                    validInput = false;
                }

                finally
                {
                    if (validInput)
                    {
                        operandList.add(Number);
                    }
                }
            }
        }

        //Another simple check for valid input, operand count must be exactly 1 more than the operator count.
        if (operandList.size() - 1 != operatorList.size())
        {
            validInput = false;
        }

        if (validInput)
        {
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
                    Operand currLeftOperand = new Operand(operandList.get(0));
                    Operand currRightOperand = new Operand(operandList.get(1));

                    String firstOperator = operatorList.get(0);

                    if (firstOperator.equals("+")) root = new Add(currLeftOperand, currRightOperand);
                    if (firstOperator.equals("-")) root = new Subtract(currLeftOperand, currRightOperand);
                    if (firstOperator.equals("/")) root = new Divide(currLeftOperand, currRightOperand);
                    if (firstOperator.equals("*")) root = new Multiply(currLeftOperand, currRightOperand);
                    leftChild = root;
                }


                //For every following operator, the previous operator node becomes the new left child, and the
                //next operand becomes the right child.
                else
                {
                    //We use the i + 1 index to get each following operand due to getting two operands
                    //in the very first iteration of the loop.
                    Operand currRightOperand = new Operand(operandList.get(i + 1));
                    String currOperator = operatorList.get(i);
                    if (currOperator.equals("+")) root = new Add(leftChild, currRightOperand);
                    if (currOperator.equals("-")) root = new Subtract(leftChild, currRightOperand);
                    if (currOperator.equals("/")) root = new Divide(leftChild, currRightOperand);
                    if (currOperator.equals("*")) root = new Multiply(leftChild, currRightOperand);
                    leftChild = root;
                }
            }

            System.out.println(root.compute());
        }
    }
}

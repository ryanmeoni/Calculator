package com.RyanCompany.app;

import java.util.*;

public class InfixPostfix
{
    InfixPostfix() {}

    // Inputs: Single string parsed from original console input line
    // Outputs: ArrayList of strings (operand, operator, or opening/closing parentheses) that were parsed from input string
    public List<String> split_string_by_parentheses(String inputString)
    {
        List<String> parsedInputString = new ArrayList<String>();
        // Separate input string by '(' and ')' delimiters
        StringTokenizer tokenizer = new StringTokenizer(inputString, "()", true);

        while (tokenizer.hasMoreTokens())
        {
            String currToken = tokenizer.nextToken();
            parsedInputString.add(currToken);
        }
        return parsedInputString;
    }

    // Inputs: Input line from console
    // Outputs: ArrayList of strings (operand, operator, or opening/closing parentheses) that were
    // parsed from original console input line. ArrayList can be viewed as 'infix' form of calculation.
    public List<String> input_to_infix(String inputLine)
    {
        String[] inputTokens = inputLine.split("\\s+");
        List<String> infixList = new ArrayList<String>();

        for (String inputToken : inputTokens) {
            List<String> currTokenSplit = split_string_by_parentheses(inputToken);
            for (String s : currTokenSplit) {
                infixList.add(s);
            }
        }

        return infixList;
    }

    // Inputs: current string token used in infix to postfix conversion
    // Outputs: Precedence value of the operator. Currently all operators have same precedence.
    public int precedence(String currToken)
    {
        if ((currToken.equals("+")) || (currToken.equals("-")) || (currToken.equals("*")) || (currToken.equals("/")))
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }

    // Inputs: List of strings representing infix expression of inputted string.
    // Outputs: List of strings representing postfix expression
    public List<String> infix_to_postfix(List<String> infixList)
    {
        if (infixList == null)
        {
            System.out.println("Error, null input to infix_to_postfix()");
            return null;
        }

        Stack<String> theStack = new Stack<String>();
        List<String> postfixList = new ArrayList<String>();

        for (String currElement : infixList) {

            if ((currElement.equals("+")) || (currElement.equals("-")) || (currElement.equals("*")) || (currElement.equals("/"))) {

                if (theStack.size() != 0) {
                    while (precedence(currElement) <= precedence(theStack.peek()) && (theStack.size() != 0)) {
                        String currStackTop = theStack.peek();
                        postfixList.add(currStackTop);
                        theStack.pop();

                        if (theStack.size() == 0) break;
                    }
                }

                theStack.push(currElement);
            } else if (currElement.equals(")")) {
                if (theStack.size() == 0) {
                    System.out.println("Error involving closing parentheses in infix to postfix");
                    return null;
                } else {
                    while ((theStack.peek().equals("(") == false) && (theStack.size() != 0)) {
                        String currStackTop = theStack.peek();
                        postfixList.add(currStackTop);
                        theStack.pop();
                    }
                }

                if (theStack.size() == 0) {
                    System.out.println("Error involving closing parentheses in infix to postfix");
                    return null;
                }

                theStack.pop();
            } else if (currElement.equals("(")) {
                theStack.push(currElement);
            } else {
                postfixList.add(currElement);
            }
        }

        //Put all remaining elements into postfix vector
        if (theStack.size() != 0)
        {
            for (String currStackTop = theStack.peek(); theStack.size() != 0; theStack.pop())
            {
                if (currStackTop.equals(")") || (currStackTop.equals("(")))
                {
                    System.out.println("Error involving putting remaining stack elements to postfix");
                    return null;
                }

                postfixList.add(currStackTop);
            }
        }
        return postfixList;
    }

    // Inputs: List of strings representing postfix expression
    // Outputs: commandArg object serving as the root of the final expression tree
    public commandArg postfix_to_expression_tree(List<String> postfixList) {

        if (postfixList == null)
        {
            System.out.println("Error, null input to postfix_to_expression_tree()");
            return null;
        }

        Stack<commandArg> theStack = new Stack<commandArg>();

        for (String currElement : postfixList) {

            // Handle all operators. If stack top is operator,
            if (currElement.equals("+")) {
                if (theStack.size() < 2) return null;

                commandArg rightChild = theStack.peek();
                theStack.pop();
                commandArg leftChild = theStack.peek();
                theStack.pop();

                commandArg additionOperator = new Add(leftChild, rightChild);

                theStack.push(additionOperator);
            } else if (currElement.equals("-")) {
                if (theStack.size() < 2) return null;

                commandArg rightChild = theStack.peek();
                theStack.pop();
                commandArg leftChild = theStack.peek();
                theStack.pop();

                commandArg subtractionOperator = new Subtract(leftChild, rightChild);

                theStack.push(subtractionOperator);
            } else if (currElement.equals("*")) {
                if (theStack.size() < 2) return null;

                commandArg rightChild = theStack.peek();
                theStack.pop();
                commandArg leftChild = theStack.peek();
                theStack.pop();

                commandArg multiplyOperator = new Multiply(leftChild, rightChild);

                theStack.push(multiplyOperator);
            } else if (currElement.equals("/")) {
                if (theStack.size() < 2) return null;

                commandArg rightChild = theStack.peek();
                theStack.pop();
                commandArg leftChild = theStack.peek();
                theStack.pop();

                commandArg divideOperator = new Divide(leftChild, rightChild);

                theStack.push(divideOperator);
            }

            //else we found operand. Create it and push to stack.
            else {
                try
                {
                    double operandValue = Double.parseDouble(currElement);
                    commandArg operand = new Operand(operandValue);
                    theStack.push(operand);
                }
                catch (NumberFormatException exception)
                {
                    System.out.println("Error in converting String to double in postfix_to_expression_tree()");
                    return null;
                }
            }
        }

        //Top of stack at end of building expression tree should be our root.
        return theStack.peek();
    }
}
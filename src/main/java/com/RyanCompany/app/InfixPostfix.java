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
        // Separate input string by '(' and ')' delimeters
        StringTokenizer tokenizer = new StringTokenizer(inputString, "()", true);

        while (tokenizer.hasMoreTokens())
        {
            String currToken = tokenizer.nextToken();
            parsedInputString.add(currToken);
        }
        return parsedInputString;
    }

    // Inputs: None
    // Outputs: ArrayList of strings (operand, operator, or opening/closing parentheses) that were
    // parsed from original console input line. ArrayList can be viewed as 'infix' form of calculation.
    public List<String> input_to_infix()
    {
        Scanner scan = new Scanner(System.in);
        String inputLine = scan.nextLine();
        String[] inputTokens = inputLine.split("\\s+");
        List<String> parsedInputLine = new ArrayList<String>();

        for (int i = 0; i < inputTokens.length; i++)
        {
            List<String> currTokenSplit = split_string_by_parentheses(inputTokens[i]);
            for (int j = 0; j < currTokenSplit.size(); j++)
            {
                parsedInputLine.add(currTokenSplit.get(j));
            }
        }

        return parsedInputLine;
    }

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

    public List<String> infix_to_postfix(List<String> infixList)
    {
        Stack<String> theStack = new Stack<String>();
        List<String> postfixList = new ArrayList<String>();

        for (int i = 0; i < infixList.size(); i++)
        {

            String currElement = infixList.get(i);

            if ((currElement.equals("+")) || (currElement.equals("-")) || (currElement.equals("*")) || (currElement.equals("/")))
            {

                if (theStack.size() != 0)
                {
                    while (precedence(currElement) <= precedence(theStack.peek()) && (theStack.size() != 0))
                    {
                        String currStackTop = theStack.peek();
                        postfixList.add(currStackTop);
                        theStack.pop();

                        if (theStack.size() == 0) break;
                    }
                }

                theStack.push(currElement);
            }

            else if (currElement.equals(")"))
            {
                if (theStack.size() == 0)
                {
                    System.out.println("Error involving closing parentheses in infix to postfix");
                }
                else
                {
                    while ((theStack.peek().equals("(") == false) && (theStack.size() != 0))
                    {
                        String currStackTop = theStack.peek();
                        postfixList.add(currStackTop);
                        theStack.pop();
                    }
                }

                if (theStack.size() == 0)
                {
                    System.out.println("Error involving closing parentheses in infix to postfix");
                }

                //Remove closing parentheses
                theStack.pop();
            }

            //Push opening parentheses
            else if (currElement.equals("("))
            {
                theStack.push(currElement);
            }

            //Else we have command
            else {
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
                }

                postfixList.add(currStackTop);
            }
        }
        return postfixList;
    }

    public static commandArg postfix_to_expression_tree(List<String> postfixList) {

        Stack<commandArg> theStack = new Stack<commandArg>();

        for (int i = 0; i < postfixList.size(); i++)
        {
            String currElement = postfixList.get(i);

            if (currElement.equals("+"))
            {
                commandArg rightChild = theStack.peek();
                theStack.pop();
                commandArg leftChild = theStack.peek();
                theStack.pop();

                commandArg additionOperator = new Add(leftChild, rightChild);

                theStack.push(additionOperator);
            }
            else if (currElement.equals("-"))
            {
                commandArg rightChild = theStack.peek();
                theStack.pop();
                commandArg leftChild = theStack.peek();
                theStack.pop();

                commandArg subtractionOperator = new Subtract(leftChild, rightChild);

                theStack.push(subtractionOperator);
            }
            else if (currElement.equals("*"))
            {
                commandArg rightChild = theStack.peek();
                theStack.pop();
                commandArg leftChild = theStack.peek();
                theStack.pop();

                commandArg multiplyOperator = new Multiply(leftChild, rightChild);

                theStack.push(multiplyOperator);
            }
            else if (currElement.equals("/"))
            {
                commandArg rightChild = theStack.peek();
                theStack.pop();
                commandArg leftChild = theStack.peek();
                theStack.pop();

                commandArg divideOperator = new Divide(leftChild, rightChild);

                theStack.push(divideOperator);
            }

            //else we found command. Create it and push to stack.
            else
            {
                Double operandValue = Double.parseDouble(currElement);
                commandArg operand = new Operand(operandValue);
                theStack.push(operand);
            }
        }

        //Top of stack at end of postfix expression to expression tree building should be our root.
        commandArg treeRoot = theStack.peek();
        return treeRoot;

    }
}
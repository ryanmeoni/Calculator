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
        boolean invalidInput = false;
        double testNumber = 0;

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
                    testNumber = Double.parseDouble(inputTokens[i]);
                }
                catch (NumberFormatException e)
                {
                    System.out.println("Invalid input, please try again.");
                    invalidInput = true;
                }

                finally
                {
                    if (invalidInput == false)
                    operandList.add(testNumber);
                }
            }
        }
    }
}

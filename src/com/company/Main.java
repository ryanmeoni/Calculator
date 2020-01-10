package com.company;

import javax.swing.plaf.basic.BasicEditorPaneUI;
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
                    operandList.add(Number);
                }
            }

            //Another simple check for valid input, operand count must be exactly 1 more than the operator count.
            if (operandList.size() - 1 != operatorList.size())
            {
                validInput = false;
            }

            if (validInput)
            {
                BaseClass leftChild;
                BaseClass RightChild;
                BaseClass root;

                for(int i = 0; i < operatorList.size(); i++)
                {

                }
            }
        }
    }
}

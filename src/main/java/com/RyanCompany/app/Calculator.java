package com.RyanCompany.app;

import java.util.*;

public class Calculator
{
    Calculator() {}

    // Inputs: None
    //Outputs: Input string to console
    public String get_console_input()
    {
        System.out.println("Enter new calculator operation in format '3 + 3 - 2', with a space in between each argument");
        // Get input string from console
        Scanner scan = new Scanner(System.in);
        String inputLine = scan.nextLine();
        return inputLine;
    }

    // Inputs: Input string from console
    // Outputs: commandArg object that is the root of our expression tree
    public commandArg build_expression_tree(String inputLine)
    {
        InfixPostfix converter = new InfixPostfix();
        List<String> infixList = converter.input_to_infix(inputLine);
        List<String> postfixList = converter.infix_to_postfix(infixList);
        return converter.postfix_to_expression_tree(postfixList);
    }
}
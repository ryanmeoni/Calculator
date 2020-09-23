package com.RyanCompany.app;

import java.util.*;

public class App {

    public static void main(String[] args)
    {
        // Calculator interface
        Calculator theCalc = new Calculator();

        while (true)
        {
            // Get input string from console
            System.out.println("Enter new calculator operation in format '3 + 3 - 2', with a space inbetween each argument");
            InfixPostfix testing = new InfixPostfix();
            List<String> infixList = testing.input_to_infix();

            List<String> postfixList = testing.infix_to_postfix(infixList);

            commandArg treeRoot = testing.postfix_to_expression_tree(postfixList);

            System.out.println(treeRoot.compute());

        }
    }
}

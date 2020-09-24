package com.RyanCompany.app;

import java.util.*;

public class App {

    public static void main(String[] args)
    {
        // Calculator object
        Calculator theCalc = new Calculator();

        while (true)
        {
            String inputLine = theCalc.get_console_input();
            commandArg treeRoot = theCalc.build_expression_tree(inputLine);
            if (treeRoot != null)
            {
                System.out.println(treeRoot.compute());
            }
        }
    }
}

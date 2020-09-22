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
            Scanner scan = new Scanner(System.in);
            String inputLine = scan.nextLine();

            // Get parsed input line, set up fields for tree building
            List<List<String>> parsedInput = theCalc.parseInput(inputLine);
            if (parsedInput != null && parsedInput.size() == 2)
            {
                List<String> operandList = parsedInput.get(0);
                List<String> operatorList = parsedInput.get(1);

                // Build expression tree from parsed input line
                commandArg treeRoot = theCalc.buildTree(operandList, operatorList);

                if (treeRoot != null)
                {
                    System.out.println(treeRoot.compute());
                }
            }
        }
    }
}

package com.company;

public class Operator extends commandArg
{
    commandArg leftChild;
    commandArg rightChild;

    Operator(commandArg leftChild, commandArg rightChild)
    {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public String stringify()
    {
        return "This should never happen";
    }
    public double compute()
    {
        return Double.MIN_VALUE;
    }
}

package com.company;

public class Subtract extends Operator
{
    Subtract(commandArg leftChild, commandArg rightChild)
    {
        super(leftChild, rightChild);
    }

    public String stringify()
    {
        return (this.leftChild.stringify() + " - " + this.rightChild.stringify());
    }

    public double compute()
    {
        return (this.leftChild.compute() - this.rightChild.compute());
    }
}

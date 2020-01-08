package com.company;

public class Subtract extends Operator
{
    Subtract(BaseClass leftChild, BaseClass rightChild)
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

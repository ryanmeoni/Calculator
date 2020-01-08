package com.company;

public class Add extends Operator
{
    Add(BaseClass leftChild, BaseClass rightChild)
    {
        super(leftChild, rightChild);
    }

    public String stringify()
    {
        return (this.leftChild.stringify() + " + " + this.rightChild.stringify());
    }

    public double compute()
    {
        return (this.leftChild.compute() + this.rightChild.compute());
    }
}
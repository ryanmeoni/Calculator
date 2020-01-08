package com.company;

public class Operator extends BaseClass
{
    BaseClass leftChild;
    BaseClass rightChild;

    Operator(BaseClass leftChild, BaseClass rightChild)
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

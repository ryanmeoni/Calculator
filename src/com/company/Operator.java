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
}

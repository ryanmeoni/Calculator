package com.RyanCompany.app;

//Composite pattern base class
public abstract class commandArg
{
    commandArg() {}

    abstract public String stringify();
    abstract public double compute();
}

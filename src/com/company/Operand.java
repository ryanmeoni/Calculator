package com.company;

public class Operand extends commandArg
{
    private double operandValue;

    Operand(double operandValue)
    {
        this.operandValue = operandValue;
    }

     public String stringify()
     {
         return Double.toString(this.operandValue);
     }
     public double compute()
     {
         return this.operandValue;
     }
}

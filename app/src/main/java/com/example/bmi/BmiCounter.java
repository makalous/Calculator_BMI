package com.example.bmi;


public class BmiCounter{

    public float n1, n2;
    public BmiCounter(){}
    public BmiCounter(float l1, float l2){
        n1=l1;
        n2=l2;
    }
    public float BmiCalcMetric(){return n2 / ((n1 / 100) * (n1 / 100));}
    public double BmiCalcImperial(){return (n2*6.3503) / (((n1*2.54) / 100) * ((n1*2.54) / 100));}
}

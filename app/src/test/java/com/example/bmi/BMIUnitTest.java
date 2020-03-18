package com.example.bmi;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class BMIUnitTest {
    BmiCounter counter_test = new BmiCounter(180,81);
    @Test
    public void BmiCalcMetric_isCorrect(){assertEquals(25.000002, counter_test.BmiCalcMetric(), 0.000001);}
    @Test
    public void BmiCalcImperial_isCorrect(){assertEquals(24.607462, (float)counter_test.BmiCalcImperial(),0.00001);}
}
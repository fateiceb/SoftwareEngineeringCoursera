package com.nwnu.test;

import com.nwnu.CalResult;
import com.nwnu.Expression;

public class CalResultTest {
    public static void main(String[] args){
        CalResult calResult = new CalResult();
        Expression expression = new Expression();
        calResult.calResult(expression);
        System.out.println(expression.toString());
    }
}

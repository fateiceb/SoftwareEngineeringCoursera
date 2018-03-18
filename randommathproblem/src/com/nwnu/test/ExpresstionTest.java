package com.nwnu.test;

import com.nwnu.CalResult;
import com.nwnu.Expression;

public class ExpresstionTest {
    public static void main(String[] args) {

        for(int i = 0;i<10;i++) {
            Expression expression = new Expression(3,4);
            CalResult calResult = new CalResult();
            calResult.calResult(expression);
            while (expression.getResult() == null || Integer.parseInt(expression.getResult()) < 0) {
                expression = new Expression(3,3);
                expression.ruleExpression();
                calResult.calResult(expression);
            }
            System.out.println(expression.toString());
        }
    }
}

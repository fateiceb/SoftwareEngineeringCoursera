package com.nwnu;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        String n = null;
        if (args != null) {
            n = args[0];
        }
        int num = 5;
        if (Operand.isNumeric(args[0])){
            num = Integer.parseInt(n);
            if(num < 0|| num > 1000){
                System.out.println("请输入0-1000以内数字");
                return;
            }
        }else{
            System.out.println("请输入数字");
            return;
        }


        PrintStream ps=new PrintStream(new FileOutputStream("result.txt"));
        System.setOut(ps);
        System.out.println("201571030138");
        for(int i = 0;i<num;i++) {
            try {
                Expression expression = new Expression(3, 4);
                CalResult calResult = new CalResult();
                calResult.calResult(expression);
                while (expression.getResult() == null || Integer.parseInt(expression.getResult()) < 0) {
                    expression = new Expression(3, 3);
                    expression.ruleExpression();
                    calResult.calResult(expression);
                }
                System.out.println(expression.toString());
            }catch (Exception e){
                continue;
            }
            }

            for (int i = 0;i<num;i++){
                Expression expression = new Expression(3);
            }

        }

}

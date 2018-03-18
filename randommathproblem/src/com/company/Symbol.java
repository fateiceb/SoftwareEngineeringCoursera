package com.company;

import java.util.Stack;

public class Symbol {
    private String value;
    private int  priority;
    private final static int HIGH_PRIORITY = 3;
    private final static int MIDDLE_PRIORITY = 1;
    private final static int LOW_PRIORITY = 0;
    private static String[] symbols = {"+","-","*","/"};

    public Symbol(){
            randomGenerateSymbolValue();
    }

    //随机生成运算符
    private void randomGenerateSymbolValue(){
            int index = RandomUtil.randomInt(symbols.length);
            this.value = symbols[index];
            this.priority = judgePriority(this.value);
    }

    //判断运算符优先级
    public static int judgePriority(String symbol){
        int priority = LOW_PRIORITY;
        switch (symbol){
            case "+":priority = LOW_PRIORITY;break;
            case "-":priority = LOW_PRIORITY;break;
            case "*":priority = MIDDLE_PRIORITY;break;
            case "/":priority = MIDDLE_PRIORITY;break;
            case "(":priority = -1;break;
            case ")":priority = HIGH_PRIORITY;break;
        }

        return priority;
    }

    public static int calValue(String numa,String numb,String oper){
        int anum = Integer.parseInt(numa);
        int bnum = Integer.parseInt(numb);
        int result = 0;
        switch (oper){
            case "+":result = anum+bnum;break;
            case "-":result = anum-bnum;break;
            case "*":result = anum*bnum;break;
            case "/":result = anum/bnum;break;
        }
        return result;
    }
    public static Boolean isSymbol(String symbol){
        if (symbol.equals("+")||symbol.equals("-")||
                symbol.equals("*")||symbol.equals("/")){
            return true;
        }
        return false;
    }


    @Override
    public String toString() {
        return "Symbol{" +
                "value=" + value +
                ", priority=" + priority +
                '}';
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }


}

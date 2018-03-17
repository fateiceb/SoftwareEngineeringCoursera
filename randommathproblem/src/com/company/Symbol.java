package com.company;

public class Symbol {
    private char value;
    private int  priority;
    private final static int HIGH_PRIORITY = 3;
    private final static int MIDDLE_PRIORITY = 1;
    private final static int LOW_PRIORITY = 0;
    private static char[] symbols = {'+','-','*','/'};

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
    private int judgePriority(char symbol){
        int priority = LOW_PRIORITY;
        switch (symbol){
            case '+':priority = LOW_PRIORITY;break;
            case '-':priority = LOW_PRIORITY;break;
            case '*':priority = MIDDLE_PRIORITY;break;
            case '/':priority = MIDDLE_PRIORITY;break;
        }

        return priority;
    }


    @Override
    public String toString() {
        return "Symbol{" +
                "value=" + value +
                ", priority=" + priority +
                '}';
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }


}

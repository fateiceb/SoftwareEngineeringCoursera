package com.company;


public class Operand {
    private int value;
    private int maxValue;
    private int minValue;

    public Operand(){
        this.value = RandomUtil.randomInt(100)+1;
    }

    public Operand(int minValue,int maxValue){
        this.value = RandomUtil.randomIntScope(minValue,maxValue);
    }

    @Override
    public String toString() {
        return "Operand{" +
                "value=" + value +
                '}';
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }


}

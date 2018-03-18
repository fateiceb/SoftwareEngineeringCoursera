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

    public static boolean isNumeric(String str){
        for (int i = 0; i < str.length(); i++){
            if (!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public static  Boolean isDecimals(String numa,String numb){
        int anum = Integer.parseInt(numa);
        int bnum = Integer.parseInt(numb);
        if(anum%bnum == 0){
            return false;
        }
        return true;
    }

    public static Boolean isMinus(String numa,String numb){
        int anum = Integer.parseInt(numa);
        int bnum = Integer.parseInt(numb);
        if (anum - bnum<0){
            return true;
        }
        return false;
    }
    public void setValue(int value) {
        this.value = value;
    }


}

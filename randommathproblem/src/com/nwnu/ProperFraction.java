package com.nwnu;

public class ProperFraction extends Operand{
    private int numa;
    private int numb;
    public ProperFraction(){
        this.numa = RandomUtil.randomIntScope(1,3);
        this.numb = RandomUtil.randomIntScope(10,30);
        int gcd = gcd(numa,numb);
         this.numa = numa / gcd;
        this.numb = numb / gcd;
    }

    @Override
    public String toString() {
        return this.numa+"/"+this.numb;
    }


    public int getNuma() {
        return numa;
    }

    public void setNuma(int numa) {
        this.numa = numa;
    }

    public int getNumb() {
        return numb;
    }

    public void setNumb(int numb) {
        this.numb = numb;
    }

    public static ProperFraction calProperFraction(ProperFraction a,
                                                   ProperFraction b, Symbol symbol){
        ProperFraction properFraction = null;
        //计算分数加减乘除
        switch (symbol.getValue()){
            case "+":properFraction = fracAdd(a.numa,a.numb,b.numa,b.numb);break;
            case "-":properFraction = fracSub(a.numa,a.numb,b.numa,b.numb);break;
            case "*":properFraction = fracMul(a.numa,a.numb,b.numa,b.numb);break;
            case "/":properFraction = fractDiv(a.numa,a.numb,b.numa,b.numb);break;
        }

        return properFraction;
    }
    static ProperFraction fracAdd(int first_numerator,int first_denominator,int second_numrator,int second_denominator){

        int denominator;
        int numerator;

        if(first_denominator==second_denominator)  //分母相同时加分子
        {
            denominator=first_denominator;
            numerator=first_numerator+second_numrator;
        }
        else  //否则同分比较分子
        {
            denominator=first_denominator*second_denominator;
            numerator=first_numerator*second_denominator+first_denominator*second_numrator;
        }
        int gcd = gcd(numerator,denominator);
        denominator = denominator / gcd;
        numerator = numerator / gcd;
        ProperFraction properFraction = new ProperFraction();
        properFraction.numa = numerator;
        properFraction.numb = denominator;
        return properFraction;

    }
    static ProperFraction fracSub(int first_numerator,int first_denominator,int second_numrator,int second_denominator){

        int denominator;
        int numerator;

        if(first_denominator==second_denominator)  //分母相同时加分子
        {
            denominator=first_denominator;
            numerator=first_numerator-second_numrator;
        }
        else  //否则同分比较分子
        {
            denominator=first_denominator*second_denominator;
            numerator=first_numerator*second_denominator-first_denominator*second_numrator;
        }
        int gcd = gcd(numerator,denominator);
        denominator = denominator / gcd;
        numerator = numerator / gcd;
        ProperFraction properFraction = new ProperFraction();
        properFraction.numa = numerator;
        properFraction.numb = denominator;
        return properFraction;

    }
    static ProperFraction fracMul(int first_numerator,int first_denominator,int second_numerator,int second_denominator){

        int denominator;
        int numerator;


        denominator=first_denominator*second_denominator;
        numerator=first_numerator*second_numerator;

        int gcd = gcd(numerator,denominator);
        denominator = denominator / gcd;
        numerator = numerator / gcd;
        ProperFraction properFraction = new ProperFraction();
        properFraction.numa = numerator;
        properFraction.numb = denominator;
        return properFraction;

    }
    static ProperFraction fractDiv(int first_numerator,int first_denominator,int second_numerator,int second_denominator){


        int denominator;
        int numerator;

        numerator = first_numerator*second_denominator;
        denominator = first_denominator*second_numerator;



        int gcd = gcd(numerator,denominator);
        denominator = denominator / gcd;
        numerator = numerator / gcd;
        ProperFraction properFraction = new ProperFraction();
        properFraction.numa = numerator;
        properFraction.numb = denominator;
        return properFraction;

    }
    static int gcd(int x,int y){
        int r;
        while( y!= 0)
        {
            r = x%y;
            x = y;
            y = r;
        }

        return x;

    }
}

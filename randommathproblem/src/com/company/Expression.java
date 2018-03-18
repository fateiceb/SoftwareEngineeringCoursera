package com.company;

import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.ArrayList;

public class Expression {
    private int minSymbol;
    private int maxSymbol;
    private int symbolLength;
    private int operandLength;
    private int result;
    StringBuilder expressStr ;
    private  ScriptEngineManager scriptEngineManager;
    private ArrayList<Symbol> symbolList;
    private ArrayList<Operand> operandList;
    private ArrayList<String> expressionList;

    public Expression(){
        this.minSymbol = 3;
        this.maxSymbol = 5;
        generateexpression();
    }

    public Expression(int minSymbol,int maxSymbol){
        this.minSymbol = minSymbol;
        this.maxSymbol = maxSymbol;
        generateexpression();
        expressStr = new StringBuilder();
        for (String c : expressionList){
            expressStr.append(String.valueOf(c));
        }
    }


    public void generateexpression(){
        if (expressionList == null){
            expressionList = new ArrayList<>();
        }
        generateSymbolList();
        generateOprandList();
        String operand;
        String symbol;
        for (int i = 0;i<symbolLength;i++){
            operand = String.valueOf(operandList.get(i).getValue());
            symbol = symbolList.get(i).getValue();
            expressionList.add(operand);
            expressionList.add(symbol);
        }
        operand = String.valueOf(operandList.get(operandLength-1).getValue());
        expressionList.add(operand);
        addBracket(RandomUtil.randomInt(3));
        System.out.println(expressionList);
    }
    
    
    public void generateSymbolList(){
        if(symbolList == null){
            symbolList = new ArrayList<>();
        }
        int scope = RandomUtil.randomIntScope(minSymbol,maxSymbol);
        for(int i = 0;i < scope;i++){
            symbolList.add(new Symbol());
        }
        this.symbolLength = symbolList.size(); 
    }
    
    
    public void generateOprandList(){
        if(operandList == null){
            operandList = new ArrayList<>();
        }
        int scope = symbolLength+1;
        for (int i = 0;i<scope;i++){
            operandList.add(new Operand());
        }
        this.operandLength = operandList.size();
    }
    public void addBracket(int bracketNum){

        int braNum = bracketNum;
          for (int i = 0;i<expressionList.size();i++){
              if(braNum == 0){
                  return;
              }
              if (Operand.isNumeric(expressionList.get(i))){
                  expressionList.add(i,"(");
                  expressionList.add(i+4,")");
                  braNum--;
                  i = i+4;
              }

          }


    }
    //规范表达式
    public void ruleExpression(){
        //优先处理括号中内容
        int leftIndex = expressionList.indexOf("(");
        int rightIndex = expressionList.indexOf(")");
        while (leftIndex != -1){
            String numa = expressionList.get(leftIndex+1);
            String numb = expressionList.get(rightIndex-1);
            //检测括号中的运算符，替换负数
            if ("-".equals(expressionList.get(leftIndex + 2))) {
                if (Operand.isMinus(numa,numb)){
                    expressionList.set(rightIndex-1,numa);
                    expressionList.set(leftIndex+1,numb);
                }
                expressionList.set(leftIndex+2,"sub");
                //检测括号中的运算符，替换除法
            }else if ("/".equals(expressionList.get(leftIndex+2))){
                if(Operand.isDecimals(numa,numb)){
                    int a = RandomUtil.randomIntScope(1,20);
                    int b = a*RandomUtil.randomInt(4);
                    expressionList.set(rightIndex-1, String.valueOf(a));
                    expressionList.set(leftIndex+1, String.valueOf(b));
                }
                expressionList.set(leftIndex+2,"div");
            }

            expressionList.set(leftIndex, "a");
            expressionList.set(rightIndex, "b");
            leftIndex = expressionList.indexOf("(");
            rightIndex = expressionList.indexOf(")");
            //将括号替换
        }

        //将括号替换回来
        for(int i = 0;i<expressionList.size();i++){
            if ("a".equals(expressionList.get(i))){
                expressionList.set(i,"(");
            }
            if ("b".equals(expressionList.get(i))){
                expressionList.set(i,")");
            }

        }
        //处理减法
        int subIndex = expressionList.indexOf("-");
        while (subIndex != -1){
            String numa = expressionList.get(subIndex-1);
            String numb = expressionList.get(subIndex+1);
            //检测运算符，替换负数
            if ("-".equals(expressionList.get(subIndex))) {
                if (Operand.isMinus(numa,numb)){
                    expressionList.set(subIndex+1,numa);
                    expressionList.set(subIndex-1,numb);
                }
            }
            expressionList.set(subIndex, "sub");
            subIndex = expressionList.indexOf("-");
        }
        //减法替换回来
        for(int i = 0;i<expressionList.size();i++){
            if ("sub".equals(expressionList.get(i))){
                expressionList.set(i,"-");
            }

        }
        //处理除法
        int divIndex = expressionList.indexOf("/");
        while (divIndex != -1){
            String numa = expressionList.get(divIndex-1);
            String numb = expressionList.get(divIndex+1);
            //检测运算符，替换除数
            if ("/".equals(expressionList.get(divIndex))) {
                if (Operand.isDecimals(numa,numb)){
                    expressionList.set(divIndex+1,numa);
                    expressionList.set(divIndex-1,numb);
                }
            }
            expressionList.set(divIndex, "div");
            divIndex = expressionList.indexOf("/");
        }

        for(int i = 0;i<expressionList.size();i++){
            if ("div".equals(expressionList.get(i))){
                expressionList.set(i,"/");
            }

        }
    }

    public int getMinSymbol() {
        return minSymbol;
    }

    public void setMinSymbol(int minSymbol) {
        this.minSymbol = minSymbol;
    }

    public int getMaxSymbol() {
        return maxSymbol;
    }

    public void setMaxSymbol(int maxSymbol) {
        this.maxSymbol = maxSymbol;
    }

    public int getSymbolLength() {
        return symbolLength;
    }

    public void setSymbolLength(int symbolLength) {
        this.symbolLength = symbolLength;
    }

    public ArrayList<Symbol> getSymbolList() {
        return symbolList;
    }

    public void setSymbolList(ArrayList<Symbol> symbolList) {
        this.symbolList = symbolList;
    }

    public ArrayList<Operand> getOperandList() {
        return operandList;
    }

    public void setOperandList(ArrayList<Operand> operandList) {
        this.operandList = operandList;
    }

    public ArrayList<String> getexpressionList() {
        return expressionList;
    }

    public void setexpressionList(ArrayList<String> expressionList) {
        this.expressionList = expressionList;
    }

    public static void main(String[] args) throws ScriptException {
            Expression expression = new Expression(3,5);

    }
}

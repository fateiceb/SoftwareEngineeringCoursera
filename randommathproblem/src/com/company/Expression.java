package com.company;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.ArrayList;

public class Expression {
    private int minSymbol;
    private int maxSymbol;
    private int symbolLength;
    private int operandLength;
    private int result;
    private ArrayList<Symbol> symbolList;
    private ArrayList<Operand> operandList;
    private ArrayList<Character> expressionList;

    public Expression(){
        this.minSymbol = 3;
        this.maxSymbol = 5;
        generateexpression();
    }

    public Expression(int minSymbol,int maxSymbol){
        this.minSymbol = minSymbol;
        this.maxSymbol = maxSymbol;
        generateexpression();
    }


    public void generateexpression(){
        if (expressionList == null){
            expressionList = new ArrayList<>();
        }
        generateSymbolList();
        generateOprandList();
        char operand;
        char symbol;
        for (int i = 0;i<symbolLength;i++){
            operand = String.valueOf(operandList.get(i).getValue()).charAt(0);
            symbol = symbolList.get(i).getValue();
            expressionList.add(operand);
            expressionList.add(symbol);
        }
        operand = String.valueOf(operandList.get(operandLength-1).getValue()).charAt(0);
        expressionList.add(operand);
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

    public int calResult() throws ScriptException {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("js");
        System.out.println(expressionList);
        StringBuilder expressStr = new StringBuilder();
        for (char c : expressionList){
            expressStr.append(String.valueOf(c));
        }
        System.out.println(expressStr);
        this.result = (int) scriptEngine.eval(expressStr.toString());
        return result;
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

    public ArrayList<Character> getexpressionList() {
        return expressionList;
    }

    public void setexpressionList(ArrayList<Character> expressionList) {
        this.expressionList = expressionList;
    }

    public static void main(String[] args) throws ScriptException {
            Expression expression = new Expression(6,10);
           System.out.println(expression.calResult());

    }
}

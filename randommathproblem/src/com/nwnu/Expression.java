package com.nwnu;

import javax.script.ScriptEngineManager;
import java.util.ArrayList;
import java.util.List;

public class Expression {
    private int minSymbol;
    private int maxSymbol;
    private int symbolLength;
    private int operandLength;
    private String result;
    StringBuilder expressStr ;
    private  ScriptEngineManager scriptEngineManager;
    private ArrayList<Symbol> symbolList;
    private ArrayList<Operand> operandList;
    private ArrayList<String> expressionList;
    //生成默认长度为3-5的表达式
    public Expression(){
        this.minSymbol = 3;
        this.maxSymbol = 5;
        generateexpression();
    }
    //生成默认长度为3-5的表达式
    public Expression(int minSymbol,int maxSymbol){
        this.minSymbol = minSymbol;
        this.maxSymbol = maxSymbol;
        generateexpression();
        expressStr = new StringBuilder();
        for (String c : expressionList){
            expressStr.append(String.valueOf(c));
        }
    }

    public Expression(int length){
        generateProperFraction(RandomUtil.randomIntScope(length-1,length));
    }
    @Override
    public String toString() {
        return transferExpress(expressionList)+"="+result;
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
    }

    //生成运算符
    public void generateSymbolList(){
        if(symbolList == null){
            symbolList = new ArrayList<>();
        }
        //生成运算符数量
        int scope = RandomUtil.randomIntScope(minSymbol,maxSymbol);
        for(int i = 0;i < scope;i++){
            Symbol symbol = new Symbol();
            if (symbol.getValue().equals("/")){
                symbol = new Symbol();
            }
            symbolList.add(new Symbol());
        }
        this.symbolLength = symbolList.size(); 
    }
    
    //生成操作数
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
    //添加空格
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
    //生成分数式子
    public int generateProperFraction(int length){
        operandList = new ArrayList<>();
        symbolList = new ArrayList<>();
        ProperFraction properFraction = null;
        if (length < 2) {
            return 0;
        }
        for (int i = 0;i<length;i++){
            operandList.add(new ProperFraction());
            System.out.print(operandList.get(i));
            if (i<length-1) {
                symbolList.add(new Symbol());
                System.out.print(symbolList.get(i).getValue());
            }


        }
        //计算结果
        properFraction = (ProperFraction) operandList.get(0);
        System.out.print("=");
        for (int i = 1;i<length;i++){
            properFraction = ProperFraction.calProperFraction(properFraction,(ProperFraction)operandList.get(i),
                    symbolList.get(i-1));
        }
        System.out.print(properFraction);
        System.out.println();
        return properFraction.getNumb();

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

                //检测括号中的运算符，替换除法
            }else if ("/".equals(expressionList.get(leftIndex+2))){
                if(Operand.isDecimals(numa,numb)){
                    int a = RandomUtil.randomIntScope(1,20);
                    int b = a*RandomUtil.randomInt(4);
                    expressionList.set(rightIndex-1, String.valueOf(a));
                    expressionList.set(leftIndex+1, String.valueOf(b));
                }

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


    }

    //将数组内容转换为字符串
    public String transferExpress(List<String> array){
        expressStr = new StringBuilder();
        for (String str:array){
            expressStr.append(str);
        }
        return expressStr.toString();
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
    public String getResult() {
        return result;
    }

    public void setResult(String result) {

        this.result = result;
    }
}

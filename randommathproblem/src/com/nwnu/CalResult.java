package com.nwnu;

import java.util.ArrayList;
import java.util.Stack;

public class CalResult {
    private ArrayList<String> expressionList;
    private ArrayList<String> suffix;
    private Stack<String> operStack;
    public CalResult(){

    }
    public ArrayList<String> getSuffix() {
        return suffix;
    }

    //中缀转后缀表达式
    public int Suffix(Expression expression){
        expressionList = expression.getexpressionList();
        operStack  = new Stack<>();
        suffix = new ArrayList<>();

        for (String str:expressionList){
           if(Operand.isNumeric(str)){
               suffix.add(str);
           }else{
               //处理+-*/符号
               if (Symbol.isSymbol(str)){
                   if (operStack.isEmpty()){
                       operStack.push(str);
                       //优先级小
                   }else if (Symbol.judgePriority(str)
                           <= Symbol.judgePriority(operStack.peek())){
                       while (!operStack.isEmpty()&&Symbol.judgePriority(str)
                               <= Symbol.judgePriority(operStack.peek())){
                           suffix.add(operStack.pop());
                       }
                       operStack.push(str);
                   }else {
                       operStack.push(str);
                   }

               }
               if ("(".equals(str)){
                   operStack.push(str);

               }
               if (")".equals(str)){
                   while (!operStack.peek().equals("(")){
                       suffix.add(operStack.peek());
                       operStack.pop();
                   }
                   operStack.pop();

               }
           }
        }

        while (!operStack.isEmpty()){
            suffix.add(operStack.pop());
        }
        return 1;
    }
    //计算逆波兰式
    public Boolean calResult(Expression expression){
        Suffix(expression);
        Stack<String> calStack = new Stack<>();
        for (int i = 0;i<suffix.size();i++){
            if (Operand.isNumeric(suffix.get(i))){
                calStack.push(suffix.get(i));
            }else{
                String numa = calStack.pop();
                String numb = calStack.pop();
                try {
                    //如果结果为小数返回false
                if (suffix.get(i).equals("/")&&Operand.isDecimals(numa,numb)){
                    return false;
                }
                    calStack.push(String.valueOf(Symbol.calValue(numb,numa,suffix.get(i))));
                }catch (Exception e) {
                    return false;
                }
            }
        }
        expression.setResult(calStack.peek());
        return true;
    }


}

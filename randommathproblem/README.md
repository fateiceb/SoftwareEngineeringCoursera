## 小学生四则运算出题程序

#### 1.需求分析

- 基本功能

  * 程序可接收一个输入参数n，然后随机产生n道加减乘除练习题，每个数字在 0 和 100 之间，运算符在3个到5个之间。

  * 为了让小学生得到充分锻炼，每个练习题至少要包含2种运算符。同时，由于小学生没有分数与负数的概念，你所出的练习题在运算过程中不得出现负数与非整数，比如不能出 3/5+2=2.6，2-5+10=7等算式。

  * 练习题生成好后，将你的学号与生成的n道练习题及其对应的正确答案输出到文件“result.txt”中，不要输出额外信息，文件目录与程序目录一致。

  * 当程序接收的参数为4时，以下为输出文件示例。

    > 2018010230
    > 13+17-1=29
    > 11*15-5=160
    > 3+10+4=1
    > 15/5+3-2=4

  * 支持有括号的运算式，包括出题与求解正确答案。注意，算式中存在的括号必须大于2个，且不得超过运算符的个数。

- 附加功能

  * 支持有括号的运算式，包括出题与求解正确答案。注意，算式中存在的括号必须大于2个，且不得超过运算符的个数。
  * 支持有括号的运算式，包括出题与求解正确答案。注意，算式中存在的括号必须大于2个，且不得超过运算符的个数。

- 分析

  根据书上的例子，我认为有必要来分析一下可能会变化的功能需求，减少后期拓展和更改的工作量。毕竟小学生还有家长，老师和校长，站在他们各自的角度，显然程序需要进行拓展和更改，例如：操作数大小，运算符数量等。从小学生角度考虑一下，还是不要有这个软件比较好。虽然这个程序是设计给小学生，但是大部分需求都不是小学生提出来的。

#### 2.功能设计

除去上述的基本功能，根据分析，我认为有几点可能会拓展的功能。

* 操作数大小应该是可控制的，运算符数量可控制。

- 括号应该可以选择是否添加。
- 生成运算题目应该可以选择是哪几种运算符。
- 程序应该有一个更合理的界面。

这几点是我考虑到会添加的功能。基于这几点，我将操作数，运算符，表达式分别表示成类。这样每个地方单独更改时，只需要更改相应类就可以。

####3.设计实现

Operand类是操作数类，包含值，最大值，最小值属性，以及正负检测，数字检测等方法。

ProperFraction类是分数类继承Operand类，包含分子，分母属性。加减乘除，约分，计算等方法。

Symbol类是符号类，包含优先级和值两个属性，以及随机生成值，判断优先级，判断是否为符号等方法。

Expression类是表达式类，里面有符号数量，操作数长度，表达式结果等属性。包含符号数组生成，操作数数组生成，表达式生成，添加空格，分数表达式生成，规范表达式等方法。

CalResult类是结果计算类，包含中缀转变后缀，后缀计算等两个方法。

#### 4.核心代码

计算分数加减乘除：

```java
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
```

生成运算符数组：

```java
public void generateSymbolList(){
    if(symbolList == null){
        symbolList = new ArrayList<>();
    }
    //运算符数量
    int scope = RandomUtil.randomIntScope(minSymbol,maxSymbol);
    for(int i = 0;i < scope;i++){
        Symbol symbol = new Symbol();
        symbolList.add(new Symbol());
    }
    this.symbolLength = symbolList.size(); 
}
```

生成表达式：

```java
public void generateexpression(){
    if (expressionList == null){
        expressionList = new ArrayList<>();
    }
    //生成运算符和操作数数组
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
    //添加空格
    addBracket(RandomUtil.randomInt(3));
}
```

#### 5.总结

程序模块化，我使用的是面向对象的方法，每个类有各自的属性以及方法，职责尽量单一。

####6.展示psp

| PSP2.1                                | 任务内容                                     | 计划完成的时间(min) | 实际完成需要的时间(min) |
| ------------------------------------- | -------------------------------------------- | ------------------- | ----------------------- |
| **PLanning**                          | **计划**                                     | **20**              | **30**                  |
| Estimate                              | 估计这个任务需要多少时间，并规划大致工作步骤 | 20                  | 30                      |
| **Developmet**                        | **开发**                                     | **200**             | **480**                 |
| Analysis                              | 需求分析（包括学习新技术）                   | 20                  | 20                      |
| Design Spec                           | 生成设计文档                                 | 10                  | 5                       |
| Design Revie                          | 设计复审（和同事审核设计文档）               | 10                  | 5                       |
| Coding Standard                       | 代码规范                                     | 5                   | 20                      |
| Design                                | 具体设计                                     | 30                  | 40                      |
| Coding                                | 具体编码                                     | 110                 | 360                     |
| Code Review                           | 代码复审                                     | 5                   | 5                       |
| Test                                  | 测试（自我测试，修改代码，提交修改）         | 10                  | 25                      |
| **Reporting**                         | **报告**                                     | **30**              | **30**                  |
| Test Report                           | 测试报告                                     | 20                  | 20                      |
| Size Measurement                      | 计算工作量                                   | 2                   | 2                       |
| Postmortem & Process Improvement Plan | 事后总结，并提出过程改机计划                 | 8                   | 8                       |
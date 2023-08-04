package com.example.springsourcestudy.service;

import com.example.springsourcestudy.functionInterface.Operation;
import com.example.springsourcestudy.functionInterface.SubStraction;

public class StrategyOperation {
    final static Operation ADD = (a, b) -> a + b;
//    final static Operation SUB = (a, b) -> a - b;
    final static Operation MUL = (a, b) -> a * b;
    /**
     * 函数式接口的实现方式可以通过匿名内部类的方式实现
     */
    final static Operation DIV = new Operation() {
        @Override
        public int operate(int a, int b) {
            return a / b;
        }
    };


    //使用策略模式
    public Operation strategy(String type) {
        return switch (type) {
            case "add" -> ADD;
            //通过普通类的方式实现
            case "sub" -> new SubStraction();
            case "mul" -> MUL;
            case "div" -> DIV;
            default -> throw new RuntimeException("不支持的操作类型");
        };
    }
}

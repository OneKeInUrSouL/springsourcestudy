package com.example.springsourcestudy.service;

import com.example.springsourcestudy.functionInterface.MyMath;

public class Calculator {
    public int Calculate(int a, int b, MyMath math) {
        return math.add(a, b);
    }
}

package com.example.springsourcestudy.functionInterface;

@FunctionalInterface
public interface MyMath {
    int add(int a, int b);

    default int sub(int a, int b) {
        return a + b;
    }
}

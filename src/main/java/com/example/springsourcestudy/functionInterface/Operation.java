package com.example.springsourcestudy.functionInterface;

/**
 * 操作
 *
 * @author OneKeInUrSoul
 * @since 2023/08/04
 */
@FunctionalInterface
public interface Operation {
    int operate(int a, int b);
    // default method
    default int sub(int a, int b) {
        return a + b;
    }
}

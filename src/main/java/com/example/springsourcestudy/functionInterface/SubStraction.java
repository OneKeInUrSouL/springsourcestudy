package com.example.springsourcestudy.functionInterface;

/**
 * 子straction
 *
 * @author OneKeInUrSoul
 * @since 2023/08/04
 */
public class SubStraction implements Operation {
    @Override
    public int operate(int a, int b) {
        return a - b;
    }
}

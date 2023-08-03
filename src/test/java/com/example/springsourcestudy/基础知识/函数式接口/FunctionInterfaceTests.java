package com.example.springsourcestudy.基础知识.函数式接口;

import com.example.springsourcestudy.functionInterface.MyMath;
import com.example.springsourcestudy.service.Calculator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionInterfaceTests {
    // 自定义一个 map 方法，用于将 Function 应用到集合的每个元素上
    private static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        return list.stream().map(function).toList();
    }

    @Test
    void consumer() {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        // 使用 Consumer 接口遍历并输出每个元素
        Consumer<String> printName = (name) -> System.out.println(name);
        names.forEach(printName);
    }

    @Test
    void function() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // 使用 Function 接口将每个数字乘以2，并将结果存储在新的集合中
        Function<Integer, Integer> multiplyByTwo = (number) -> number * 2;
        List<Integer> multipliedNumbers = map(numbers, multiplyByTwo);
        System.out.println(multipliedNumbers); // Output: [2, 4, 6, 8, 10]
    }

    @Test
    void predicate() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Predicate<Integer> isEven = (number) -> number % 2 == 0;
        List<Integer> evenNumbers = numbers.stream().filter(isEven).toList();
        System.out.println(evenNumbers); // Output: [2, 4]
    }

    @Test
    void addTest(){
        MyMath add = (a, b) -> a + b;
        Calculator calculator = new Calculator();
        int calculate = calculator.Calculate(1, 2, add);
        System.out.println(calculate);
    }

    @Test
    void takeTest(){
        MyMath take = (a, b) -> a * b;
        Calculator calculator = new Calculator();
        int calculate = calculator.Calculate(1, 2, take);
        System.out.println(calculate);
    }
}

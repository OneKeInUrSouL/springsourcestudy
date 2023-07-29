package com.example.springsourcestudy.generics;

public class GenericMethod {
    // 泛型方法，参数和返回值都是泛型类型
    public <T> T performAction(T value) {
        // 在这里可以对泛型参数进行操作
        System.out.println("Performing action with: " + value);

        // 返回传入的泛型参数
        return value;
    }

    // 泛型方法，参数是泛型类型，返回值是固定类型
    public <T> void printValue(T value) {
        // 直接输出传入的泛型参数
        System.out.println("Value: " + value);
    }

    // 泛型方法，参数是两种不同泛型类型，返回值是其中一种泛型类型
    public <T, U> T convert(U value, Class<T> targetType) {
        // 在这里可以根据需要进行类型转换
        // 这里只是一个示例，实际上可能需要复杂的类型转换逻辑
        return targetType.cast(value);
    }

    public static void main(String[] args) {
        GenericMethod genericMethod = new GenericMethod();

        // 调用泛型方法，传入的参数是String类型，返回值也是String类型
        String result = genericMethod.performAction("Hello World");
        System.out.println("Result: " + result);

        // 调用泛型方法，传入的参数是Integer类型，返回值是void
        genericMethod.printValue(100);

        // 调用泛型方法，传入的参数是Integer类型，返回值是String类型
        Long convertedValue = genericMethod.convert("100", Long.class);
        System.out.println("Converted value: " + convertedValue);
    }

}
package com.example.springsourcestudy.generics;

/**
 * 泛型接口的实现类，必须要指定泛型类型
 *
 * @author OneKeInUrSouL
 * @since 2023/07/29
 */
public class GenericImpl implements GenericsInterface<String>{
    @Override
    public String getData() {
        return "Hello World";
    }
}

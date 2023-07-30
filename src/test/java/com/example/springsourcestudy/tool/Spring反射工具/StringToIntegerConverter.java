package com.example.springsourcestudy.tool.Spring反射工具;

import org.springframework.beans.factory.config.TypedStringValue;
import org.springframework.core.convert.converter.Converter;

import java.util.Objects;

public class StringToIntegerConverter implements Converter<TypedStringValue, Integer> {
    @Override
    public Integer convert(TypedStringValue source) {
        return Integer.valueOf(Objects.requireNonNull(source.getValue()));
    }
}

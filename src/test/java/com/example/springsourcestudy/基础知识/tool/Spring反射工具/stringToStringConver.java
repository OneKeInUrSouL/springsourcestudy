package com.example.springsourcestudy.基础知识.tool.Spring反射工具;

import org.springframework.beans.factory.config.TypedStringValue;
import org.springframework.core.convert.converter.Converter;

public class stringToStringConver implements Converter<TypedStringValue, String> {
    /**
     * Convert the source object of type {@code S} to target type {@code T}.
     *
     * @param source the source object to convert, which must be an instance of {@code S} (never {@code null})
     * @return the converted object, which must be an instance of {@code T} (potentially {@code null})
     * @throws IllegalArgumentException if the source cannot be converted to the desired target type
     */
    @Override
    public String convert(TypedStringValue source) {
        return source.getValue();
    }
}

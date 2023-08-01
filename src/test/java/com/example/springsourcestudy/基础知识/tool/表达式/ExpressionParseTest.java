package com.example.springsourcestudy.基础知识.tool.表达式;

import org.junit.jupiter.api.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class ExpressionParseTest {
    @Test
    void testExpressionParse() {
        ExpressionParser expressionParse = new SpelExpressionParser();
        Expression expression = expressionParse.parseExpression("1+2");
        System.out.println(expression.getValue());
    }

    @Test
    void testExpressionParse2() {
        ExpressionParser expressionParse = new SpelExpressionParser();
        Expression expression = expressionParse.parseExpression("T(java.lang.Math).random() * 100.0)");
        System.out.println(expression.getValue());
    }

}

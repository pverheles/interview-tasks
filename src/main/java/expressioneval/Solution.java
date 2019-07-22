package expressioneval;
// Given an expression in string, write code to evaluate it.

import org.junit.*;
import org.junit.runner.*;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public double eval(String expression) {
        // Your code goes here.

        List<Token> tokens = new ArrayList<>();
        int i = 0;
        double tmp = 0.0;
        while (i < expression.length()) {
            if (expression.charAt(i) == '*') {
                tmp *= expression.charAt(i + 1)  - '0';
                i += 2;
            } else if (expression.charAt(i) == '/') {
                tmp /= expression.charAt(i + 1)  - '0';
                i += 2;
            } else if (expression.charAt(i) == '+' || expression.charAt(i) == '-') {
                tokens.add(new Token(tmp));
                tokens.add(new Token(expression.charAt(i)));
                i++;
            } else {
                tmp = (double) (expression.charAt(i) - '0');
                i++;
            }
        }
        tokens.add(new Token(tmp));

        double result = tokens.get(0).value;
        for (int k = 1; k < tokens.size() - 1; k += 2) {
            if (tokens.get(k).operator == '+') {
                result += tokens.get(k + 1).value;
            } else {
                result -= tokens.get(k + 1).value;
            }
        }

        return result;
    }


    @Test
    public void testEvalFull() {
        // You can assume that each number is one digit and the
        // expression is well formed.
        String expr = "3+5*3-8/2+2";
        double expected = 16.0;
        double actual = eval(expr);
        Assert.assertEquals(expected, actual, 0.0);
    }

    public static void main(String[] args) {
        JUnitCore.main("expressioneval.Solution");
    }

    private class Token {
        private double value;
        private char operator;

        public Token(char operator) {
            this.operator = operator;
        }

        public Token(double value) {
            this.value = value;
        }
    }
}

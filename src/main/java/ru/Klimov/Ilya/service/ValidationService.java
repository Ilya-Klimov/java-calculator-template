package ru.Klimov.Ilya.service;

import  ru.Klimov.Ilya.exception.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationService  {

    public boolean isArithmeticExpression(String expression) throws  IllegalSymbolException, ParenthesesBalanceException, ArithmeticExpressionException {
       if (!expression.matches("(\\-?\\(*\\-?\\(*(\\d+)(\\.)?(\\d+)?\\)*([\\+\\-\\/\\*])?)+")){
         throw new ArithmeticExpressionException("Введенное выражение не является арифметическим");
       } else if ((expression.charAt(expression.length() - 1) == '/') || (expression.charAt(expression.length() - 1) == '+') ||
               (expression.charAt(expression.length() - 1) == '*') ||(expression.charAt(expression.length() - 1) == '-')){
          throw new IllegalSymbolException("Некорректный символ в конце строки");
        } else {
           if (parenthesesBalance(expression)==0){
               return true;
           } else {
               throw new ParenthesesBalanceException("Баланс скобок нарушен");
           }
       }
    }

    public boolean hasArithmeticOperationError (String expression) {
        Pattern pattern = Pattern.compile("\\(?\\-?(\\d+)(\\.)?(\\d+)?\\)?\\/0");
        Matcher matcher = pattern.matcher(expression);
        if (matcher.find()){
            throw new ArithmeticException("Деление на ноль");
        }
        return false;
    }

    public boolean hasAlternatingMathSymbols(String expression) throws ArithmeticExpressionException {
        Pattern pattern = Pattern.compile("[\\+\\-\\/\\*]{2,}");
        Matcher matcher = pattern.matcher(expression);
        if (matcher.find()){
            throw new ArithmeticExpressionException("Имеется чередование математических знаков");
        }
        return false;
    }

    private int parenthesesBalance(String expression){
        int count = 0;
        for (int i = 0; i< expression.length(); i++) {
            if (expression.charAt(i)=='('){
                count++;
            }
            if (expression.charAt(i)==')'){
                count--;
            }
        }
        return count;
    }
}

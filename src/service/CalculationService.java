package service;

import java.util.EmptyStackException;
import java.util.Stack;

public class CalculationService {
    private  Stack<Double> stack = new Stack<>();

    public double rpnToExpression (String rpn){

        for(String operand:rpn.split(" ")){
            if (operand.matches("\\-?(\\d+)(\\.)?(\\d+)?")){
                stack.push(Double.parseDouble(operand));
            }
            if(operand.matches("[\\-\\*\\+\\/]")){
                double a = stack.pop();
                double b = stack.pop();
                arithmeticOperation(a,b,operand);
            }
        }
        return stack.pop();
    }

    private void arithmeticOperation (double a, double b, String symbol) {

        if (symbol.equals("+")){
            stack.push(b+a);
        }
        if (symbol.equals("-")){
            stack.push(b-a);
        }
        if (symbol.equals("*")){
            stack.push(b*a);
        }
        if (symbol.equals("/")){
            if (a == 0){
                throw new ArithmeticException("Деление на ноль");
            }
            stack.push(b / a);
        }
    }
}

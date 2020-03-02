package ru.Klimov.Ilya.service;

import java.util.Stack;

public class ParsingService {

    public String expressionToRpn (String expression) {
        Stack<Character> stack = new Stack<>();
        String current = "";
        if (expression.charAt(0) == '-'){
            current += "0";
        }
        int priority = 0;
        for (int i = 0; i < expression.length(); i++){
            priority = getPriority(expression.charAt(i));

            if (priority == 0){
                current+=expression.charAt(i);
            }
            if (priority == 1){
                if (expression.charAt(i+1) == '-') {
                    current += '0';
                }
                stack.push(expression.charAt(i));
            }
            if (priority > 1){
                current += ' ';
               while (!stack.empty()) {
                   if (getPriority(stack.peek()) >= priority){
                       current += stack.pop() + " ";
                   } else {
                       break;
                   }
               }
               stack.push(expression.charAt(i));
            }
            if (priority < 0) {
                current += ' ';
                while (getPriority(stack.peek()) != 1){
                    current += stack.pop() + " ";
                }
                stack.pop();
            }
        }
        while (!stack.empty()){
            current += " " + stack.pop();
        }
        return current.replaceAll("\\s+"," ");
    }

    public int getPriority (Character symbol) {
        if ((symbol == '*') || (symbol == '/')){
            return 3;
        }
        if ((symbol == '+') || (symbol == '-')) {
            return 2;
        }
        if (symbol == '(') {
            return 1;
        }
        if (symbol == ')') {
            return -1;
        }
        return 0;
    }
}

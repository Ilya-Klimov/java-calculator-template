package ru.Klimov.Ilya;

import ru.Klimov.Ilya.exception.*;
import ru.Klimov.Ilya.service.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IllegalSymbolException, ParenthesesBalanceException, ArithmeticExpressionException {
        Scanner scanner = new Scanner(System.in);
        CalculationService calculationService = new CalculationService();
        ValidationService validationService = new ValidationService();
        boolean isFinish = false;
        boolean isYOrN;
        String inputExpression;
        String finish = "";
        while (!isFinish) {
            isYOrN = false;
            System.out.print("Введите выражение: ");
            inputExpression = scanner.nextLine().replaceAll("\\s+", "");
            if (new ValidationService().isArithmeticExpression(inputExpression)) {
                if (!validationService.hasArithmeticOperationError(inputExpression) &&
                        (!validationService.hasAlternatingMathSymbols(inputExpression))) {
                    System.out.println("Ответ: " + calculationService.calculate(inputExpression));
                }
            }
            while (!isYOrN) {
                System.out.println("Хотите ввести еще одно выражение? Y/N");
                finish = scanner.nextLine().toUpperCase();
                if (finish.equals("N")) {
                    isYOrN = true;
                    isFinish = true;
                } else if (finish.equals("Y")) {
                    isYOrN = true;
                } else {
                    isYOrN = false;
                }
            }
        }
    }

}

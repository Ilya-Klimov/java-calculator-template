package ru.Klimov.Ilya;
import ru.Klimov.Ilya.exception.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.Klimov.Ilya.service.CalculationService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculationServiceTest {
    private  CalculationService calculationService = new CalculationService();

    @Test
    void testRpnToExpression(){
        assertEquals(-135.7,calculationService.rpnToExpression("78.2 67 + 90 0 190.9 - - -"));
    }
    @ParameterizedTest(name = "{index} => inputExpression = {0}, result = {1}")
    @CsvSource({
            "5 + 25 + 4, 34",
            "5.6 + 2, 7.6",
            "756 + 32, 788"
    })
    void testCalculatePlus(String inputExpression, double result) throws ArithmeticExpressionException {
        assertEquals(result, calculationService.calculate(inputExpression));
    }

    @ParameterizedTest(name = "{index} => inputExpression = {0}, result = {1}")
    @CsvSource({
            "468 - 56.56, 411.44",
            "89 - 987.88, -898.88",
            "78 - 0, 78"
    })
    void testCalculateMinus(String inputExpression, double result) throws ArithmeticExpressionException {
        assertEquals(result, calculationService.calculate(inputExpression));
    }

    @ParameterizedTest(name = "{index} => inputExpression = {0}, result = {1}")
    @CsvSource({
            "78 / 4, 19.5",
            "98.25 / 100, 0.9825",
            "100.1 / 5.5, 18.2"
    })
    void testCalculateDivision(String inputExpression, double result) throws ArithmeticExpressionException {
        assertEquals(result, calculationService.calculate(inputExpression));
    }

    @ParameterizedTest(name = "{index} => inputExpression = {0}, result = {1}")
    @CsvSource({
            "78 * 56, 4368",
            "78.2 * 0, 0",
            "7.89 * 67.2, 530.208"
    })
    void testCalculateMultiplication(String inputExpression, double result) throws ArithmeticExpressionException {
        assertEquals(result, calculationService.calculate(inputExpression));
    }
}

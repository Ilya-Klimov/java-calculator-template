package ru.Klimov.Ilya;
import ru.Klimov.Ilya.exception.*;
import org.junit.jupiter.api.Test;
import ru.Klimov.Ilya.service.ValidationService;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ValidationServiceTest {
    private ValidationService validationService = new ValidationService();

    @Test
    void testIsArithmeticExpression() throws IllegalSymbolException, ParenthesesBalanceException, ArithmeticExpressionException{
        try{
            validationService.isArithmeticExpression("Ab+12-100*2");
            fail("Expected ArithmeticExpressionException");
        }catch (ArithmeticExpressionException e){
            assertNotEquals("", e.getMessage());
        }
        try{
            validationService.isArithmeticExpression("5+678+(34-4)+");
            fail("Expected IllegalSymbolException");
        }catch (IllegalSymbolException e){
            assertNotEquals("", e.getMessage());
        }
        try{
            validationService.isArithmeticExpression("((-4)+23)-5)");
            fail("Expected ParenthesesBalanceException");
        }catch (ParenthesesBalanceException e){
            assertNotEquals("", e.getMessage());
        }
    }

    @Test
    void testHasArithmeticOperationError(){
        try{
            validationService.hasArithmeticOperationError("(505-10)*25-90/0+78-2");
            fail("Expected ArithmeticException");
        } catch (ArithmeticException e){
            assertNotEquals("",e.getMessage());
        }
    }

    @Test
    void testHasAlternatingMathSymbols() throws ArithmeticExpressionException{
        try{
            validationService.hasAlternatingMathSymbols("679-(-4+5)/+5");
            fail("Expected ArithmeticExpressionException");
        } catch (ArithmeticExpressionException e){
            assertNotEquals("",e.getMessage());
        }
    }
}

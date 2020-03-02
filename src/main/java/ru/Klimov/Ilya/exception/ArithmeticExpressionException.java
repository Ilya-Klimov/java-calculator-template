package ru.Klimov.Ilya.exception;

public class ArithmeticExpressionException extends  Exception {
    public ArithmeticExpressionException() {
    }

    public ArithmeticExpressionException(String message) {
        super(message);
    }

    public ArithmeticExpressionException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArithmeticExpressionException(Throwable cause) {
        super(cause);
    }
}

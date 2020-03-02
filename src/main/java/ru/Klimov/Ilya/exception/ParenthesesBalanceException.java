package ru.Klimov.Ilya.exception;

public class ParenthesesBalanceException extends Exception {
    public ParenthesesBalanceException() {
    }

    public ParenthesesBalanceException(String message) {
        super(message);
    }

    public ParenthesesBalanceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParenthesesBalanceException(Throwable cause) {
        super(cause);
    }
}

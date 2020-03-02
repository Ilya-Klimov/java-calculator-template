package ru.Klimov.Ilya.exception;

public class IllegalSymbolException extends Exception {
    public IllegalSymbolException() {
    }

    public IllegalSymbolException(String message) {
        super(message);
    }

    public IllegalSymbolException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalSymbolException(Throwable cause) {
        super(cause);
    }
}

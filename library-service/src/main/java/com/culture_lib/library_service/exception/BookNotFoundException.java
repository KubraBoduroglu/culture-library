package com.culture_lib.library_service.exception;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String s) {
        super(s);
    }

    private ExceptionMessage exceptionMessage;
    public ExceptionMessage getExceptionMessage() {
        return exceptionMessage;
    }

    public BookNotFoundException(ExceptionMessage exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public BookNotFoundException(String message, ExceptionMessage exceptionMessage) {
        super(message);
        this.exceptionMessage = exceptionMessage;
    }
}

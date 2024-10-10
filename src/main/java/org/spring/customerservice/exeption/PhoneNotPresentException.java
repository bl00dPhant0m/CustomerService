package org.spring.customerservice.exeption;

public class PhoneNotPresentException extends RuntimeException {
    public PhoneNotPresentException(String message) {
        super(message);
    }

    public PhoneNotPresentException(String message, Throwable cause) {
        super(message, cause);
    }
}

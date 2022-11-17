package com.gaurav.quoraapp.error;

public class QuoraException extends RuntimeException{
    public QuoraException(String exMessage, Exception exception) {
        super(exMessage, exception);
    }
    public QuoraException(String exMessage) {
        super(exMessage);
    }
}

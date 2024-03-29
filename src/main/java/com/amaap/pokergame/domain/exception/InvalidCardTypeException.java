package com.amaap.pokergame.domain.exception;

public class InvalidCardTypeException extends Exception {
    public InvalidCardTypeException(String message){
        super(message);
    }
}

package com.amaap.pokergame;

public class cardAlreadyExistException extends Throwable {
    public cardAlreadyExistException(String message) {
        super(message);
    }
}

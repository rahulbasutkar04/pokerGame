package com.amaap.pokergame.domain.exception;

public class cardAlreadyExistException extends Throwable {
    public cardAlreadyExistException(String message) {
        super(message);
    }
}

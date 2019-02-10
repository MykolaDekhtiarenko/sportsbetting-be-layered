package com.epam.training.sportsbetting.core.exeptions;

public class UserWithSuchEmailExistsException extends IllegalArgumentException {

    public UserWithSuchEmailExistsException(String message) {
        super(message);
    }
}

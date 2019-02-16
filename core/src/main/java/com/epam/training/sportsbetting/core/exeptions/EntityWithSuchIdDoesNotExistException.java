package com.epam.training.sportsbetting.core.exeptions;

public class EntityWithSuchIdDoesNotExistException extends SportBettingGeneralException {

    public EntityWithSuchIdDoesNotExistException(String message) {
        super(message);
    }
}

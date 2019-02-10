package com.epam.training.sportsbetting.presentation.exeptionhandling.handler;

import com.epam.training.sportsbetting.core.exeptions.UserWithSuchEmailExistsException;
import com.epam.training.sportsbetting.presentation.exeptionhandling.dto.ErrorResponseType;
import com.epam.training.sportsbetting.presentation.exeptionhandling.dto.ServerErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;

@ControllerAdvice
public class GeneralExceptionHandler {
    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(RuntimeException.class)
    public ServerErrorResponse handleRuntimeException(final RuntimeException e) throws IOException {
        LOGGER.warn("Message:", e);
        return new ServerErrorResponse(ErrorResponseType.UNEXPECTED, e.getMessage(), e.getClass().getSimpleName());
    }


    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({UserWithSuchEmailExistsException.class, UsernameNotFoundException.class})
    public ServerErrorResponse handleUserWithSuchEmailExistsException(final UserWithSuchEmailExistsException e) throws IOException {
        return new ServerErrorResponse(ErrorResponseType.BUSINESS_LOGIC, e.getMessage(), e.getClass().getSimpleName());
    }

}

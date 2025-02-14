package com.capgemini.wsb.rest.exception.advise;

import com.capgemini.wsb.rest.exception.ValueNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ValueNotFoundAdvise
{

    @ResponseBody
    @ExceptionHandler(ValueNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNotFoundHandler(ValueNotFoundException ex) {
        return ex.getMessage();
    }

}

package com.capgemini.wsb.rest.exception;

public class ValueNotFoundException extends RuntimeException
{

    public ValueNotFoundException(String value) { super("Could not find value " + value + " in column."); }
}



package com.java.training.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by prane on 6/29/2017.
 */
@ResponseStatus(code = HttpStatus.OK)
public class Sucess extends RuntimeException {
    public Sucess(String Message) {
        super(Message);
    }
}

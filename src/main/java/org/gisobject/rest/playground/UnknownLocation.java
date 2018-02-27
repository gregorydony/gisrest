package org.gisobject.rest.playground;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by GIS Object on 23/02/2018.
 */
@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Unable to find coordinates of the given resource")
public class UnknownLocation extends RuntimeException {
    public UnknownLocation (String message) {
        super(message);
    }
}
package org.gisobject.rest.playground;

/**
 * Created by GIS Object on 23/02/2018.
 */

public class UnknownLocation extends RuntimeException {
    public UnknownLocation (String message) {
        super(message);
    }
}
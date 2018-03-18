package org.gisobject.rest.playground.geometry.impl;

import java.math.BigDecimal;

public class BasePoint extends AbstractPoint {

    public BasePoint(BigDecimal x, BigDecimal y) {
        super(x, y);
    }

    public BasePoint(double x, double y) {
        super(x, y);
    }
}

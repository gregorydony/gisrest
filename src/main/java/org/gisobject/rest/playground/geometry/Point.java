package org.gisobject.rest.playground.geometry;

import org.gisobject.rest.playground.geometry.impl.BasePoint;

import java.math.BigDecimal;

public interface Point extends Geometry {

    BigDecimal getX();

    BigDecimal getY();

    static Point from(BigDecimal x, BigDecimal y) {
        return new BasePoint(x, y);
    }

    static Point from(double x, double y) {
        return new BasePoint(x, y);
    }

}

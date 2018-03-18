package org.gisobject.rest.playground.geometry.impl;

import org.gisobject.rest.playground.geometry.Point;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class AbstractPoint implements Point {

    private final BigDecimal x;

    private final BigDecimal y;

    protected AbstractPoint(BigDecimal x, BigDecimal y) {
        this.x = x;
        this.y = y;
    }

    protected AbstractPoint(double x, double y) {
        this(new BigDecimal(x),new BigDecimal(y));
    }

    @Override
    public BigDecimal getX() {
        return x;
    }

    @Override
    public BigDecimal getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractPoint that = (AbstractPoint) o;
        return Objects.equals(x, that.x) &&
                Objects.equals(y, that.y);
    }

    @Override
    public int hashCode() {

        return Objects.hash(x, y);
    }
}

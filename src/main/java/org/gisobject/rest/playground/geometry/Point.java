package org.gisobject.rest.playground.geometry;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.gisobject.rest.playground.geometry.impl.BasePoint;

import java.math.BigDecimal;
import java.util.function.Function;

public interface Point extends Geometry {

    BigDecimal getX();

    BigDecimal getY();

    static Point of(BigDecimal x, BigDecimal y) {
        return new BasePoint(x, y);
    }

    static Point of(double x, double y) {
        return new BasePoint(x, y);
    }

    static <E> Point from(E jsonInstance, Function<E, Point> jsonConsumer) {
        return jsonConsumer.apply(jsonInstance);
    }

}

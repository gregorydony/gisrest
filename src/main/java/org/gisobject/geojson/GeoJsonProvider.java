package org.gisobject.geojson;

import org.gisobject.rest.playground.geometry.Point;

public interface GeoJsonProvider<E> {

    E fromPoint(Point point);

}

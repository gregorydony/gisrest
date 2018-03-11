package org.gisobject.rest.playground;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by GIS Object on 23/02/2018.
 */
@XmlRootElement(name="point")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Point {

    private double x;

    private double y;

    public Point(){}

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
}

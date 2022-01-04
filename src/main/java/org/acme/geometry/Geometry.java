package org.acme.geometry;

public interface Geometry {

    String getType();

    Boolean isEmpty();

    void translate(Double dx, Double dy);

    Geometry clone();

    Envelope getEnvelope();

    void accept(GeometryVisitor visitor);

    void addListener(GeometryListener listener);
    
}

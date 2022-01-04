package org.acme.geometry;

public abstract class AbstractGeometry implements Geometry{

    public abstract Geometry clone();

    public abstract String asText();

    public abstract Envelope getEnvelope();

    public abstract void addListener(GeometryListener listener);

    protected abstract void triggerChange();
    
}

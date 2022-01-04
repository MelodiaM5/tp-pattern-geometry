package org.acme.geometry;

public class GeometryWithCacheEnvelope implements Geometry , GeometryListener{

    private Geometry original;
    private Envelope cachedEnvelope;

    public GeometryWithCacheEnvelope(Geometry original){

        this.original = original;
        this.cachedEnvelope = new Envelope();
    }

    @Override
    public String getType(){

        return original.getType();

    }

    @Override
    public Boolean isEmpty(){

        return original.isEmpty();
    
    }

    @Override
    public void translate(Double dx, Double dy){

        original.translate(dx, dy);

    }

    @Override
    public Envelope getEnvelope(){

        if(cachedEnvelope == null){
            cachedEnvelope = original.getEnvelope();
            return cachedEnvelope;
        }
        return cachedEnvelope;

    }

    @Override
    public Geometry clone(){

        return original.clone();

    }

    @Override
    public void accept(GeometryVisitor visitor){

        original.accept(visitor);
    }

    @Override
    public void onChange(Geometry geometry) {
        int i = 1;

    }

    @Override
    public void addListener(GeometryListener listener) {
        
    }
    
}

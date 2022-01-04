package org.acme.geometry;

public class Point extends AbstractGeometry {

    private Coordinate coordinate;

    public Point(){
        this.coordinate = new Coordinate();
    }

    public Point(Coordinate coordinate){

        if(coordinate == null){
            this.coordinate = new Coordinate();
        }
        else{
            this.coordinate = coordinate;
        }
    }

    public Coordinate getCoordinate() {
        return this.coordinate;
        
    }

    @Override
    public String getType(){
        return "POINT";
    }

    @Override
    public Boolean isEmpty(){
        return this.coordinate.isEmpty();
    }

    @Override
    public void translate(Double dx, Double dy){

        double xTranslate = this.coordinate.getX() + dx;
        double yTranslate = this.coordinate.getY() + dy;

        Coordinate newCoordinate = new Coordinate( xTranslate, yTranslate);

        this.coordinate =newCoordinate;

    }

    @Override
    public Point clone(){

        Double x = this.coordinate.getX();
        Double y = this.coordinate.getY();

        Coordinate cClone = new Coordinate( x, y);
        Point pClone = new Point(cClone);
        
        return pClone;
    }

    @Override
    public Envelope getEnvelope(){

        EnvelopeBuilder envelopeBuilder = new EnvelopeBuilder();

        this.accept(envelopeBuilder);
        
        return envelopeBuilder.build();


    }

    @Override
    public void accept(GeometryVisitor visitor){
        visitor.visit(this);
    }

    @Override
    public String asText(){

        WktVisitor wktVisitor = new WktVisitor();
        wktVisitor.visit(this);
        return wktVisitor.getResult();

    }

    @Override
    public void addListener(GeometryListener listener){

    }

    
    @Override
    protected void triggerChange(){
        
    }
    
    
}

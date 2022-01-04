package org.acme.geometry;

import java.util.ArrayList;


public class LineString extends AbstractGeometry {

    private ArrayList<Point> points;

    public LineString(){

        this.points = new ArrayList<Point>();

    }
    
    public LineString( ArrayList<Point> points){

        if( points == null){
            this.points = new ArrayList<Point>();
        }
        else{
             this.points = points;
        }

       
    }

    public int getNumPoints(){

        return points.size();

    }

    public Point getPointN( int n){
        return this.points.get(n);
    }

    @Override
    public String getType(){
        return "LINESTRING";
    }

    @Override
    public Boolean isEmpty(){
        return this.points.isEmpty();

    }

    @Override
    public void translate(Double dx, Double dy){

        for (Point point : points) {

            point.translate(dx, dy);
            
        }        

    }

    @Override
    public LineString clone(){

        ArrayList<Point> pointsClone = new ArrayList<Point>();

        for (Point point : points) {

            pointsClone.add(point.clone());
            
        }


        LineString lClone = new LineString(pointsClone);
        
        return lClone;
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

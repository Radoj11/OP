package agh.cs.lab4;

import agh.cs.lab2.Position;
import agh.cs.lab5.AbstractWorldMap;

public class RectangularMap extends AbstractWorldMap {
    private final Position max;
    private final Position min=new Position(0,0);

    public RectangularMap(int width, int height){
        super();
        this.max=new Position(width,height);
    }


    @Override
    public boolean canMoveTo(Position position) {
        if(position.smaller(this.max) && position.larger(this.min)){
            if(isOccupied(position))
                return false;
            else
                return true;
        }
        return false;
    }

    @Override
    public String toString(){
        return this.mapVisualizer.draw(this.min,this.max);
    }
}

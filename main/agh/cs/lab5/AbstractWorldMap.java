package agh.cs.lab5;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Position;
import agh.cs.lab3.Car;
import agh.cs.lab4.MapVisualizer;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWorldMap {
    protected List<IMapElement> map = new ArrayList<>();
    protected MapVisualizer mapVisualizer;

    public AbstractWorldMap(){
        this.mapVisualizer = new MapVisualizer(this);
    }

    public boolean isOccupied(Position position) {
        for(IMapElement i : this.map){
            if(i.getPosition().equals(position))
                return true;
        }
        return false;
    }

    public Object objectAt(Position position) {
        for(IMapElement i : this.map){
            if(i.getPosition().equals(position))
                return i;
        }
        return null;
    }

    public boolean canMoveTo(Position position) {
        if(isOccupied(position))
            return false;
        else
            return true;
    }

    public boolean place(Car car) {
        if(canMoveTo(car.getPosition())){
            this.map.add(car);
            return true;
        }
        return false;
    }

    public abstract void run(List<MoveDirection> directions);
}

package agh.cs.lab5;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Position;
import agh.cs.lab3.Car;
import agh.cs.lab4.MapVisualizer;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractWorldMap {
    protected Map<Position,IMapElement> map = new LinkedHashMap<>();
    //protected List<IMapElement> map = new ArrayList<>();
    protected MapVisualizer mapVisualizer;

    public AbstractWorldMap(){
        this.mapVisualizer = new MapVisualizer(this);
    }

    public boolean isOccupied(Position position) {
        return objectAt(position) != null;
    }

    public Object objectAt(Position position) {
        return this.map.get(position);
    }

    public boolean canMoveTo(Position position) {
        return !isOccupied(position);
    }

    public boolean place(Car car) throws IllegalArgumentException {
        if(canMoveTo(car.getPosition())){
            this.map.put(car.getPosition(),car);
            return true;
        }
        else{
            throw new IllegalArgumentException("this position is already occupied by " + this.objectAt(car.getPosition()));
        }
    }

    public void run(List<MoveDirection> directions) { // tutaj trzeba zrobic na map bo lipa :(((((((
        int index=0;
        int s = this.map.size();
        int dirSize = directions.size();
        for(MoveDirection dir : directions){
            this.map.get(index%s).move(dir);
            index++;

            try {
                System.out.println("\r"+this.toString());
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            dirSize--;
            if(dirSize!=0)
                System.out.println("\033[H\033[2J");
        }
    }
}

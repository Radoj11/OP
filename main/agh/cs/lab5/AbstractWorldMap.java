package agh.cs.lab5;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Position;
import agh.cs.lab3.Car;
import agh.cs.lab4.MapVisualizer;
import agh.cs.lab7.IPositionChangeObserver;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public abstract class AbstractWorldMap implements IPositionChangeObserver {
    protected LinkedHashMap<Position,IMapElement> map = new LinkedHashMap<>();
    protected MapVisualizer mapVisualizer;

    public LinkedHashMap getmap(){
        return this.map;
    }

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

    public void place(Car car) throws IllegalArgumentException {
        if(canMoveTo(car.getPosition())){
            this.map.put(car.getPosition(),car);
            car.addObserver(this);
        }
        else{
            throw new IllegalArgumentException("this position is already occupied by " + this.objectAt(car.getPosition()).getClass());
        }
    }

    public void run(List<MoveDirection> directions) {
        AtomicInteger index = new AtomicInteger();
        List<IMapElement> onlyCarList = this.map.values().stream()
                .filter(el -> el instanceof Car)
                .collect(Collectors.toList());
        directions.forEach(el -> this.runHelper(el,onlyCarList.get(index.getAndIncrement()%onlyCarList.size())));
    }

    private void runHelper(MoveDirection dir, IMapElement car){
        car.move(dir);
        try {
            System.out.print("\r"+this.toString());
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\033[H\033[2J");
    }

    public void positionChanged(Position oldPosition, Position newPosition){
        this.map.put(newPosition,this.map.remove(oldPosition));
    }
}

package agh.cs.lab3;

import agh.cs.lab2.MapDirection;
import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Position;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab4.RectangularMap;
import agh.cs.lab5.AbstractWorldMap;
import agh.cs.lab5.HayStack;
import agh.cs.lab5.IMapElement;
import agh.cs.lab5.UnboundedMap;
import agh.cs.lab7.IPositionChangeObserver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static agh.cs.lab3.OptionsParser.parse;

public class Car implements IMapElement {
    private MapDirection orientation;
    private Position position;
    private AbstractWorldMap myLovelyMap;
    private List<IPositionChangeObserver> observers = new LinkedList<>();

    public static void main(String[] args){
        try {
            List<MoveDirection> directions = new OptionsParser().parse(args);
            //MoveDirection[] arr = new MoveDirection[directions.size()];
            List<HayStack> hl = new ArrayList<>();
            hl.add(new HayStack(new Position(-4, -4)));
            hl.add(new HayStack(new Position(7, 7)));
            hl.add(new HayStack(new Position(3, 6)));
            hl.add(new HayStack(new Position(2, 0)));
            //IWorldMap map = new RectangularMap(10,10);
            AbstractWorldMap map = new UnboundedMap(hl);
            new Car(map);
            new Car(map, new Position(3, 4));
            //System.out.println(map.toString());
            map.run(directions);
            System.out.print(map.toString());
        }
        catch (IllegalArgumentException ex){
            System.out.print(ex.getMessage());
            return;
        }
    }


    public Car(){
        this.orientation=MapDirection.NORTH;
        this.position=new Position(2,2);
    }

    public Car(AbstractWorldMap map){
        this.orientation=MapDirection.NORTH;
        this.position=new Position(2,2);
        this.myLovelyMap=map;
        map.place(this);
    }

    public Car(AbstractWorldMap map, Position initialPosition){
        this.position=initialPosition;
        this.orientation=MapDirection.NORTH;
        this.myLovelyMap=map;
        map.place(this);
    }


    @Override
    public String toString(){
        switch(this.orientation){
            case NORTH:
                return "^";
            case EAST:
                return ">";
            case WEST:
                return "<";
            case SOUTH:
                return "v";
            default:
                return "";
        }
    }


    @Override
    public Position getPosition(){
        return this.position;
    }

    public void move(MoveDirection direction){
        Position update = this.position;
        switch(direction){
            case RIGHT:
                this.orientation=this.orientation.next();
                break;
            case LEFT:
                this.orientation=this.orientation.previous();
                break;
            case FORWARD:
                update=this.position.add(this.orientation.toPositionVector());
                break;
            case BACKWARD:
                update=this.position.add(this.orientation.toPositionVector().scalarMultiply(-1));
                break;
            default:
                break;
        }

        if(this.myLovelyMap.canMoveTo(update))
            this.positionChanged(update);
    }



    public void testRun(String[] args){
        List<MoveDirection> directionList = parse(args);

        for(MoveDirection dir : directionList){
            this.move(dir);
        }

    }

    public void addObserver(IPositionChangeObserver observer){
        this.observers.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer){
        this.observers.remove(observer);
    }

    @Override
    public void positionChanged(Position newPosition){
        for(IPositionChangeObserver observer : this.observers){
            observer.positionChanged(this.position,newPosition);
        }
        this.position = newPosition;
    }
}

package agh.cs.lab5;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Position;

public class HayStack implements IMapElement{
    private Position position;

    public HayStack(Position position){
        this.position=position;
    }

    @Override
    public Position getPosition(){
        return this.position;
    }

    @Override
    public void move(MoveDirection dir){}

    @Override
    public String toString(){
        return "s";
    }

    @Override
    public boolean equals(Object other){
        if(this == other)
            return true;
        if(!(other instanceof Position))
            return false;
        HayStack that = (HayStack) other;

        if(that.position.equals(this.position))
            return true;
        else
            return false;
    }
}

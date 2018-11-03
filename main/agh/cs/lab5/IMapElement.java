package agh.cs.lab5;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Position;

public interface IMapElement {

    public Position getPosition();

    public void move(MoveDirection dir);
}

package agh.cs.lab5;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Position;

public interface IMapElement {

    Position getPosition();

    void move(MoveDirection dir);

    void positionChanged(Position oldPosition);
}

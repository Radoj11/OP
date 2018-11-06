package agh.cs.lab3;

import agh.cs.lab2.MapDirection;
import agh.cs.lab2.MoveDirection;

import java.util.ArrayList;
import java.util.List;

public class OptionsParser {
    public static List<MoveDirection> parse(String[] args) throws IllegalArgumentException{
        List<MoveDirection> myDirections = new ArrayList<>();
        for(String arg : args){
            switch(arg){
                case "f":
                    myDirections.add(MoveDirection.FORWARD);
                    break;
                case "forward":
                    myDirections.add(MoveDirection.FORWARD);
                    break;
                case "b":
                    myDirections.add(MoveDirection.BACKWARD);
                    break;
                case "backward":
                    myDirections.add(MoveDirection.BACKWARD);
                    break;
                case "r":
                    myDirections.add(MoveDirection.RIGHT);
                    break;
                case "right":
                    myDirections.add(MoveDirection.RIGHT);
                    break;
                case "l":
                    myDirections.add(MoveDirection.LEFT);
                    break;
                case "left":
                    myDirections.add(MoveDirection.LEFT);
                    break;
                default:
                    throw new IllegalArgumentException(arg + " is not legal move specification");
            }
        }
        return myDirections;
    }
}

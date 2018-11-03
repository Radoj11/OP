package agh.cs.lab1;

import java.util.ArrayList;

public class CarSystem {
    public static void main(String[] args){
        ArrayList<Directions> converted = new ArrayList<Directions>();;
        System.out.print("System start\n");
        converted = convert(args);
        run(converted);
        System.out.print("System stop");
    }

    public static void run(ArrayList<Directions> args){
        for(Directions oneDirection : args){
            switch(oneDirection){
                case FORWARD:
                    System.out.print("Car goes forward\n");
                    break;
                case BACKWARD:
                    System.out.print("Car goes backward\n");
                    break;
                case LEFT:
                    System.out.print("Car goes left\n");
                case RIGHT:
                    System.out.print("Car goes right\n");
                    break;
                default:
                    break;
            }
        }
    }

    private static ArrayList<Directions> convert(String dir[]){
        ArrayList<Directions> myList = new ArrayList<Directions>();//jak robie List i dam List<Dir> m = null; to potem .add robi nullPointer :/ zapytaj
        for(String one : dir){
            switch(one){
                case "f":
                    myList.add(Directions.FORWARD);
                    break;
                case "b":
                    myList.add(Directions.BACKWARD);
                    break;
                case "l":
                    myList.add(Directions.LEFT);
                    break;
                case "r":
                    myList.add(Directions.RIGHT);
                    break;
                default:
                    break;
            }
        }
        return myList;
    }
}

package agh.cs.lab2;

public class CarSystem {
    public static void main(String[] args){
        Position position1 = new Position(1,2);
        System.out.println(position1);
        Position position2 = new Position(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));

        MapDirection myDir = MapDirection.NORTH;
        System.out.print("toString ENUM TEST:\n");
        System.out.println(myDir.toString());
        System.out.print("\n");
        System.out.print("NEXT TEST:\n");
        for(int i=0;i<10;i++){
            myDir=myDir.next();
            System.out.println(myDir.toString());
        }
        System.out.print("\n");
        System.out.print("PREVIOUS TEST:\n");
        for(int i=0;i<10;i++){
            myDir=myDir.previous();
            System.out.println(myDir.toString());
        }
    }
}

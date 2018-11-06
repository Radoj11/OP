package agh.cs.lab5;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Position;
import agh.cs.lab3.Car;
import agh.cs.lab3.OptionsParser;
import agh.cs.lab4.RectangularMap;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RectangularMapTests {
    @Test()
    public void iWordMapTest(){
        RectangularMap testMap = new RectangularMap(10,10);
        Car testCar = new Car(testMap);
        String[] dirS = {"f", "f", "l", "r", "f", "f","l","f","b"};
        List<MoveDirection> dir = new OptionsParser().parse(dirS);
        assertTrue(testMap.isOccupied(new Position(2,2)));
        assertFalse(testMap.isOccupied(new Position(1,0)));
        assertTrue(testMap.canMoveTo(new Position(2,1)));
        assertFalse(testMap.canMoveTo(new Position(11,11)));
        assertFalse(testMap.canMoveTo(new Position(-11,-11)));
        assertFalse(testMap.canMoveTo(new Position(-1,-1)));
        assertTrue(testMap.canMoveTo(new Position(0,0)));
        assertFalse(testMap.canMoveTo(new Position(0,11)));
        assertFalse(testMap.canMoveTo(new Position(11,0)));
        assertEquals(testCar,testMap.objectAt(new Position(2,2)));
        Car testCar2 = new Car(testMap,new Position(2,3));
        try{
            testMap.place(testCar);
        }
        catch (IllegalArgumentException e){

        }

        assertTrue(testMap.isOccupied(new Position(2,3)));

        testMap.run(dir);
        assertEquals(new Position(1,3),testCar.getPosition());
        assertEquals(new Position(4,4),testCar2.getPosition());
    }
}

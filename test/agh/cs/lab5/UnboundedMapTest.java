package agh.cs.lab5;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Position;
import agh.cs.lab3.Car;
import agh.cs.lab3.OptionsParser;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UnboundedMapTest {
    @Test
    public void iWordMapTest(){
        List<HayStack> hl= new ArrayList<>();
        hl.add(new HayStack(new Position(-4,-4)));
        hl.add(new HayStack(new Position(7,7)));
        hl.add(new HayStack(new Position(3,6)));
        hl.add(new HayStack(new Position(2,0)));
        String[] dirS = {"f", "b", "r", "l", "f", "f","r","r","f","f","f","f","f","f","f","f"};
        List<MoveDirection> dir = new OptionsParser().parse(dirS);
        UnboundedMap testMap2 = new UnboundedMap(hl);
        //assertTrue(testMap2.place(new Car()));
        Car car2 = new Car(testMap2);
        Car car = new Car(testMap2,new Position(3,4));
        assertFalse(testMap2.place(new Car()));
        assertTrue(testMap2.isOccupied(new Position(2,2)));
        assertTrue(testMap2.isOccupied(new Position(3,4)));
        assertTrue(testMap2.isOccupied(new Position(-4,-4)));
        assertTrue(testMap2.isOccupied(new Position(7,7)));
        assertTrue(testMap2.isOccupied(new Position(3,6)));
        assertTrue(testMap2.isOccupied(new Position(2,0)));
        assertFalse(testMap2.isOccupied(new Position(0,0)));
        assertFalse(testMap2.isOccupied(new Position(100,100)));
        assertTrue(testMap2.canMoveTo(new Position(2,1)));
        assertTrue(testMap2.canMoveTo(new Position(-22,11)));
        assertFalse(testMap2.canMoveTo(new Position(2,2)));
        assertFalse(testMap2.canMoveTo(new Position(2,0)));
        assertFalse(testMap2.canMoveTo(new Position(-4,-4)));
        //assertEquals(new HayStack(new Position(-4,-4)),testMap2.objectAt(new Position(-4,-4)));
        //assertEquals(new HayStack(new Position(7,7)),testMap2.objectAt(new Position(7,7)));
        //assertEquals(new Car(),testMap2.objectAt(new Position(2,2)));
        testMap2.run(dir);
        assertTrue(testMap2.isOccupied(new Position(2,1)));
        assertTrue(testMap2.isOccupied(new Position(3,5)));
    }
}

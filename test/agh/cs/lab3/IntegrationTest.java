package agh.cs.lab3;

import agh.cs.lab2.MapDirection;
import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Position;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class IntegrationTest {

    @Test
    public void toStringTest(){
        Car car = new Car();
        assertEquals("(2,2) Polnoc",car.toString());
    }


    @Test
    public void moveTest(){
        Car testCar = new Car();
        String[] dir={"f","f","ola","ala","forward","backward","bnp","b","b","b","b","right","f","r","f","r","f","l","left"};
        assertEquals("(2,2) Polnoc", testCar.toString());
        testCar.testRun(dir);
        assertEquals("(2,0) Wschod", testCar.toString());
    }
}

package agh.cs.lab2;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PositionTest {
    Position testPoint = new Position(1,2);
    Position testPoint2 = new Position(3,4);

    @Test
    public void equalsTest(){
        assertTrue(testPoint.equals(testPoint));
        assertFalse(testPoint.equals(testPoint2));
        assertFalse(testPoint.equals(new CarSystem()));
    }
    //gonwoTestGit
    @Test
    public void toStringTest(){
        assertEquals("(1,2)",testPoint.toString());
    }

    @Test
    public void smallerTest(){
        assertTrue(testPoint.smaller(testPoint2));
        assertFalse(testPoint2.smaller(testPoint));
        assertTrue(testPoint.smaller(testPoint));
    }

    @Test
    public void largerTest(){
        assertFalse(testPoint.larger(testPoint2));
        assertTrue(testPoint2.larger(testPoint));
        assertTrue(testPoint.larger(testPoint));
    }

    @Test
    public void upperRightTest(){
        assertEquals(new Position(3,4),testPoint.upperRight(testPoint2));
        assertEquals(new Position(3,4),testPoint2.upperRight(testPoint));
        assertEquals(new Position(1,2),testPoint.upperRight(testPoint));
        assertEquals(new Position(0,5),new Position(-1,5).upperRight(new Position(0,3)));
    }

    @Test
    public void lowerLeftTest(){
        assertEquals(new Position(1,2),testPoint.lowerLeft(testPoint2));
        assertEquals(new Position(1,2),testPoint2.lowerLeft(testPoint));
        assertEquals(new Position(3,4),testPoint2.lowerLeft(testPoint2));
        assertEquals(new Position(2,5), new Position(3,5).lowerLeft(new Position(2,6)));
    }

    @Test
    public void addTest(){
        assertEquals(new Position(4,6),testPoint.add(testPoint2));
        assertEquals(new Position(4,6),testPoint2.add(testPoint));
    }

}

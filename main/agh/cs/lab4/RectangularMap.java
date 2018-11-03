package agh.cs.lab4;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Position;
import agh.cs.lab5.AbstractWorldMap;

import java.util.List;

public class RectangularMap extends AbstractWorldMap {
    private final Position max;
    private final Position min=new Position(0,0);

    public RectangularMap(int width, int height){
        this.max=new Position(width,height);
    }


    @Override
    public boolean canMoveTo(Position position) {
        if(position.smaller(this.max) && position.larger(this.min)){
            if(isOccupied(position))
                return false;
            else
                return true;
        }
        return false;
    }

    @Override
    public void run(List<MoveDirection> directions) {
        int index=0;
        int s = this.map.size();
        int dirSize = directions.size();
        for(MoveDirection dir : directions){
            this.map.get(index%s).move(dir);
            index++;

            try {
                System.out.println("\r"+this.toString());
                Thread.currentThread().sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            dirSize--;
            if(dirSize!=0)
                System.out.println("\033[H\033[2J");
        }
    }

    @Override
    public String toString(){
        return this.mapVisualizer.draw(this.min,this.max);
    }
}

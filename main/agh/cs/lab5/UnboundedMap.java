package agh.cs.lab5;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Position;
import agh.cs.lab3.Car;
import java.util.List;

import static java.lang.Math.abs;

public class UnboundedMap extends AbstractWorldMap {
    private Position min = new Position(Integer.MAX_VALUE,Integer.MAX_VALUE);
    private Position max = new Position(Integer.MIN_VALUE,Integer.MIN_VALUE);

    public UnboundedMap(List<HayStack> hayList){
        for(HayStack i : hayList){
            this.map.add(i);
        }
    }

    @Override
    public void run(List<MoveDirection> directions) {
        int index=0;
        int s = this.map.size();
        int dirSize = directions.size();
        while(dirSize>0){
            if(this.map.get(index%s) instanceof Car){
                this.map.get(index%s).move(directions.get(abs(dirSize-directions.size())));
                System.out.print("\r"+this.toString());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                dirSize--;
                if(dirSize!=0)
                    System.out.println("\033[H\033[2J");
            }
            index++;
        }
    }

    @Override
    public String toString(){
        this.setRec();
        return this.mapVisualizer.draw(this.min,this.max);
    }

    private void setRec(){
        for(IMapElement i : this.map){
            if(i.getPosition().x<this.min.x)
                this.min=new Position(i.getPosition().x,this.min.y);
            if(i.getPosition().y<this.min.y)
                this.min=new Position(this.min.x,i.getPosition().y);
            if(i.getPosition().x>this.max.x)
                this.max=new Position(i.getPosition().x,this.max.y);
            if(i.getPosition().y>this.max.y)
                this.max=new Position(this.max.x,i.getPosition().y);
        }
    }
}

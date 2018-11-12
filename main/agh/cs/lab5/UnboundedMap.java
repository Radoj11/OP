package agh.cs.lab5;

import agh.cs.lab2.Position;
import java.util.List;

public class UnboundedMap extends AbstractWorldMap {
    private Position min = new Position(Integer.MAX_VALUE,Integer.MAX_VALUE);
    private Position max = new Position(Integer.MIN_VALUE,Integer.MIN_VALUE);

    public UnboundedMap(List<HayStack> hayList){
        //super();
        for(HayStack i : hayList){
            this.map.put(i.getPosition(),i);
        }
    }

    @Override
    public String toString(){
        this.setRec();
        return this.mapVisualizer.draw(this.min,this.max);
    }

    private void setRec(){
        for(Position i : this.map.keySet()){
            if(i.x<this.min.x)
                this.min=new Position(i.x,this.min.y);
            if(i.y<this.min.y)
                this.min=new Position(this.min.x,i.y);
            if(i.x>this.max.x)
                this.max=new Position(i.x,this.max.y);
            if(i.y>this.max.y)
                this.max=new Position(this.max.x,i.y);
        }
    }
}

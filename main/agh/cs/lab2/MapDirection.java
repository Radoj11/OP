package agh.cs.lab2;

public enum MapDirection {
    NORTH,
    SOUTH,
    WEST,
    EAST,
    UNDEFINED;

    @Override
    public String toString() {
        switch (this) {
            case NORTH:
                return "Polnoc";
            case SOUTH:
                return "Polodnie";
            case EAST:
                return "Wschod";
            case WEST:
                return "Zachod";
            default:
                return "";
        }
    }

    public MapDirection next(){
        return getMapDirection(SOUTH, NORTH, EAST, WEST);
    }

    private MapDirection getMapDirection(MapDirection south, MapDirection north, MapDirection east, MapDirection west) {
        switch(this){
            case EAST:
                return south;
            case WEST:
                return north;
            case NORTH:
                return east;
            case SOUTH:
                return west;
            default:
                return UNDEFINED;
        }
    }

    public MapDirection previous(){
        return getMapDirection(NORTH, SOUTH, WEST, EAST);
    }



    public Position toPositionVector(){
        switch(this){
            case WEST:
                return new Position(-1,0);
            case SOUTH:
                return new Position(0,-1);
            case NORTH:
                return new Position(0,1);
            case EAST:
                return new Position(1,0);
            default:
                return new Position(0,0);
        }
    }
}

import Boats.Boat;

public class PositionField {
    String field = "⃞";
    boolean hit;

    Boat boat;

    public PositionField() {
        this.boat=null;
        this.hit=false;
    }

    public String getField() {
        return field;
    }

    public void insertBoat(Boat boat){
        this.field=boat.getSymbol();
        this.boat=boat;
    }
}

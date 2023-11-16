import Assets.Colors;
import Boats.Boat;

public class PositionField {
    String field = " ▪️";
    boolean hit;

    Boat boat;

    public void setField(String field) {
        this.field = field;
    }

    public PositionField() {
        this.boat=null;
        this.hit=false;
    }

    public String getField() {
        return field;
    }

    public Boat getBoat() {
        return boat;
    }

    public void insertBoat(Boat boat){
        this.field=boat.getSymbol();
        this.boat=boat;
    }

}

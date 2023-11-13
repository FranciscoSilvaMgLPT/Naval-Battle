import Boats.Boat;
import java.util.ArrayList;

public class BoatList {
    static ArrayList<Boat> list;
    String name;

    public BoatList(String name) {
        this.list = new ArrayList<>();
        this.name = name;
        CreativeMode.lists.add(this);
    }

    public BoatList(ArrayList<Boat> list, String name) {
        this.list = list;
        this.name = name;
        CreativeMode.lists.add(this);
    }

}

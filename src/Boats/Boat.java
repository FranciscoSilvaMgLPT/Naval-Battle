package Boats;

public abstract class Boat {
    String name;
    int size;
    int life = size;
    String symbol;

    public Boat(String name, int size,  String symbol) {
        this.name = name;
        this.size = size;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}

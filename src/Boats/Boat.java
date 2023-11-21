package Boats;

public abstract class Boat {
    String name;
    int size;

    int lifePlayer1;

    int lifePlayer2;
    String symbol;

    public Boat(String name, int size,  String symbol) {
        this.name = name;
        this.size = size;
        this.symbol = symbol;
        this.lifePlayer1 = size;
        this.lifePlayer2 = size;
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


    public int getLifePlayer1() {
        return lifePlayer1;
    }

    public void setLifePlayer1(int lifePlayer1) {
        this.lifePlayer1 = lifePlayer1;
    }

    public int getLifePlayer2() {
        return lifePlayer2;
    }

    public void setLifePlayer2(int lifePlayer2) {
        this.lifePlayer2 = lifePlayer2;
    }
}




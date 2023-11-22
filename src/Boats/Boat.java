package Boats;

public abstract class Boat {
    String name;
    int size;
    int lifePlayerBoard;
    int lifeCPUBoard;
    String symbol;

    public Boat(String name, int size, String symbol) {
        this.name = name;
        this.size = size;
        this.symbol = symbol;
        this.lifeCPUBoard = size;
        this.lifePlayerBoard = size;
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


    public int getLifePlayerBoard() {
        return lifePlayerBoard;
    }

    public void setLifePlayerBoard(int lifePlayerBoard) {
        this.lifePlayerBoard = lifePlayerBoard;
    }

    public int getLifeCPUBoard() {
        return lifeCPUBoard;
    }

    public void setLifeCPUBoard(int lifeCPUBoard) {
        this.lifeCPUBoard = lifeCPUBoard;

        }
    }

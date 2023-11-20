package be.intecbrussel.sellers;

public class Stock {
    //ATTRIBUTES
    private int iceRockets;
    private int cones;
    private int balls;
    private int magni;

    //CONSTRUCTORS
    public Stock(){}
    public Stock(int iceRockets, int cones, int balls, int magni) {
        this.iceRockets = iceRockets;
        this.cones = cones;
        this.balls = balls;
        this.magni = magni;
    }

    //METHODS
    public int getIceRockets() {
        return iceRockets;
    }

    public void setIceRockets(int iceRockets) {
        this.iceRockets = iceRockets;
    }

    public int getCones() {
        return cones;
    }

    public void setCones(int cones) {
        this.cones = cones;
    }

    public int getBalls() {
        return balls;
    }

    public void setBalls(int balls) {
        this.balls = balls;
    }

    public int getMagni() {
        return magni;
    }

    public void setMagni(int magni) {
        this.magni = magni;
    }

    @Override
    public String toString() {
        return "Stock {" +
                "iceRockets = " + iceRockets +
                ", cones = " + cones +
                ", balls = " + balls +
                ", magni = " + magni +
                '}';
    }
}

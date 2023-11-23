package be.intecbrussel.sellers;

import java.util.HashMap;
import java.util.Map;

public class Stock {
    //ATTRIBUTES
    private int iceRockets;
    private int cones;
    private Map<Enum, Integer> magni = new HashMap<>();
    private Map<Enum, Integer> balls = new HashMap<>();

    //CONSTRUCTORS
    public Stock(){}
    public Stock(int iceRockets, int cones, Map<Enum, Integer> balls, Map<Enum, Integer> magni) {
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

    public Map<Enum, Integer> getMagni() {
        return magni;
    }

    public void setMagni(Map<Enum, Integer> magni) {
        this.magni = magni;
    }

    public Map<Enum, Integer> getBalls() {
        return balls;
    }

    public void setBallsMap(Map<Enum, Integer> ballsMapballs) {
        this.balls = balls;
    }

    @Override
    public String toString() {
        return  "\n\t\uD83D\uDCE6 Stock IceRockets  = " + iceRockets +
                "\n\t\uD83D\uDCE6 Stock Cones       = " + cones +
                "\n\t\uD83D\uDCE6 Stock Balls       = " + balls +
                "\n\t\uD83D\uDCE6 Stock Magnum      = " + magni
                ;
    }
}

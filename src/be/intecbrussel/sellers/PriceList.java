package be.intecbrussel.sellers;

import be.intecbrussel.eatables.Magnum;

public class PriceList {

    //ATTRIBUTS
    private double ballPrice;
    private double rocketPrice;
    private double magnumStandardPrice;

    //CONSTRUCTOR
    public PriceList(){}
    public PriceList(double ballPrice, double rocketPrice, double magnumStandardPrice) {
        this.ballPrice = ballPrice;
        this.rocketPrice = rocketPrice;
        this.magnumStandardPrice = magnumStandardPrice;
    }

    //METHODS
    public void setBallPrice(double ballPrice) {
        this.ballPrice = ballPrice;
    }
    public void setRocketPRice(double rocketPrice) {
        this.rocketPrice = rocketPrice;
    }
    public void setMagnumStandardPrice(double magnumStandardPrice) {
        this.magnumStandardPrice = magnumStandardPrice;
    }
    public double getBallPrice() {
        return ballPrice;
    }
    public double getRocketPrice() {
        return rocketPrice;
    }
    public double getMagnumPrice(Magnum.MagnumType magnumType) {
        switch (magnumType){
            case ALPINENUTS: return magnumStandardPrice*1.5;
            case ROMANTICSTRAWBERRIES: return magnumStandardPrice*1.7;
        }
        return magnumStandardPrice;
    }

    @Override
    public String toString() {
        return "Price List {" +
                "ballPrice = " + ballPrice +
                ", rocketPrice = " + rocketPrice +
                ", magnumStandardPrice = " + magnumStandardPrice +
                ", magnumALPINENUTS = " + magnumStandardPrice*1.5 +
                ", magnumROMANTICSTRAWBERRIESe = " + magnumStandardPrice*1.7 +
                '}';
    }
}

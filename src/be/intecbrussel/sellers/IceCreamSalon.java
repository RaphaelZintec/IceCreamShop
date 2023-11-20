package be.intecbrussel.sellers;

import be.intecbrussel.eatables.*;

public class IceCreamSalon implements IceCreamSeller{
    //ATTRIBUTES
    private PriceList priceList;
    private double totalProfit = 0.0;

    //CONSTRUCTORS
    public IceCreamSalon(){}
    public IceCreamSalon(PriceList priceList) {
        this.priceList = priceList;
    }

    //METHODS
    @Override
    public double getProfit() {
        return totalProfit;
    }

    @Override
    public Cone orderCone(Cone.Flavor[] balls) {
        int numberOfBalls = balls.length;
        totalProfit += (priceList.getBallPrice() * 0.25) * numberOfBalls;
        return new Cone(balls);
    }

    @Override
    public IceRocket orderIceRocket() {
        totalProfit += priceList.getRocketPrice() * 0.20;
        return new IceRocket();
    }

    @Override
    public Magnum orderMagnum(Magnum.MagnumType magnumType) {
        totalProfit += priceList.getMagnumPrice(magnumType) * 0.01;
        return new Magnum(magnumType);
    }



    @Override
    public String toString() {
        return "IceCreamCar {" +
                "\n\t" + priceList.toString() +
                "\n\tprofit = " + totalProfit +
                "\n}";
    }
}

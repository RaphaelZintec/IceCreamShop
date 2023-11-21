package be.intecbrussel.sellers;

import be.intecbrussel.eatables.*;

import java.util.ArrayList;
import java.util.Arrays;

public class IceCreamCar implements IceCreamSeller{
    //ATTRIBUTES
    private PriceList priceList;
    private Stock stock;
    private double profit;

    //CONSTRUCTORS
    public IceCreamCar(){}
    public IceCreamCar(PriceList priceList, Stock stock) {
        this.priceList = priceList;
        this.stock = stock;
    }

    //METHODS
    @Override
    public Cone orderCone(Cone.Flavor[] balls){
        Cone cone = prepareCone(balls);
        if(cone != null){
            profit += (priceList.getBallPrice() * 0.25) * cone.getBalls().length;
        }
        return cone;
    }
    private Cone prepareCone(Cone.Flavor[] balls) {
        ArrayList<Cone.Flavor> ballsUpdate = new ArrayList<>();
        if (stock.getCones()>0) {
            Arrays.stream(balls).forEach(n-> {
                    if(stock.getBalls().get(n) > 0){
                        stock.getBalls().put(n, stock.getBalls().get(n)-1);
                        ballsUpdate.add(n);
                    }
                    else {
                        System.out.println("NO MORE "+n+" BALLS FOR YOUR ICE CREAM");
                    }
            }
            );
            stock.setCones(stock.getCones()-1);
            return new Cone(ballsUpdate.stream().toArray(Cone.Flavor[]::new));
        }
        else
            System.out.println("NO MORE CONES FOR YOUR ICE CREAM");
        return null;
    }

    @Override
    public IceRocket orderIceRocket(){
        IceRocket iceRocket = prepareIceRocket();
        if(iceRocket != null){
            profit += priceList.getRocketPrice() * 0.20;
        }
        return iceRocket;
    }
    private IceRocket prepareIceRocket() {
        if (stock.getIceRockets()>0) {
            stock.setIceRockets(stock.getIceRockets()-1);
            return new IceRocket();
        }
        else
            System.out.println("NO MORE ROCKET ICE CREAM");
        return null;
    }

    @Override
    public Magnum orderMagnum(Magnum.MagnumType magnumType){
        Magnum magnum = prepareMagnum(magnumType);
        if(magnum != null){
            profit += priceList.getMagnumPrice(magnumType) * 0.01;
            return magnum;
        }
        return null;
    }
    private Magnum prepareMagnum(Magnum.MagnumType magnumType){
        if (stock.getMagni().get(magnumType)>0) {
            stock.getMagni().put(magnumType, stock.getMagni().get(magnumType)-1);
            return new Magnum(magnumType);
        }
        else
            System.out.println("NO MORE "+magnumType+" MAGNUM ICE CREAM");
        return null;
    }

    @Override
    public double getProfit() {
        return profit;
    }

    @Override
    public String toString() {
        return "IceCreamCar {" +
                "\n\t" + priceList.toString() +
                "\n\t" + stock +
                "\n\tProfit = " + profit +
                "\n}";
    }
}

package be.intecbrussel.sellers;

import be.intecbrussel.eatables.*;

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
            profit += (priceList.getBallPrice() * 0.25) * balls.length;
        }
        return cone;
    }
    private Cone prepareCone(Cone.Flavor[] balls) {
        if (stock.getCones()>0 && stock.getBalls()>=balls.length) {
            stock.setCones(stock.getCones()-1);
            stock.setBalls(stock.getBalls()-balls.length);
            return new Cone(balls);
        }
        else if(stock.getCones()==0 && stock.getBalls()<balls.length)
            System.out.println("NO MORE CONES AND NOT ENOUGH BALLS FOR YOUR ICE CREAM");
        else if(stock.getCones()==0)
            System.out.println("NO MORE CONES FOR YOUR ICE CREAM");
        else if(stock.getBalls()<balls.length)
            System.out.println("NOT ENOUGH BALLS FOR YOUR ICE CREAM");
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
        if (stock.getMagni()>0) {
            stock.setMagni(stock.getMagni()-1);
            return new Magnum(magnumType);
        }
        else
            System.out.println("NO MORE MAGNUM ICE CREAM");
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
                "\n\tprofit = " + profit +
                "\n}";
    }
}

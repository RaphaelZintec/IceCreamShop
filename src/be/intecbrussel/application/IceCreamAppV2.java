package be.intecbrussel.application;

import be.intecbrussel.eatables.*;
import be.intecbrussel.sellers.*;
import java.util.ArrayList;

public class IceCreamAppV2 {
    public static void main(String[] args) {
        //1. INITIALIZATION
        //- PRICES: CONE=1.5*0.25, ROCKET=2*0.2, MAGNUM=2.5*0.01 (MAGNUM alpine nuts=2.5*1.5, strawberries=2.5*1.7)
        //- STOCK:
        PriceList priceList = new PriceList(1.5, 2.0, 2.5);
        Stock stock = new Stock(4, 0, 2, 4);
        IceCreamSeller iceCreamSeller = new IceCreamCar(priceList, stock);
        ArrayList<Eatable> myIces = new ArrayList<Eatable>();

        //2. PLACING ORDERS
        //- Profit starts with 0 and increment the next values:
        myIces.add(iceCreamSeller.orderCone(new Cone.Flavor[]{Cone.Flavor.BANANA, Cone.Flavor.LEMON}));//(1.5 * 0.25) * 2 = 0.75
        myIces.add(iceCreamSeller.orderIceRocket()); //2 * 0.20 = 0.4
        myIces.add(iceCreamSeller.orderMagnum(Magnum.MagnumType.BLACKCHOCOLATE));//2.5*0.01 = 0.025
        myIces.add(iceCreamSeller.orderMagnum(Magnum.MagnumType.ALPINENUTS));//(2.5*1.5)*0.01 = 0.0375


        //3. SHOW eat() FOR EACH ICE CREAM try catch if null + SHOW PROFIT with toString()
        myIces.forEach(n->{
            try {
                n.eat();
            } catch(NullPointerException e){
                //do nothing
            }
        });

        System.out.println("\n"+iceCreamSeller);
    }
}

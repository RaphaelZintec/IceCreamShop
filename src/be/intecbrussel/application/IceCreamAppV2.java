package be.intecbrussel.application;

import be.intecbrussel.eatables.*;
import be.intecbrussel.sellers.*;
import java.util.*;

public class IceCreamAppV2 {

    public static void main(String[] args) {
        //0. WELCOME MSG
        System.out.println("\n########## Start of Car Ice Cream Shop ##########");

        //1. User choose ice creams
        UserChoice userChoice = new UserChoice();
        userChoice.icecreamChoice();
        String yesNo = "no";
        do {
            System.out.println("\nDo you want another Ice Cream? yes/no");
            yesNo = userChoice.sc.nextLine();
            if (yesNo.equalsIgnoreCase("yes"))
                userChoice.icecreamChoice();
        } while(!yesNo.equalsIgnoreCase("no"));
        System.out.println();//new line

        //2. INITIALIZATION 0,0425
        //- ICE CREAM PRICES: CONE:1.5 (per ball)   ROCKET:2,           MAGNUM:2.5  (alpine nuts:*1.5, strawberries:*1.7)
        //- PROFIT:           CONE:*0.25            ROCKET:*0.2         MAGNUM:*0.01
        //- STOCK:            ROCKET:5              CONE:2
        //- STOCK BALLS:      STRAWBERRY 0          BANANA 1            CHOCOLATE 10         VANILLA 10       STRACIATELLA 10          LEMON 10     MOKKA 10     PISTACHE 10
        //- STOCK MAGNUM:     MILKCHOCOLATE 0       WHITECHOCOLATE 1    BLACKCHOCOLATE 10    ALPINENUTS 10    ROMANTICSTRAWBERRIES 10
        PriceList priceList             = new PriceList(1.5, 2.0, 2.5);
        Map<Enum, Integer> balls        = new HashMap<Enum, Integer>(){{ put(Cone.Flavor.STRAWBERRY, 0); put(Cone.Flavor.BANANA, 1); put(Cone.Flavor.CHOCOLATE, 10); put(Cone.Flavor.VANILLA, 10); put(Cone.Flavor.LEMON, 10); put(Cone.Flavor.STRACIATELLA, 10); put(Cone.Flavor.MOKKA, 10); put(Cone.Flavor.PISTACHE, 10); }};
        Map<Enum, Integer> magni        = new HashMap<Enum, Integer>(){{ put(Magnum.MagnumType.MILKCHOCOLATE, 0); put(Magnum.MagnumType.WHITECHOCOLATE, 1); put(Magnum.MagnumType.BLACKCHOCOLATE, 10); put(Magnum.MagnumType.ALPINENUTS, 10); put(Magnum.MagnumType.ROMANTICSTRAWBERRIES, 10); }};
        Stock stock                     = new Stock(5, 5, balls, magni);
        IceCreamSeller iceCreamSeller   = new IceCreamCar(priceList, stock);
        ArrayList<Eatable> myIces       = new ArrayList<Eatable>();

        //3. PLACING ORDERS: Profit starts with 0 and increment the next values:
        //3.1 number of ice rockets to add
            int numberOfIceRocket = userChoice.getIcerocketMap().get(UserChoice.TypeOfIceCreams.ICEROCKET);
            for (int i = 0; i<numberOfIceRocket; ++i) myIces.add(iceCreamSeller.orderIceRocket());
        //3.2 number of magnum
            userChoice.getMagnumMap().entrySet().stream()
                    .filter(n->n.getValue()>=1)
                    .forEach(n-> {
                        for(int i=0; i<n.getValue(); ++i)
                            myIces.add(iceCreamSeller.orderMagnum((Magnum.MagnumType) n.getKey()));
                    });
        //3.3 number of cones with balls to add
            ArrayList<Enum> flavors = new ArrayList<>();
            final boolean[] orderedCone = new boolean[]{false};
            userChoice.getFlavorMapArray().forEach(
                    cone->{
                        cone.entrySet().stream()
                                .filter(flavor->flavor.getValue()>0)
                                .forEach(flavor->{
                                    for(int i = 0; i<flavor.getValue(); ++i){
                                        flavors.add(flavor.getKey());
                                    }
                                    orderedCone[0] = true;
                                });
                    });
        if(orderedCone[0]) myIces.add(iceCreamSeller.orderCone(flavors.toArray(Cone.Flavor[]::new)));

        //4. SHOW eat() FOR EACH ICE CREAM AND try catch if null + SHOW PROFIT with toString()
        System.out.println(); //new line
        myIces.forEach(n->{
            try {
                n.eat();
            } catch(NullPointerException e){
                //do nothing
            }
        });
        System.out.println("\n"+iceCreamSeller);
        System.out.println("\n"+userChoice);
        System.out.println("\n########## End of Car Ice Cream Shop ##########");
    }
}

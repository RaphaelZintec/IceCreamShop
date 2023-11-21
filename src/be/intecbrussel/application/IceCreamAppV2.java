package be.intecbrussel.application;

import be.intecbrussel.eatables.*;
import be.intecbrussel.sellers.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class IceCreamAppV2 {
    private static Scanner sc = new Scanner(System.in);
    public static int icecreamChoice(){
        System.out.println("Choose your ice creams: ");
        System.out.println("Ice Rocket: 1");
        System.out.println("Cones:      2");
        System.out.println("Magnum:     3");
        return sc.nextInt();
    }
    public static int ballsNumberChoice(){
        System.out.println("Choose the number of balls: ");
        return sc.nextInt();
    }
    public static int ballsFlavorChoice(){
        System.out.println("Choose the flavor of balls: ");
        System.out.println("STRAWBERRY:     1");
        System.out.println("BANANA:         2");
        System.out.println("CHOCOLATE:      3");
        System.out.println("VANILLA:        4");
        System.out.println("LEMON:          5");
        System.out.println("STRACIATELLA:   6");
        System.out.println("MOKKA:          7");
        System.out.println("PISTACHE:       8");
        return sc.nextInt();
    }
    public static int magnumTypeChoice(){
        System.out.println("Choose the type of Magnum: ");
        System.out.println("MILKCHOCOLATE:          1");
        System.out.println("WHITECHOCOLATE:         2");
        System.out.println("BLACKCHOCOLATE:         3");
        System.out.println("ALPINENUTS:             4");
        System.out.println("ROMANTICSTRAWBERRIES:   5");
        return sc.nextInt();
    }

    public static void main(String[] args) {
        //Scanner
        icecreamChoice();

        //0. WELCOME MSG
        System.out.println("\n########## Start of Car Ice Cream Shop ##########\n");

        //1. INITIALIZATION
        //- ICE CREAM PRICES: CONE:1.5 (per ball)   ROCKET:2,           MAGNUM:2.5  (alpine nuts:*1.5, strawberries:*1.7)
        //- PROFIT:           CONE:*0.25            ROCKET:*0.2         MAGNUM:*0.01
        //- STOCK:            CONE:1                ROCKET:4
        //- STOCK BALLS:      STRAWBERRY 1          BANANA 0            CHOCOLATE 1         VANILLA 1       STRACIATELLA 1          LEMON 1     MOKKA 1     PISTACHE 1
        //- STOCK MAGNUM:     MILKCHOCOLATE 1       WHITECHOCOLATE 1    BLACKCHOCOLATE 0    ALPINENUTS 1    ROMANTICSTRAWBERRIES 1
        PriceList priceList             = new PriceList(1.5, 2.0, 2.5);
        Map<Enum, Integer> balls        = new HashMap<Enum, Integer>(){{ put(Cone.Flavor.STRAWBERRY, 1); put(Cone.Flavor.BANANA, 0); put(Cone.Flavor.CHOCOLATE, 1); put(Cone.Flavor.VANILLA, 1); put(Cone.Flavor.LEMON, 1); put(Cone.Flavor.STRACIATELLA, 1); put(Cone.Flavor.MOKKA, 1); put(Cone.Flavor.PISTACHE, 1); }};
        Map<Enum, Integer> magni        = new HashMap<Enum, Integer>(){{ put(Magnum.MagnumType.MILKCHOCOLATE, 1); put(Magnum.MagnumType.WHITECHOCOLATE, 1); put(Magnum.MagnumType.BLACKCHOCOLATE, 0); put(Magnum.MagnumType.ALPINENUTS, 1); put(Magnum.MagnumType.ROMANTICSTRAWBERRIES, 1); }};
        Stock stock                     = new Stock(4, 1, balls, magni);
        IceCreamSeller iceCreamSeller   = new IceCreamCar(priceList, stock);
        ArrayList<Eatable> myIces       = new ArrayList<Eatable>();

        //2. PLACING ORDERS: Profit starts with 0 and increment the next values:
        myIces.add(iceCreamSeller.orderCone(new Cone.Flavor[]{Cone.Flavor.BANANA, Cone.Flavor.LEMON})); //(1.5*1)*0.25  = 0.375 -> BANANA out of stock
        myIces.add(iceCreamSeller.orderIceRocket());                                                    //2*0.20        = 0.4
        myIces.add(iceCreamSeller.orderMagnum(Magnum.MagnumType.BLACKCHOCOLATE));                       //0*0.01        = 0     -> BLACKCHOCOLATE out of stock
        myIces.add(iceCreamSeller.orderMagnum(Magnum.MagnumType.ALPINENUTS));                           //(2.5*1.5)*0.01= 0.0375

        //3. SHOW eat() FOR EACH ICE CREAM AND try catch if null + SHOW PROFIT with toString()
        System.out.println(); //new line
        myIces.forEach(n->{
            try {
                n.eat();
            } catch(NullPointerException e){
                //do nothing
            }
        });
        System.out.println("\n"+iceCreamSeller);
        System.out.println("\n########## End of Car Ice Cream Shop ##########");
    }
}

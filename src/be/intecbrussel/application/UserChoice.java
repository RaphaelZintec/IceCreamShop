package be.intecbrussel.application;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.Magnum;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserChoice {

    private enum TypeOfIceCreams{
        ICEROCKET, CONE, MAGNUM;
    }
    private Map<Enum, Object> quantity = new HashMap<Enum, Object>(){{
        put(TypeOfIceCreams.ICEROCKET, 0);
        put(TypeOfIceCreams.CONE,   new HashMap<Enum, Integer>(){{put(Cone.Flavor.STRAWBERRY, 0); put(Cone.Flavor.BANANA, 0); put(Cone.Flavor.CHOCOLATE, 0); put(Cone.Flavor.VANILLA, 0); put(Cone.Flavor.LEMON, 0); put(Cone.Flavor.STRACIATELLA, 0); put(Cone.Flavor.MOKKA, 0); put(Cone.Flavor.PISTACHE, 0); }});
        put(TypeOfIceCreams.MAGNUM, new HashMap<Enum, Integer>(){{put(Magnum.MagnumType.MILKCHOCOLATE, 0); put(Magnum.MagnumType.WHITECHOCOLATE, 0); put(Magnum.MagnumType.BLACKCHOCOLATE, 0); put(Magnum.MagnumType.MILKCHOCOLATE, 0); put(Magnum.MagnumType.ALPINENUTS, 0); put(Magnum.MagnumType.ROMANTICSTRAWBERRIES, 0); }});
    }};
    private Scanner sc = new Scanner(System.in);
    private int value = 0;
    public void icecreamChoice(){
        System.out.println("Choose your ice cream: ");
        System.out.println("Ice Rocket: 1");
        System.out.println("Cones:      2");
        System.out.println("Magnum:     3");
        value = sc.nextInt();
        switch (value){
            case 1: quantity.put(TypeOfIceCreams.ICEROCKET, (int)quantity.get(TypeOfIceCreams.ICEROCKET)+1); break;
            case 2: ballsNumberChoice(); break;
            case 3: magnumTypeChoice();
        }
        System.out.println("Do you want another Ice Cream? Y/N");
        if (sc.nextLine().toLowerCase().equals("y")){
            icecreamChoice();
        }
        System.out.println(quantity);
    }
    public void ballsNumberChoice(){
        System.out.println("Choose the number of balls: ");
        ballsFlavorChoice(sc.nextInt());
    }
    public void ballsFlavorChoice(int nmbrBall){
        value = 0;
        int i = 0;
        do {
            System.out.println("Choose the flavor for ball #"+(++i));
            System.out.println("STRAWBERRY:     1");
            System.out.println("BANANA:         2");
            System.out.println("CHOCOLATE:      3");
            System.out.println("VANILLA:        4");
            System.out.println("LEMON:          5");
            System.out.println("STRACIATELLA:   6");
            System.out.println("MOKKA:          7");
            System.out.println("PISTACHE:       8");
            value = sc.nextInt();
            switch (value) {
                case 1: quantity.put(TypeOfIceCreams.CONE, ((HashMap<Enum, Integer>)quantity.get(TypeOfIceCreams.CONE)).put(Cone.Flavor.STRAWBERRY, ((HashMap<Enum, Integer>)quantity.get(TypeOfIceCreams.CONE)).get(Cone.Flavor.STRAWBERRY)+1 )  ); break;
                case 2: quantity.put(TypeOfIceCreams.CONE, ((HashMap<Enum, Integer>)quantity.get(TypeOfIceCreams.CONE)).put(Cone.Flavor.BANANA, ((HashMap<Enum, Integer>)quantity.get(TypeOfIceCreams.CONE)).get(Cone.Flavor.BANANA)+1 )  ); break;
                case 3: quantity.put(TypeOfIceCreams.CONE, ((HashMap<Enum, Integer>)quantity.get(TypeOfIceCreams.CONE)).put(Cone.Flavor.CHOCOLATE, ((HashMap<Enum, Integer>)quantity.get(TypeOfIceCreams.CONE)).get(Cone.Flavor.CHOCOLATE)+1 )  ); break;
                case 4: quantity.put(TypeOfIceCreams.CONE, ((HashMap<Enum, Integer>)quantity.get(TypeOfIceCreams.CONE)).put(Cone.Flavor.VANILLA, ((HashMap<Enum, Integer>)quantity.get(TypeOfIceCreams.CONE)).get(Cone.Flavor.VANILLA)+1 )  ); break;
                case 5: quantity.put(TypeOfIceCreams.CONE, ((HashMap<Enum, Integer>)quantity.get(TypeOfIceCreams.CONE)).put(Cone.Flavor.LEMON, ((HashMap<Enum, Integer>)quantity.get(TypeOfIceCreams.CONE)).get(Cone.Flavor.LEMON)+1 )  ); break;
                case 6: quantity.put(TypeOfIceCreams.CONE, ((HashMap<Enum, Integer>)quantity.get(TypeOfIceCreams.CONE)).put(Cone.Flavor.STRACIATELLA, ((HashMap<Enum, Integer>)quantity.get(TypeOfIceCreams.CONE)).get(Cone.Flavor.STRACIATELLA)+1 )  ); break;
                case 7: quantity.put(TypeOfIceCreams.CONE, ((HashMap<Enum, Integer>)quantity.get(TypeOfIceCreams.CONE)).put(Cone.Flavor.MOKKA, ((HashMap<Enum, Integer>)quantity.get(TypeOfIceCreams.CONE)).get(Cone.Flavor.MOKKA)+1 )  ); break;
                case 8: quantity.put(TypeOfIceCreams.CONE, ((HashMap<Enum, Integer>)quantity.get(TypeOfIceCreams.CONE)).put(Cone.Flavor.PISTACHE, ((HashMap<Enum, Integer>)quantity.get(TypeOfIceCreams.CONE)).get(Cone.Flavor.PISTACHE)+1 )  );
            }
        } while(value < 1 && value > 8 && --nmbrBall >= 0);
    }
    public void magnumTypeChoice(){
        value = 0;
        do {
            System.out.println("Choose the type of Magnum: ");
            System.out.println("MILKCHOCOLATE:          1");
            System.out.println("WHITECHOCOLATE:         2");
            System.out.println("BLACKCHOCOLATE:         3");
            System.out.println("ALPINENUTS:             4");
            System.out.println("ROMANTICSTRAWBERRIES:   5");
            value = sc.nextInt();
            switch (value) {
                case 1: quantity.put(TypeOfIceCreams.MAGNUM, ((HashMap<Enum, Integer>)quantity.get(TypeOfIceCreams.MAGNUM)).put(Magnum.MagnumType.MILKCHOCOLATE, ((HashMap<Enum, Integer>)quantity.get(TypeOfIceCreams.MAGNUM)).get(Magnum.MagnumType.MILKCHOCOLATE)+1 )  ); break;
                case 2: quantity.put(TypeOfIceCreams.MAGNUM, ((HashMap<Enum, Integer>)quantity.get(TypeOfIceCreams.MAGNUM)).put(Magnum.MagnumType.WHITECHOCOLATE, ((HashMap<Enum, Integer>)quantity.get(TypeOfIceCreams.MAGNUM)).get(Magnum.MagnumType.WHITECHOCOLATE)+1 )  ); break;
                case 3: quantity.put(TypeOfIceCreams.MAGNUM, ((HashMap<Enum, Integer>)quantity.get(TypeOfIceCreams.MAGNUM)).put(Magnum.MagnumType.BLACKCHOCOLATE, ((HashMap<Enum, Integer>)quantity.get(TypeOfIceCreams.MAGNUM)).get(Magnum.MagnumType.BLACKCHOCOLATE)+1 )  ); break;
                case 4: quantity.put(TypeOfIceCreams.MAGNUM, ((HashMap<Enum, Integer>)quantity.get(TypeOfIceCreams.MAGNUM)).put(Magnum.MagnumType.ALPINENUTS, ((HashMap<Enum, Integer>)quantity.get(TypeOfIceCreams.MAGNUM)).get(Magnum.MagnumType.ALPINENUTS)+1 )  ); break;
                case 5: quantity.put(TypeOfIceCreams.MAGNUM, ((HashMap<Enum, Integer>)quantity.get(TypeOfIceCreams.MAGNUM)).put(Magnum.MagnumType.ROMANTICSTRAWBERRIES, ((HashMap<Enum, Integer>)quantity.get(TypeOfIceCreams.MAGNUM)).get(Magnum.MagnumType.ROMANTICSTRAWBERRIES)+1 )  );
            }
        } while(value < 1 && value > 5);
    }
}

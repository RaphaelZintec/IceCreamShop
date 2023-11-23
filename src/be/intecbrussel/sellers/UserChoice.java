package be.intecbrussel.sellers;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.Magnum;

import java.util.*;

public class UserChoice {

    public enum TypeOfIceCreams{
        ICEROCKET, CONE, MAGNUM;
    }
    private Map<Enum, Integer> icerocketMap      = new HashMap<Enum, Integer>(){{put(TypeOfIceCreams.ICEROCKET, 0); }};
    private Map<Enum, Integer> flavorMapTemplate = new HashMap<Enum, Integer>(){{put(Cone.Flavor.STRAWBERRY, 0); put(Cone.Flavor.BANANA, 0); put(Cone.Flavor.CHOCOLATE, 0); put(Cone.Flavor.VANILLA, 0); put(Cone.Flavor.LEMON, 0); put(Cone.Flavor.STRACIATELLA, 0); put(Cone.Flavor.MOKKA, 0); put(Cone.Flavor.PISTACHE, 0); }};
    private Map<Enum, Integer> magnumMap         = new HashMap<Enum, Integer>(){{put(Magnum.MagnumType.MILKCHOCOLATE, 0); put(Magnum.MagnumType.WHITECHOCOLATE, 0); put(Magnum.MagnumType.BLACKCHOCOLATE, 0); put(Magnum.MagnumType.MILKCHOCOLATE, 0); put(Magnum.MagnumType.ALPINENUTS, 0); put(Magnum.MagnumType.ROMANTICSTRAWBERRIES, 0); }};
    private ArrayList<HashMap<Enum, Integer>> flavorMapArray        = new ArrayList<>();
    public Scanner sc = new Scanner(System.in);
    private int value = 0;
    private static int icecreamCount = 0;
    public void icecreamChoice(){
        System.out.println("\nChoose your ice cream n°"+(++icecreamCount));
        System.out.println("1 Ice Rocket \uD83D\uDE80");
        System.out.println("2 Cones \uD83C\uDF67");
        System.out.println("3 Magnum \uD83C\uDF62");

        do {
            try {
                value = sc.nextInt();
                if (value<1 || value>3) {
                    System.out.println("\uD83D\uDD34 Enter only a number between 1-3");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("\uD83D\uDD34 Enter only a number between 1-3");
                sc.nextLine();
                continue;
            }
            break;
        } while (true);

        switch (value){
            case 1: icerocketMap.put(TypeOfIceCreams.ICEROCKET, icerocketMap.get(TypeOfIceCreams.ICEROCKET)+1); break;
            case 2: ballsNumberChoice(); break;
            case 3: magnumTypeChoice();
        }
        sc.nextLine();
    }
    public void ballsNumberChoice(){
        System.out.println("\nChoose the number of balls \uD83C\uDF67");
        int ballsFlavorChoiceValue = 0;
        do {
            try {
                ballsFlavorChoiceValue = sc.nextInt();
                if (ballsFlavorChoiceValue<1 || ballsFlavorChoiceValue>5) {
                    System.out.println("\uD83D\uDD34 Enter only a number between 1-5");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("\uD83D\uDD34 Enter only a number between 1-5");
                sc.nextLine();
                continue;
            }
            break;
        } while (true);
        ballsFlavorChoice(ballsFlavorChoiceValue);
    }
    public void ballsFlavorChoice(int nmbrBall){
        value = 0;
        int indexBall = 0;
        flavorMapArray.add(new HashMap<Enum, Integer>(){{putAll(flavorMapTemplate);}});
        int indexFMA = flavorMapArray.size()-1;
        do {
            System.out.println("\nChoose the flavor for ball \uD83C\uDF68 #"+(++indexBall));
            System.out.println("STRAWBERRY:     1");
            System.out.println("BANANA:         2");
            System.out.println("CHOCOLATE:      3");
            System.out.println("VANILLA:        4");
            System.out.println("LEMON:          5");
            System.out.println("STRACIATELLA:   6");
            System.out.println("MOKKA:          7");
            System.out.println("PISTACHE:       8");


            do {
                try {
                    value = sc.nextInt();
                    if (value<1 || value>8) {
                        System.out.println("\uD83D\uDD34 Enter only a number between 1-8");
                        continue;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("\uD83D\uDD34 Enter only a number between 1-8");
                    sc.nextLine();
                    continue;
                }
                break;
            } while (true);

            switch (value) {
                case 1: flavorMapArray.get(indexFMA).put(Cone.Flavor.STRAWBERRY, flavorMapArray.get(indexFMA).get(Cone.Flavor.STRAWBERRY)+1); break;
                case 2: flavorMapArray.get(indexFMA).put(Cone.Flavor.BANANA, flavorMapArray.get(indexFMA).get(Cone.Flavor.BANANA)+1); break;
                case 3: flavorMapArray.get(indexFMA).put(Cone.Flavor.CHOCOLATE, flavorMapArray.get(indexFMA).get(Cone.Flavor.CHOCOLATE)+1); break;
                case 4: flavorMapArray.get(indexFMA).put(Cone.Flavor.VANILLA, flavorMapArray.get(indexFMA).get(Cone.Flavor.VANILLA)+1); break;
                case 5: flavorMapArray.get(indexFMA).put(Cone.Flavor.LEMON, flavorMapArray.get(indexFMA).get(Cone.Flavor.LEMON)+1); break;
                case 6: flavorMapArray.get(indexFMA).put(Cone.Flavor.STRACIATELLA, flavorMapArray.get(indexFMA).get(Cone.Flavor.STRACIATELLA)+1); break;
                case 7: flavorMapArray.get(indexFMA).put(Cone.Flavor.MOKKA, flavorMapArray.get(indexFMA).get(Cone.Flavor.MOKKA)+1); break;
                case 8: flavorMapArray.get(indexFMA).put(Cone.Flavor.PISTACHE, flavorMapArray.get(indexFMA).get(Cone.Flavor.PISTACHE)+1);
            }
        } while( --nmbrBall > 0);
    }
    public void magnumTypeChoice(){
        value = 0;
        do {
            System.out.println("\nChoose the type of Magnum \uD83C\uDF62");
            System.out.println("MILKCHOCOLATE:          1");
            System.out.println("WHITECHOCOLATE:         2");
            System.out.println("BLACKCHOCOLATE:         3");
            System.out.println("ALPINENUTS:             4");
            System.out.println("ROMANTICSTRAWBERRIES:   5");

            do {
                try {
                    value = sc.nextInt();
                    if (value<1 || value>5) {
                        System.out.println("\uD83D\uDD34 Enter only a number between 1-5");
                        continue;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("\uD83D\uDD34 Enter only a number between 1-5");
                    sc.nextLine();
                    continue;
                }
                break;
            } while (true);

            switch (value) {
                case 1: magnumMap.put(Magnum.MagnumType.MILKCHOCOLATE, magnumMap.get(Magnum.MagnumType.MILKCHOCOLATE)+1); break;
                case 2: magnumMap.put(Magnum.MagnumType.WHITECHOCOLATE, magnumMap.get(Magnum.MagnumType.WHITECHOCOLATE)+1); break;
                case 3: magnumMap.put(Magnum.MagnumType.BLACKCHOCOLATE, magnumMap.get(Magnum.MagnumType.BLACKCHOCOLATE)+1); break;
                case 4: magnumMap.put(Magnum.MagnumType.ALPINENUTS, magnumMap.get(Magnum.MagnumType.ALPINENUTS)+1); break;
                case 5: magnumMap.put(Magnum.MagnumType.ROMANTICSTRAWBERRIES, magnumMap.get(Magnum.MagnumType.ROMANTICSTRAWBERRIES)+1);
            }
        } while(value < 1 && value > 5);
    }

    public Map<Enum, Integer> getIcerocketMap() {
        return icerocketMap;
    }

    public ArrayList<HashMap<Enum, Integer>> getFlavorMapArray() {
        return flavorMapArray;
    }

    public Map<Enum, Integer> getMagnumMap() {
        return magnumMap;
    }

    @Override
    public String toString() {
        return "\uD83D\uDC81 User choices" +
                "\n\t\uD83D\uDE80 Ice Rocket   = " + icerocketMap +
                "\n\t\uD83C\uDF67 Cones        = " + flavorMapArray +
                "\n\t\uD83C\uDF62 Magnum       = " + magnumMap;
    }
}

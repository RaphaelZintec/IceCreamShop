package be.intecbrussel.eatables;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Cone implements Eatable{
    //ENUMS
    public enum Flavor {
        STRAWBERRY, BANANA, CHOCOLATE, VANILLA, LEMON, STRACIATELLA, MOKKA, PISTACHE;
    }

    //ATTRIBUTES
    private Flavor[] balls;

    //CONSTRUCTORS
    public Cone(){}
    public Cone(Flavor[] balls) {
        this.balls = balls;
    }

    //METHODS
    @Override
    public void eat() {
        String typeOfBalls = Arrays.stream(balls).map(Enum::name).collect(Collectors.joining(" & "));
        int numberOfBalls  = (int)Arrays.stream(balls).count();
        System.out.println("You are eating a cone with "+numberOfBalls+" balls with flavor "+typeOfBalls);
    }
}

package be.intecbrussel.eatables;

public class IceRocket implements Eatable{
    //CONSTRUCTORS
    public void IceRocket(){}

    //METHODS
    @Override
    public void eat() {
        System.out.println("\uD83D\uDE1B You are eating an ice rocket");
    }
}

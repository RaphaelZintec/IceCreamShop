package be.intecbrussel.eatables;

public class Magnum implements Eatable{
    //ENUMS
    public enum MagnumType {
        MILKCHOCOLATE, WHITECHOCOLATE, BLACKCHOCOLATE, ALPINENUTS, ROMANTICSTRAWBERRIES;
    }

    //ATTRIBUTES
    private MagnumType type;

    //CONSTRUCTORS
    public Magnum(){}
    public Magnum(MagnumType type) {
        this.type = type;
    }

    //METHODS
    @Override
    public void eat() {
        System.out.println("You are eating a "+type+" Magnum");
    }

    public MagnumType getType() {
        return type;
    }

}

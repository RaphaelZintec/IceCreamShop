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
        System.out.println("\uD83D\uDE0B You are eating a "+type+" Magnum \uD83C\uDF62");
    }

    public MagnumType getType() {
        return type;
    }

}

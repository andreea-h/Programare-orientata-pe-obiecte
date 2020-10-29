public class Cffee {
    public static void main(String[] args) {
 
        CoffeeMaker coffeemaker = new StarbucksCoffeeMaker();
        Cffee espresso = new Espresso();
        Cappuccino cappuccino = new Cappuccino();
 
        coffeemaker.makeCoffee(espresso);
        coffeemaker.makeCoffee(cappuccino);
    }
}
 
class Espresso extends Cffee {
}
 
class Cappuccino extends Cffee {
}
 
class CoffeeMaker {
    public void makeCoffee(Cffee coffee) {
        System.out.println("Making coffee");
    }
 
    public void makeCoffee(Espresso coffee) {
        System.out.println("Making espresso");
    }
 
    public void makeCoffee(Cappuccino coffee) {
        System.out.println("Making cappuccino");
    }
}
 
class StarbucksCoffeeMaker extends CoffeeMaker {
    public void makeCoffee(Espresso coffee) {
        System.out.println("Making sugar espresso");
    }
 
    public void makeCoffee(Cappuccino coffee) {
        System.out.println("Making sugar cappuccino");
    }
}
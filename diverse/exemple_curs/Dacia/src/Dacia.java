class Dacia {
    String model = "duster";
   
    public Dacia() {
       
        printModel();
    }
 
    void printModel() {
        System.out.print(model);
    }
}
 
class Ferrari extends Dacia {
    String series = "f40";
    
    void printModel() {
        System.out.print(series);
    }
 
    public static void main(String[] args) {
        Ferrari myCar = new Ferrari();
        Dacia obj = new Dacia();
        System.out.println(obj.model);
        obj.model = "ceva";
        Dacia obj2 = new Dacia();
        System.out.println(obj2.model);
    }
}
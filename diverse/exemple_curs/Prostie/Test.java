class Test<String> {
    String my;
    private int h;
    public Test(String my) {
        this.my = my;
        
    }
    public String get() {
        return my;
    }
}

class RunTest {
    public static void main(String[] args) {
        Integer i = new Test<Integer>(1).get();
        System.out.println(i.getClass());
        int as=3, bs=2, cs=4;
        System.out.println(((as<bs++)&(cs++ < bs))+" ");
        System.out.println(as+" "+bs+" "+cs);
        System.out.println(((as<bs++)&&(cs++ < bs))+" ");
        System.out.println(as+" "+bs+" "+cs);
    }
}
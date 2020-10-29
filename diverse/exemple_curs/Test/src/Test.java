import java.util.*;
class Test 
{ 
    // static variable 
    static int a = 10; 
    static int b; 
      
    // static block 
    static { 
        System.out.println("Static block initialized."); 
        b = a * 4; 
    } 
    
    public static void doSomething(double num) {
    	System.out.println("double : " + num);
    	}
    public static void doSomething(Integer num) {
    	System.out.println("Integer : " + num);
    	}
  
    public static void main(String[] args) 
    { 
       System.out.println("from main"); 
       System.out.println("Value of a : "+a); 
       System.out.println("Value of b : "+b); 
       b = b*2;
       System.out.println("Value of b : "+b); 
       List list = new ArrayList();
       list.add(0, 59);
       int total =(Integer) list.get(0);
       System.out.println(total);
       String[] words = new String[] {"aaa", "bbb", "ccc", "aaa"};
       doSomething(1);
       doSomething(2.0);
     
    } 
} 
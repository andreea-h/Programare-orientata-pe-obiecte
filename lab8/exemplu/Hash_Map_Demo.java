// Java code to illustrate the entrySet() method 
import java.util.*; 
  
public class Hash_Map_Demo { 
    public static void main(String[] args) 
    { 
  
        // Creating an empty HashMap 
        HashMap<Integer, String> hash_map = new HashMap<Integer, String>(); 
  
        // Mapping string values to int keys 
        hash_map.put(10, "Geeks"); 
        hash_map.put(15, "4"); 
        hash_map.put(20, "Geeks"); 
        hash_map.put(25, "Welcomes"); 
        hash_map.put(30, "You"); 
  
        // Displaying the HashMap 
        System.out.println("Initial Mappings are: " + hash_map); 
        Set mySet = hash_map.entrySet();
        System.out.println(mySet);
        // Using entrySet() to get the set view 
        System.out.println("The set is: " + hash_map.entrySet()); 
    } 
} 

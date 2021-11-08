/**
 * 
 */
import java.util.*;

public class WarriorPack {
    private Vector warriors ;

    public WarriorPack () {
        warriors = new Vector();
    }

    public void addWarrior(Warrior newWarrior) {
        warriors.add(newWarrior);
    }

    public Vector getWarriors() {
        return warriors ;
    }
    
    public String toString() {
    	return warriors.toString();
    }
    
    
    public int calculateDamage() {
        int damage = 0;
        for (int i = 0; i < warriors.size(); i++) {
        	Object v = warriors.get(i);
        	Class clasa = v.getClass();
        	if(clasa.getName().equals("SNAKE_Warrior")) {
        		SNAKE_Warrior nou=(SNAKE_Warrior)v;
        		damage += nou.getDamage();
        	}
        	if(clasa.getName().equals("MARSHMALLOW_MAN_Warrior")) {
        		MARSHMALLOW_MAN_Warrior nou=(MARSHMALLOW_MAN_Warrior)v;
        		damage += nou.getDamage();
        	}
        	if(clasa.getName().equals("ORGE_Warrior")) {
        		OGRE_Warrior nou=(OGRE_Warrior)v;
        		damage += nou.getDamage();
        	}
        }
        return damage;
    }
    
    public static void main(String args[]){
    
    	WarriorPack echipa = new WarriorPack();
    	echipa.addWarrior(new OGRE_Warrior(10,"Dragon"));
    	echipa.addWarrior(new MARSHMALLOW_MAN_Warrior(2,"Dragon1"));
    	echipa.addWarrior(new SNAKE_Warrior(100,"Dragon3"));
    	echipa.addWarrior(new MARSHMALLOW_MAN_Warrior(8,"Dragon4"));
    	echipa.addWarrior(new SNAKE_Warrior(2,"Dragon5"));
    	System.out.println(echipa.toString());
    	System.out.println(echipa.calculateDamage());
    	
    }
}

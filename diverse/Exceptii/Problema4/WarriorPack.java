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
        		ORGE_Warrior nou=(ORGE_Warrior)v;
        		damage += nou.getDamage();
        	}
        }
        return damage;
    }
    
    public static void main(String args[]){
    
    	WarriorPack echipa = new WarriorPack();
    	echipa.addWarrior(new ORGE_Warrior(10,"Dragon"));
    	echipa.addWarrior(new MARSHMALLOW_MAN_Warrior(2,"Gigel"));
    	echipa.addWarrior(new SNAKE_Warrior(100,"DINOZAUR"));
    	echipa.addWarrior(new MARSHMALLOW_MAN_Warrior(8,"MArio"));
    	System.out.println(echipa.toString());
    	System.out.println(echipa.calculateDamage());
    	
    }
}


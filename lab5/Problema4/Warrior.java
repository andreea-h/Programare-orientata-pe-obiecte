import java.util.*;
public class Warrior {
//    public static final int SNAKE_Warrior = 0;
//   public static final int OGRE_Warrior = 1;
//    public static final int MARSHMALLOW_MAN_Warrior = 2;
    //Stores one of the three above types
    //0 = dead, 100 = full strength
    public int health;
    public String name;
    public Warrior (int health, String name) {
        this.health = health;
        this.name = name;
    }
    
    public String toString() {
    	return getClass().getName()+" "+name+" "+health;
    }
    
}

class SNAKE_Warrior extends Warrior {
	public static final int snake_damage = 1;
	public SNAKE_Warrior(int health, String name) {
		super(health, name);
	}
	public int getDamage() {
		return snake_damage;
	}
}

class OGRE_Warrior extends Warrior {
	public static final int ogre_damage = 6;
	public OGRE_Warrior(int health, String name) {
		super(health, name);
	}
	public int getDamage() {
		return ogre_damage;
	}
}

class MARSHMALLOW_MAN_Warrior extends Warrior {
	public static final int MARSHMALLOW_MAN_damage = 10;
	public MARSHMALLOW_MAN_Warrior(int health, String name) {
		super(health, name);
	}
	public int getDamage() {
		return MARSHMALLOW_MAN_damage;
	}
}





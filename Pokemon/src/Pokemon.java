import java.text.DecimalFormat;
import java.util.Random;

public class Pokemon {
    private String name;
    private int id;
    private Type type;
    private int level;
    private int evolLevel1, evolLevel2;
    private double strength;
    private double health;

    public Pokemon(int id, String name, Type type, double strength, double health)
    {
        this.id = id;
        this.name = name;
        this.type = type;
        this.strength = strength;
        this.health = health;
        this.level = 1;
        this.evolLevel1 = 15;
        this.evolLevel2 = 1000;
    }

    public Pokemon(int id, String name, Type type, double strength, double health, int evolLevel1)
    {
        this.id = id;
        this.name = name;
        this.type = type;
        this.strength = strength;
        this.health = health;
        this.evolLevel1 = evolLevel1;

        this.level = 1;
        this.evolLevel2 = 32;
    }

    public void evolve(String evolName)
    {
        strength*=2;
        ++id;

        System.out.println("##############################################");
        System.out.println("Your " + this.name.toUpperCase() + " has evolved to " + evolName.toUpperCase());
        System.out.println("##############################################");
        this.name = evolName;
    }


    public void levelUp(String evolName)
    {
        ++level;
        strength*=1.2;
        health*=1.2;

        if(level == evolLevel1 || level == evolLevel2)
        {
            evolve(evolName);
        }
    }

    public String getAttackName(Type type)
    {
        String attack = null;

        switch(type)
        {
            case FIRE:
                attack = "FLARE";
                break;

            case WATER:
                attack = "HYDRO-PUMP";
                break;
            
            case GRASS:
                attack = "SOLAR BEAM";
                break;

            default:
                break;
        }

        return attack;
    }

    public boolean toCombat(Pokemon enemy, String evolName)
    {
        DecimalFormat df = new DecimalFormat("###.##");
        boolean result = false;
        double combatStrength = checkStrengthByType(enemy);
        double enemyStrength = enemy.checkStrengthByType(this);
        String enemyAttack = getAttackName(enemy.getType());
        String playerAttack = getAttackName(this.getType());
        double enemyHP = enemy.health, playerHP = this.health;

        System.out.println("Player:  " + this.toString() + " VS " + enemy.toString());

        while(playerHP > 0 && enemyHP > 0)
        {
            playerHP-=enemyStrength;
            System.out.println("Enemy " + enemy.getName() + " used " + enemyAttack + ", inflicts " + df.format(enemyStrength) + " of damage.");
          
            enemyHP-=combatStrength;
            System.out.println("Your " + this.getName() + " used " + playerAttack + ", inflicts " + df.format(combatStrength) + " of damage.");
        }

        if(playerHP <= 0)
        {
            result = false;
            System.out.println("You lost");
        }else
        {
            result = true;
            levelUp(evolName);
            System.out.println("You win, " + this.name + "'s level has increased to level " + this.level);
        }

        return result;
    }

    public double checkStrengthByType(Pokemon enemy)
    {
        double combatStrength = this.strength;

        switch(this.type)
        {
            case FIRE:
                
                if(enemy.getType() == Type.WATER || enemy.getType() == Type.FIRE)
                    combatStrength/=2;
                else if(enemy.getType() == Type.GRASS)
                    combatStrength*=2;

                break;

            case GRASS:

                if(enemy.getType() == Type.FIRE || enemy.getType() == Type.GRASS)
                    combatStrength/=2;
                else if(enemy.getType() == Type.WATER)
                    combatStrength*=2;

                break;

            case WATER:

                if(enemy.getType() == Type.GRASS || enemy.getType() == Type.WATER)
                    combatStrength/=2;
                else if(enemy.getType() == Type.FIRE)
                    combatStrength*=2;

                break;

            default:
                break;
        }

        return combatStrength;
    }

    public void toTrain(String evolname)
    {
        Random random = new Random();
        int success = random.nextInt(10);
        levelUp(evolname);
        System.out.println("Training was succesfull, "+ this.getName() + "'s level has increased to level " + this.level);

       /*if(success%2==0)
        {
            levelUp(evolname);
            System.out.println("Training was succesfull, "+ this.getName() + "'s level has increased to level " + this.level);
        }else
        {
            System.out.println("Training failed!");
        }*/

    }

    public double getStrength() { return strength; }
    public double getHP() { return health; }
    public Type getType() { return type; }
    public int getId() { return id; }
    public String getName(){ return name; }
    public void setHP(double health) { this.health = health; }
    
    @Override
    public String toString()
    {
        DecimalFormat df = new DecimalFormat("###.##");
        return "["+ name + ", LVL: " + level +" , " + type + " , HP: " +  df.format(health) + " , ST: " +  df.format(strength) + "]";
    }

}

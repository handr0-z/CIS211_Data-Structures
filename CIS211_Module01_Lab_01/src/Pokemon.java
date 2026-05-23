public class Pokemon
{
    // Declare any variables needed for class
    private String name;
    private double healthPoints;
    private double attackPoints;
    private double defensePoints;

    // Constructor to Initialize with specific information
    public Pokemon(String name, double healthPoints, double attackPoints, double defensePoints)
    {
        this.name = name;
        this.healthPoints = healthPoints;
        this.attackPoints = attackPoints;
        this.defensePoints = defensePoints;
    }

    // Methods to obtain information
    public String getName() {return name;}
    public double getHealthPoints() {return healthPoints;}
    public double getAttackPoints() {return attackPoints;}
    public double getDefensePoints() {return defensePoints;}

    // Method to set HP.
    public void setHealthPoints(double healthPoints)
    {
        this.healthPoints = healthPoints;
        if (this.healthPoints < 0) {this.healthPoints = 0;}
    }
}

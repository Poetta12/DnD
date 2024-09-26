package model;

public abstract class DefenseEquipment {
    private String type;
    private int power; // Cela représente la défense ici
    private String name;

    public DefenseEquipment(String type, int power, String name) {
        this.type = type;
        this.power = power;
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power; // Setter pour modifier la puissance
    }

    public int getDefense() {
        return getPower(); // Utiliser la méthode de la classe parente pour obtenir la défense
    }

    @Override
    public String toString() {
        return name + " (Type: " + type + ", Puissance: " + power + ")";
    }
}

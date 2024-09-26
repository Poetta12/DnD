package model; // Déclaration du package model

// Classe abstraite représentant un équipement de bataille
public abstract class BattleEquipment {
    private String type; // Type de l'équipement (ex: arme, armure)
    private int power; // Puissance de l'équipement
    private String name; // Nom de l'équipement

    // Constructeur de la classe BattleEquipment
    public BattleEquipment(String type, int power, String name) {
        this.type = type; // Initialisation du type
        this.power = power; // Initialisation de la puissance
        this.name = name; // Initialisation du nom
    }

    // Getter pour la puissance de l'équipement
    public int getPower() {
        return power; // Retourne la puissance
    }

    // Getter pour le nom de l'équipement
    public String getName() {
        return name; // Retourne le nom
    }

    // Méthode toString() pour représenter l'équipement sous forme de chaîne
    @Override
    public String toString() {
        return name + " (Type: " + type + ", Puissance: " + power + ")"; // Format de la représentation de l'équipement
    }
}

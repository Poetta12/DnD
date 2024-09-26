package weapons;

import model.DefenseEquipment;

// Classe représentant une arme de défense, héritant de DefenseEquipment
public class DefenseWeapon extends DefenseEquipment {

    // Constructeur pour initialiser les attributs de l'arme de défense
    public DefenseWeapon(String name, int defense, String type) {
        super(type, defense, name); // Appeler le constructeur de la classe parente
    }

    // Méthode pour obtenir la valeur de défense
    public int getDefenseValue() {
        return getPower(); // Utiliser la méthode de la classe parente pour obtenir la défense
    }
}

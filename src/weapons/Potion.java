package weapons;

import model.DefenseEquipment;

// Classe représentant une Potion, héritant de DefenseEquipment
public class Potion extends DefenseEquipment {

    // Constructeur pour initialiser les attributs de la Potion
    public Potion(String type, int power, String name) {
        super(type, power, name); // Appeler le constructeur de la classe parente
    }
}

package weapons;

import model.DefenseEquipment;

// Classe représentant un Philtre, héritant de DefenseEquipment
public class Philtre extends DefenseEquipment {

    // Constructeur pour initialiser les attributs du Philtre
    public Philtre(String type, int power, String name) {
        super(type, power, name); // Appeler le constructeur de la classe parente
    }
}

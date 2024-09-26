package weapons;

import model.DefenseEquipment;

// Classe représentant un Bouclier, héritant de DefenseEquipment
public class Shield extends DefenseEquipment {

    // Constructeur pour initialiser les attributs du Bouclier
    public Shield(String type, int power, String name) {
        super(type, power, name); // Appeler le constructeur de la classe parente
    }
}

package weapons;

import weapons.AttackWeapon;

// Classe représentant une Arme Simple, héritant de AttackWeapon
public class SingleWeapon extends AttackWeapon {

    // Constructeur pour initialiser les attributs de l'Arme Simple
    public SingleWeapon(String type, int damage, String name) {
        super(type, damage, name); // Appeler le constructeur de la classe parente
    }
}

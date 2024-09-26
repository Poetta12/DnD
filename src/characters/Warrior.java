package characters;

import model.Character; // Import de la classe Character
import weapons.AttackWeapon; // Import de la classe AttackWeapon pour les équipements offensifs
import weapons.DefenseWeapon; // Import de la classe DefenseWeapon pour les équipements défensifs

// Classe représentant un Guerrier, sous-classe de Character
public class Warrior extends Character {

    // Constructeur de Warrior avec le nom comme paramètre
    public Warrior(String name) {
        super(name, "guerrier"); // Appelle le constructeur de la superclasse avec le nom et le type "guerrier"
        this.maxLife = 10; // Définit les points de vie maximum du guerrier
        this.life = maxLife; // Initialise les points de vie actuels au maximum
        this.attack = 5; // Définit la puissance d'attaque du guerrier
        // Initialise l'équipement d'attaque du guerrier avec une arme nommée "Couteau"
        this.battleEquipment = new AttackWeapon("Arme", 1, "Couteau");
        // Initialise l'équipement de défense du guerrier avec un bouclier nommé "Bouclier de Fer"
        this.defenseEquipment = new DefenseWeapon("Bouclier", 3, "Bouclier de Fer");
    }

    // Méthode toString pour afficher les informations du guerrier
    @Override
    public String toString() {
        // Retourne une chaîne formatée avec le nom, les points de vie et la force d'attaque du guerrier
        return "Guerrier: " + getName() + ", Vie: " + getLifePoints() + ", Force: " + getAttackPower();
    }
}

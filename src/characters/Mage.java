package characters;

import model.Character; // Import de la classe Character
import weapons.AttackWeapon; // Import de la classe AttackWeapon pour les équipements offensifs
import weapons.DefenseWeapon; // Import de la classe DefenseWeapon pour les équipements défensifs

// Classe représentant un Magicien, sous-classe de Character
public class Mage extends Character {

    // Constructeur de Mage avec le nom comme paramètre
    public Mage(String name) {
        super(name, "magicien"); // Appelle le constructeur de la superclasse avec le nom et le type "magicien"
        this.maxLife = 6; // Définit les points de vie maximum du magicien
        this.life = maxLife; // Initialise les points de vie actuels au maximum
        this.attack = 15; // Définit la puissance d'attaque du magicien
        // Initialise l'équipement d'attaque du magicien avec un sort nommé "Boule de Feu"
        this.battleEquipment = new AttackWeapon("Sort", 5, "Boule de Feu");
        // Initialise l'équipement de défense du magicien avec une robe nommée "Robe de Magicien"
        this.defenseEquipment = new DefenseWeapon("Robe", 1, "Robe de Magicien");
    }

    // Méthode toString pour afficher les informations du magicien
    @Override
    public String toString() {
        // Retourne une chaîne formatée avec le nom, les points de vie et la force d'attaque du magicien
        return "Magicien: " + getName() + ", Vie: " + getLifePoints() + ", Force: " + getAttackPower();
    }
}

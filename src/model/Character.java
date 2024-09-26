package model; // Déclaration du package contenant la classe Character

import weapons.AttackWeapon; // Import de la classe AttackWeapon
import weapons.DefenseWeapon; // Import de la classe DefenseWeapon

// Classe représentant un personnage dans le jeu
public class Character {
    protected String name; // Attribut pour stocker le nom du personnage
    protected String type; // Attribut pour stocker le type de personnage
    protected int life; // Attribut pour stocker les points de vie du personnage
    protected int maxLife; // Attribut pour stocker le maximum de points de vie
    protected int attack; // Attribut pour stocker la puissance d'attaque du personnage
    protected AttackWeapon battleEquipment; // Attribut pour l'équipement d'attaque du personnage
    protected DefenseWeapon defenseEquipment; // Attribut pour l'équipement de défense du personnage

    // Constructeur par défaut
    public Character() {
        this.name = ""; // Initialisation du nom à une chaîne vide
        this.type = ""; // Initialisation du type à une chaîne vide
        this.life = 0; // Initialisation des points de vie à 0
        this.maxLife = 0; // Initialisation des points de vie maximum à 0
        this.attack = 0; // Initialisation de la puissance d'attaque à 0
        this.battleEquipment = null; // Initialisation de l'équipement d'attaque à null
        this.defenseEquipment = null; // Initialisation de l'équipement de défense à null
    }

    // Constructeur avec un paramètre pour le nom
    public Character(String name) {
        this.name = name; // Initialisation du nom avec le paramètre donné
        this.type = ""; // Initialisation du type à une chaîne vide
        this.life = 0; // Initialisation des points de vie à 0
        this.maxLife = 0; // Initialisation des points de vie maximum à 0
        this.attack = 0; // Initialisation de la puissance d'attaque à 0
        this.battleEquipment = null; // Initialisation de l'équipement d'attaque à null
        this.defenseEquipment = null; // Initialisation de l'équipement de défense à null
    }

    // Constructeur avec des paramètres pour le nom et le type
    public Character(String name, String type) {
        this.name = name; // Initialisation du nom avec le paramètre donné
        this.type = type; // Initialisation du type avec le paramètre donné

        // Initialisation des attributs selon le type de personnage
        if (type.equals("guerrier")) { // Vérifie si le type est "guerrier"
            this.maxLife = 10; // Points de vie maximum pour un guerrier
            this.life = maxLife; // Initialiser les points de vie à la valeur maximum
            this.attack = 5; // Puissance d'attaque pour un guerrier
            this.battleEquipment = new AttackWeapon("Arme", 1, "Couteau"); // Création d'une arme pour le guerrier
            this.defenseEquipment = new DefenseWeapon("Bouclier", 3, "Bouclier de Fer"); // Création d'un bouclier pour le guerrier
        } else if (type.equals("magicien")) { // Vérifie si le type est "magicien"
            this.maxLife = 6; // Points de vie maximum pour un magicien
            this.life = maxLife; // Initialiser les points de vie à la valeur maximum
            this.attack = 6; // Puissance d'attaque pour un magicien
            this.battleEquipment = new AttackWeapon("Sort", 1, "Etincelle"); // Création d'un sort pour le magicien
            this.defenseEquipment = new DefenseWeapon("Philtre", 2, "Philtre de Défense"); // Création d'un philtre pour le magicien
        } else { // Si le type n'est ni guerrier ni magicien
            this.maxLife = 0; // Points de vie maximum restent à 0
            this.life = 0; // Points de vie restent à 0
            this.attack = 0; // Puissance d'attaque reste à 0
            this.battleEquipment = null; // Aucun équipement d'attaque
            this.defenseEquipment = null; // Aucun équipement de défense
        }
    }

    // Méthode pour obtenir la défense du personnage
    public int getDefense() {
        return defenseEquipment != null ? defenseEquipment.getPower() : 0; // Renvoie la valeur de défense ou 0 si l'équipement est null
    }

    // Méthode pour infliger des dégâts au personnage
    public void receiveDamage(int damage) {
        int actualDamage = damage - this.defenseEquipment.getDefense(); // Calcul des dégâts réels après défense
        if (actualDamage < 0) actualDamage = 0; // Pas de dégâts négatifs
        this.life -= actualDamage; // Soustraction des dégâts à la vie du personnage
        if (this.life < 0) this.life = 0; // Ne pas avoir de points de vie négatifs
        System.out.println(this.name + " reçoit " + actualDamage + " points de dégâts. Vie actuelle : " + this.life); // Affiche les dégâts reçus
    }

    // Méthode pour restaurer des points de vie
    public void restoreLife(int amount) {
        life += amount; // Augmenter les points de vie
        if (life > maxLife) { // Vérifie si la vie dépasse le maximum
            life = maxLife; // Ne pas dépasser le maximum de points de vie
        }
        System.out.println(name + " restaure " + amount + " points de vie, vie actuelle: " + life); // Affiche les points de vie restaurés
    }

    // Méthode pour obtenir les statistiques du personnage
    public String getStats() {
        return "Nom: " + name + "\n" + // Retourne le nom du personnage
                "Type: " + type + "\n" + // Retourne le type du personnage
                "Points de vie: " + life + "\n" + // Retourne les points de vie
                "Force d'attaque: " + attack; // Retourne la force d'attaque
    }

    // Méthode pour vérifier si le personnage est en vie
    public boolean isAlive() {
        return life > 0; // Renvoie vrai si le personnage a des points de vie
    }

    // Getters et Setters
    public String getName() { return name; } // Renvoie le nom du personnage
    public void setName(String name) { this.name = name; } // Mise à jour du nom du personnage
    public String getType() { return type; } // Renvoie le type du personnage
    public void setType(String type) { this.type = type; } // Mise à jour du type du personnage
    public int getLifePoints() { return life; } // Renvoie les points de vie du personnage
    public int getMaxLife() { return maxLife; } // Renvoie les points de vie maximum du personnage
    public void setLifePoints(int life) { this.life = life; } // Mise à jour des points de vie du personnage
    public int getAttackPower() { return attack; } // Renvoie la puissance d'attaque actuelle
    public void setAttackPower(int attack) { this.attack = attack; } // Mise à jour de la puissance d'attaque
    public AttackWeapon getOffensiveGear() { return battleEquipment; } // Renvoie l'équipement d'attaque
    public void setOffensiveGear(AttackWeapon offensiveGear) { this.battleEquipment = offensiveGear; } // Mise à jour de l'équipement d'attaque
    public DefenseWeapon getDefensiveGear() { return defenseEquipment; } // Renvoie l'équipement de défense
    public void setDefensiveGear(DefenseWeapon defensiveGear) { this.defenseEquipment = defensiveGear; } // Mise à jour de l'équipement de défense

    @Override
    // Méthode pour afficher les informations du personnage
    public String toString() {
        String status = (life <= 0) ? "Mort" : "En vie"; // Vérifie si le personnage est mort ou en vie
        return "Nom: " + name + "\nType: " + type + "\nVie: " + life + "/" + maxLife + " (" + status + ")\nForce d'attaque: " + attack + // Retourne une description complète du personnage
                "\nEquipement Offensif: " + battleEquipment + "\nEquipement Defensif: " + defenseEquipment; // Affiche l'équipement offensif et défensif
    }
}

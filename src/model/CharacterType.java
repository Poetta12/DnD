package model;

// Enumération représentant les différents types de personnages et ennemis
public enum CharacterType {
    // Déclaration des types de personnages avec leurs attributs : id, points de vie et puissance d'attaque
    GUERRIER(1, 10, 10),  // Guerrier : ID = 1, Points de vie = 10, Puissance d'attaque = 10
    MAGICIEN(2, 6, 15),   // Magicien : ID = 2, Points de vie = 6, Puissance d'attaque = 15
    SORCIER(3, 8, 12),    // Sorcier : ID = 3, Points de vie = 8, Puissance d'attaque = 12
    GOBELIN(4, 4, 5),     // Gobelin : ID = 4, Points de vie = 4, Puissance d'attaque = 5
    DRAGON(5, 15, 20);    // Dragon : ID = 5, Points de vie = 15, Puissance d'attaque = 20

    // Attributs privés pour stocker les informations de chaque type de personnage
    private final int id;            // Identifiant unique du type
    private final int lifePoints;    // Points de vie associés au type
    private final int attackPower;   // Puissance d'attaque associée au type

    // Constructeur de l'énumération pour initialiser les attributs
    CharacterType(int id, int lifePoints, int attackPower) {
        this.id = id;                 // Initialisation de l'ID
        this.lifePoints = lifePoints; // Initialisation des points de vie
        this.attackPower = attackPower; // Initialisation de la puissance d'attaque
    }

    // Méthode pour obtenir l'ID du type de personnage
    public int getId() {
        return id; // Retourne l'ID du type
    }

    // Méthode pour obtenir les points de vie du type de personnage
    public int getLifePoints() {
        return lifePoints; // Retourne les points de vie
    }

    // Méthode pour obtenir la puissance d'attaque du type de personnage
    public int getAttackPower() {
        return attackPower; // Retourne la puissance d'attaque
    }
}

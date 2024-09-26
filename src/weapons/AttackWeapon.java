package weapons;

// Classe représentant une arme d'attaque
public class AttackWeapon {
    private String type;  // Type de l'arme (ex : épée, arc)
    private int power;     // Puissance de l'arme
    private String name;   // Nom de l'arme

    // Constructeur pour initialiser les attributs de l'arme
    public AttackWeapon(String type, int power, String name) {
        this.type = type;   // Initialisation du type de l'arme
        this.power = power; // Initialisation de la puissance de l'arme
        this.name = name;   // Initialisation du nom de l'arme
    }

    // Méthode pour obtenir les dégâts
    public int getDamage() {
        return this.power; // Renvoie la puissance de l'arme
    }

    // Méthode pour obtenir le nom
    public String getName() {
        return this.name; // Retourne l'attribut name
    }
}

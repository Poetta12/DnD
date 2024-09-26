package characters;

// Classe représentant un ennemi dans le jeu
public class Enemy {
    private String name; // Nom de l'ennemi
    private int attack; // Puissance d'attaque de l'ennemi
    private int life; // Points de vie de l'ennemi

    // Constructeur pour initialiser l'ennemi avec son nom, sa puissance d'attaque et ses points de vie
    public Enemy(String name, int attack, int life) {
        this.name = name; // Affecter le nom
        this.attack = attack; // Affecter la puissance d'attaque
        this.life = life; // Affecter les points de vie
    }

    // Méthode pour obtenir le nom de l'ennemi
    public String getName() {
        return name; // Retourne le nom de l'ennemi
    }

    // Méthode pour obtenir la puissance d'attaque de l'ennemi
    public int getAttack() {
        return attack; // Retourne la puissance d'attaque
    }

    // Méthode pour obtenir les points de vie de l'ennemi
    public int getLife() {
        return life; // Retourne les points de vie
    }

    // Méthode pour infliger des dégâts à l'ennemi
    public void takeDamage(int damage) {
        life -= damage; // Réduire les points de vie par le montant de dégâts
        if (life < 0) {
            life = 0; // S'assurer que les points de vie ne soient pas négatifs
        }
    }

    // Méthode pour vérifier si l'ennemi est encore en vie
    public boolean isAlive() {
        return life > 0; // Retourne vrai si les points de vie sont supérieurs à 0, sinon faux
    }
}

package game;

import characters.Enemy; // Importation de la classe Enemy pour gérer les ennemis
import characters.Mage; // Importation de la classe Mage pour gérer le personnage Mage
import characters.Warrior; // Importation de la classe Warrior pour gérer le personnage Guerrier
import exceptions.PersonnageHorsPlateauException; // Importation de l'exception personnalisée pour le dépassement de case
import model.Character; // Importation de la classe Character pour représenter les personnages
import model.CharacterFactory; // Importation de la fabrique de personnages pour générer des personnages
import model.CharacterType; // Importation de l'énumération des types de personnages
import weapons.AttackWeapon; // Importation de la classe AttackWeapon pour les armes d'attaque
import weapons.SingleWeapon; // Importation de la classe SingleWeapon pour les armes simples

import java.util.Random; // Importation de la classe Random pour générer des nombres aléatoires
import java.util.Scanner; // Importation de la classe Scanner pour la saisie utilisateur

public class Game {
    private static final int PLATEAU_SIZE = 64; // Taille du plateau de jeu
    private int currentPosition; // Position actuelle du personnage sur le plateau
    private Character character; // Personnage contrôlé par le joueur
    private Enemy currentEnemy; // Ennemi actuel rencontré par le personnage
    private int initialPosition; // Position initiale pour revenir en cas de fuite
    private CharacterType[] enemyTypes = {CharacterType.SORCIER, CharacterType.GOBELIN, CharacterType.DRAGON}; // Types d'ennemis possibles

    // Constructeur de la classe Game qui initialise le jeu avec le type de personnage choisi
    public Game(String characterType) {
        initGame(characterType); // Appel à la méthode pour initialiser le jeu
    }

    // Méthode pour initialiser le personnage et la position
    private void initGame(String characterType) {
        // Vérification du type de personnage et création de l'objet correspondant
        if (characterType.equalsIgnoreCase("guerrier")) {
            this.character = new Warrior("Arthur"); // Création d'un Guerrier nommé Arthur
        } else if (characterType.equalsIgnoreCase("magicien")) {
            this.character = new Mage("Merlin"); // Création d'un Mage nommé Merlin
        } else {
            System.out.println("Choix invalide. Un Guerrier sera créé par défaut."); // Message d'erreur si le type est invalide
            this.character = new Warrior("Arthur"); // Création par défaut d'un Guerrier
        }
        this.currentPosition = 1; // Initialisation de la position actuelle à 1
        this.initialPosition = 1; // Initialisation de la position initiale à 1
    }

    // Méthode pour démarrer le jeu
    public void start() {
        // Boucle jusqu'à ce que le personnage atteigne la case finale
        while (currentPosition < PLATEAU_SIZE) {
            playTurn(); // Appel à la méthode pour jouer un tour
        }
    }

    // Méthode pour gérer un tour de jeu
    private void playTurn() {
        int diceRoll = rollDice(); // Appel à la méthode pour lancer le dé
        updatePosition(diceRoll); // Mise à jour de la position du joueur
        try {
            if (isBeyondBoard()) {
                handleExceedingBoard(); // Gestion du dépassement du plateau
            } else if (currentPosition == PLATEAU_SIZE) {
                endGame(); // Fin du jeu si la case finale est atteinte
            } else {
                handleEvent(); // Gestion de l'événement sur la case actuelle
            }
        } catch (PersonnageHorsPlateauException e) {
            System.out.println(e.getMessage()); // Affichage du message d'exception
            handleEvent(); // Gère les événements même après une exception
        }
    }

    // Méthode pour lancer un dé virtuel
    private int rollDice() {
        Random random = new Random(); // Création d'un objet Random pour générer un nombre aléatoire
        return random.nextInt(6) + 1; // Retourne un nombre entre 1 et 6
    }

    // Méthode pour mettre à jour la position du personnage
    private void updatePosition(int diceRoll) {
        currentPosition += diceRoll; // Mise à jour de la position actuelle
        System.out.println("Tu as roulé un " + diceRoll + ". Tu es maintenant à la case " + currentPosition + " / " + PLATEAU_SIZE); // Affichage du résultat du lancer de dé
    }

    // Méthode pour vérifier si le personnage dépasse le plateau
    private boolean isBeyondBoard() {
        return currentPosition > PLATEAU_SIZE; // Retourne vrai si la position est supérieure à la taille du plateau
    }

    // Méthode pour gérer le dépassement du plateau
    private void handleExceedingBoard() throws PersonnageHorsPlateauException {
        int excess = currentPosition - PLATEAU_SIZE; // Calcul du dépassement
        currentPosition = PLATEAU_SIZE - excess; // Réinitialisation de la position à la limite du plateau
        throw new PersonnageHorsPlateauException("Tu es revenu sur la case " + currentPosition + " après avoir dépassé la case finale !"); // Lance une exception personnalisée
    }

    // Méthode pour gérer les événements sur la case actuelle
    private void handleEvent() {
        Random rand = new Random(); // Création d'un objet Random
        int event = rand.nextInt(3); // Génération d'un nombre aléatoire pour déterminer l'événement (0 à 2)

        // Gestion des événements en fonction de la valeur générée
        switch (event) {
            case 0:
                System.out.println("Case vide, continue ton chemin."); // Cas vide
                break;
            case 1:
                encounterEnemy(); // Rencontre avec un ennemi
                break;
            case 2:
                findSurpriseBox(); // Découverte d'une caisse surprise
                break;
        }
    }

    // Méthode pour gérer la rencontre avec un ennemi
    private void encounterEnemy() {
        //currentEnemy = generateRandomEnemy(); // Cette ligne semble être commentée
        Random rand = new Random(); // Création d'un objet Random
        int enemyIndex = generateRandomEnemy(); // Obtention d'un index aléatoire pour l'ennemi
        System.out.println("Tu as rencontré un " + currentEnemy.getName() + "! Prépare-toi à combattre."); // Annonce de la rencontre
        CharacterFactory.printCharacterArt(enemyTypes[enemyIndex].getId()); // Affiche l'art du personnage en fonction de son ID
        combat(); // Appel à la méthode de combat
    }

    // Méthode pour générer un ennemi aléatoire
    private int generateRandomEnemy() {
        Random rand = new Random(); // Création d'un objet Random
        String[] enemyNames = {"Sorcier", "Gobelin", "Dragon"}; // Noms des ennemis possibles
        int[] enemyAttacks = {2, 1, 4}; // Puissances d'attaque des ennemis
        int[] enemyLives = {9, 6, 15}; // Points de vie des ennemis
        int enemyIndex = rand.nextInt(enemyNames.length); // Génération d'un index aléatoire pour l'ennemi

        // Création de l'ennemi basé sur l'index généré
        currentEnemy = new Enemy(enemyNames[enemyIndex], enemyAttacks[enemyIndex], enemyLives[enemyIndex]);

        return enemyIndex; // Retourne l'index pour l'art
    }

    // Méthode pour gérer le combat
    private void combat() {
        Scanner scanner = new Scanner(System.in); // Création d'un scanner pour la saisie utilisateur
        // Boucle de combat tant que l'ennemi et le personnage sont en vie
        while (currentEnemy.isAlive() && character.getLifePoints() > 0) {
            performCharacterAttack(); // L'attaque du joueur
            if (!currentEnemy.isAlive()) { // Vérifie si l'ennemi est vaincu
                System.out.println("Tu as vaincu " + currentEnemy.getName() + "!"); // Message de victoire
                currentEnemy = null; // Réinitialise l'ennemi
                return; // Quitte la méthode
            }
            performEnemyAttack(); // L'attaque de l'ennemi
            if (character.getLifePoints() <= 0) { // Vérifie si le personnage est vaincu
                System.out.println("Tu as été vaincu par " + currentEnemy.getName() + "..."); // Message de défaite
                return; // Quitte la méthode
            }
            if (!continueCombat(scanner)) { // Demande au joueur s'il veut continuer le combat
                return; // Quitte la méthode
            }
        }
    }

    // Méthode pour gérer l'attaque du personnage
    private void performCharacterAttack() {
        // Calcule les dégâts infligés par le personnage
        int playerDamage = character.getAttackPower() +
                (character.getOffensiveGear() != null ? character.getOffensiveGear().getDamage() : 0); // Inclut les dégâts de l'équipement offensif si présent
        currentEnemy.takeDamage(playerDamage); // Inflige les dégâts au monstre actuel
        // Affiche le montant de dégâts infligés et la vie restante de l'ennemi
        System.out.println("Tu infliges " + playerDamage + " points de dégâts à " + currentEnemy.getName() +
                ". Vie restante de l'ennemi : " + currentEnemy.getLife());
    }

    // Méthode pour gérer l'attaque de l'ennemi
    private void performEnemyAttack() {
        int enemyDamage = currentEnemy.getAttack(); // Obtention des dégâts de l'ennemi
        int damageTaken = Math.max(0, enemyDamage - character.getDefense()); // Calcul des dégâts subis après avoir soustrait la défense du personnage
        character.setLifePoints(character.getLifePoints() - damageTaken); // Mise à jour des points de vie du personnage
        System.out.println(currentEnemy.getName() + " t'inflige " + damageTaken + " points de dégâts."); // Affichage des dégâts subis
        System.out.println("Vie actuelle : " + character.getLifePoints()); // Affichage des points de vie restants
    }

    // Méthode pour demander au joueur s'il veut continuer le combat
    private boolean continueCombat(Scanner scanner) {
        System.out.println("Veux-tu continuer le combat ? (oui/non)"); // Demande à l'utilisateur
        String response = scanner.nextLine().trim().toLowerCase(); // Lecture de la réponse
        return response.equals("oui"); // Retourne vrai si le joueur veut continuer
    }

    // Méthode pour gérer la découverte d'une caisse surprise
    private void findSurpriseBox() {
        System.out.println("Tu as trouvé une caisse surprise !"); // Message indiquant la découverte
        // Logique pour la surprise peut être ajoutée ici
    }

    // Méthode pour gérer la fin du jeu
    private void endGame() {
        System.out.println("Félicitations ! Tu as atteint la case finale et gagné le jeu !"); // Message de victoire
        currentPosition = 1; // Réinitialise la position pour un nouveau jeu
        System.out.println("Tu peux redémarrer le jeu."); // Message indiquant que le jeu peut redémarrer
    }
}


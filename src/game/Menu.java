package game;

import model.Character;
import model.CharacterFactory;

import java.util.Scanner; // Importation de la classe Scanner pour lire l'entrée utilisateur

public class Menu {
    private model.Character character; // Déclaration d'une variable pour stocker le personnage
    private Scanner scanner; // Déclaration d'une variable pour le scanner

    // Constructeur de la classe Menu qui initialise le scanner
    public Menu(Scanner scanner) {
        this.scanner = scanner; // Assignation de l'instance scanner à la variable locale
    }

    // Méthode pour afficher le menu et gérer les choix de l'utilisateur
    public void show() {
        while (true) { // Boucle infinie pour afficher le menu en continu
            // Affichage d'un message de bienvenue avec un design ASCII
            System.out.println("                .\n" +
                    "           .    |    .\n" +
                    "            \\   |   /\n" +
                    "        '.   \\  '  /   .'\n" +
                    "          '. .'```'. .'\n" +
                    "<>...:::::::`.......`:::::::..<>\n" +
                    "<>:         Bienvenue        :<>\n" +
                    "<>:           CHEZ           :<>\n" +
                    "<>:    DUNGEONS & DRAGONS    :<>\n" +
                    "<>:..........................:<>\n" +
                    "<><><><><><><><><><><><><><><><>");

            // Affiche le menu et récupère le choix de l'utilisateur
            displayMenuOptions();  // Appel à la méthode pour afficher les options du menu
            int choice = scanner.nextInt(); // Lecture du choix de l'utilisateur
            scanner.nextLine(); // Consomme la nouvelle ligne

            handleMenuChoice(choice);  // Appel à la méthode qui gère le choix de l'utilisateur
        }
    }

    // Méthode pour afficher les options du menu
    private void displayMenuOptions() {
        System.out.println("Menu:"); // Affichage du titre du menu
        System.out.println("1: Faire naître un nouveau personnage"); // Option 1
        System.out.println("2: Commencer la partie"); // Option 2
        System.out.println("3: Quitter le jeu"); // Option 3
        System.out.println(); // Ligne vide pour la lisibilité
        System.out.print("Choisis une option (1 à 3): "); // Invitation à choisir une option
    }

    // Méthode pour gérer le choix de l'utilisateur
    private void handleMenuChoice(int choice) {
        switch (choice) { // Switch sur le choix de l'utilisateur
            case 1: createCharacter(scanner); break; // Si choix 1, appelle la méthode pour créer un personnage
            case 2: startGame(); break; // Si choix 2, appelle la méthode pour commencer le jeu
            case 3: // Si choix 3, quitte le jeu
                System.out.println("Tu décides. À bientôt !"); // Message d'au revoir
                System.exit(0);  // Sort du programme
            default: // Si le choix n'est pas valide
                System.out.println("Option invalide. Réessaye."); // Message d'erreur
        }
    }

    // Méthode pour commencer le jeu
    public void startGame() {
        if (character == null) { // Vérifie si le personnage est null (non créé)
            System.out.println();
            System.out.println("*=*=*=* Tu dois d'abord créer un personnage. *=*=*=*"); // Message d'erreur
            System.out.println();
        } else { // Si le personnage existe
            Game game = new Game(character.getType()); // Création d'une nouvelle instance de jeu avec le type de personnage
            game.start(); // Démarrage du jeu
        }
    }

    // Méthode pour créer un personnage
    public void createCharacter(Scanner scanner) {
        String name; // Déclaration d'une variable pour le nom
        int typeNb; // Déclaration d'une variable pour le type

        typeNb = chooseCharacterType(); // Appel à la méthode pour choisir le type de personnage
        name = askCharacterName(); // Appel à la méthode pour demander le nom du personnage

        // Création du personnage avec le factory
        character = CharacterFactory.createCharacter(name, typeNb, false);

        System.out.println("Caractéristiques du personnage créé :"); // Message d'information
        System.out.println();
        System.out.println(character.getStats()); // Affichage des caractéristiques du personnage

        manageCharacterInfo(character, scanner); // Appel à la méthode pour gérer les informations du personnage
    }

    // Méthode pour choisir le type de personnage
    private int chooseCharacterType() {
        int typeNb; // Déclaration d'une variable pour le type
        do {
            System.out.println();
            System.out.println("Quel personnage veux-tu créer ? "); // Demande de choix
            System.out.println("1: guerrier"); // Demande de choix
            System.out.println("2: magicien"); // Demande de choix
            typeNb = scanner.nextInt(); // Lecture du choix
            scanner.nextLine(); // Consomme la nouvelle ligne
        } while (typeNb < 1 || typeNb > 2); // Répète jusqu'à obtenir un choix valide
        return typeNb; // Retourne le type choisi
    }

    // Méthode pour demander le nom du personnage
    private String askCharacterName() {
        String name; // Déclaration d'une variable pour le nom
        do {
            System.out.print("Quel est le nom de ton personnage : "); // Demande du nom
            name = scanner.nextLine(); // Lecture du nom
        } while (name.isEmpty() || !name.matches("[a-zA-Z]+")); // Répète jusqu'à obtenir un nom valide
        return name; // Retourne le nom choisi
    }

    // Méthode pour changer les options du personnage
    private void changeCharacterOptions(model.Character character) {
        while (true) { // Boucle infinie pour gérer les modifications
            System.out.println("Que veux-tu modifier ? (1: Nom, 2: Type, 3: Vie, 4: Force d'attaque, 5: Quitter)"); // Options de modification
            int choice = scanner.nextInt(); // Lecture du choix
            scanner.nextLine(); // Consomme la nouvelle ligne

            handleChangeCharacterOption(choice, character); // Appel à la méthode pour gérer la modification choisie

            System.out.println("Informations mises à jour :\n" + character.toString()); // Affichage des informations mises à jour
        }
    }

    // Méthode pour gérer l'option de modification choisie
    private void handleChangeCharacterOption(int choice, model.Character character) {
        switch (choice) { // Switch sur le choix
            case 1: // Modifier le nom
                System.out.print("Ton nouveau nom : "); // Demande du nouveau nom
                String newName = scanner.nextLine(); // Lecture du nouveau nom
                character.setName(newName); // Mise à jour du nom du personnage
                break;
            case 2: // Modifier le type
                System.out.print("Ton nouveau type (1: guerrier, 2: magicien) : "); // Demande du nouveau type
                int newType = scanner.nextInt(); // Lecture du nouveau type
                scanner.nextLine(); // Consomme la nouvelle ligne
                character = CharacterFactory.createCharacter(character.getName(), newType, false); // Création d'un nouveau personnage avec le nouveau type
                break;
            case 3: // Modifier les points de vie
                System.out.print("Ton nouveau niveau de vie : "); // Demande des nouveaux points de vie
                int newLife = scanner.nextInt(); // Lecture des nouveaux points de vie
                character.setLifePoints(newLife); // Mise à jour des points de vie
                break;
            case 4: // Modifier la force d'attaque
                System.out.print("Ta nouvelle force d'attaque : "); // Demande de la nouvelle force d'attaque
                int newAttack = scanner.nextInt(); // Lecture de la nouvelle force d'attaque
                character.setAttackPower(newAttack); // Mise à jour de la force d'attaque
                break;
            case 5: // Quitter les options de modification
                System.out.println("Revenir au menu principal..."); // Message d'information
                return; // Retourne au menu principal
            default: // Si le choix n'est pas valide
                System.out.println("Mauvaise option. Réessaie."); // Message d'erreur
        }
    }

    // Méthode pour gérer l'affichage et la modification des informations du personnage
    private void manageCharacterInfo(Character character, Scanner scanner) {
        while (true) { // Boucle infinie pour gérer les informations
            System.out.println("Veux-tu afficher/modifier les infos de ton personnage ? (1: Afficher, 2: Modifier, 3: Quitter)"); // Options
            System.out.println("1: Afficher"); // Option pour afficher
            System.out.println("2: Modifier"); // Option pour modifier
            System.out.println("3: Quitter"); // Option pour quitter
            int infoChoice = scanner.nextInt(); // Lecture du choix
            scanner.nextLine(); // Consomme la nouvelle ligne

            if (infoChoice == 1) { // Si l'utilisateur choisit d'afficher
                System.out.println(character.toString()); // Affiche les informations du personnage
            } else if (infoChoice == 2) { // Si l'utilisateur choisit de modifier
                changeCharacterOptions(character); // Appel à la méthode pour changer les options
            } else if (infoChoice == 3) { // Si l'utilisateur choisit de quitter
                System.out.println("Tu retournes au menu principal."); // Message d'information
                return; // Retourne au menu principal
            } else { // Si le choix n'est pas valide
                System.out.println("Mauvaise option. Réessaie."); // Message d'erreur
            }
        }
    }
}

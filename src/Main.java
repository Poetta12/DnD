import game.Menu;

import java.util.Scanner; // Importation de la classe Scanner pour lire l'entrée de l'utilisateur

// Déclaration de la classe Main qui contient le point d'entrée de l'application
public class Main {
    // Méthode principale qui est le point d'entrée de l'application
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Création d'un nouvel objet Scanner pour lire l'entrée de l'utilisateur
        Menu menu = new Menu(scanner); // Passer le scanner au Menu pour qu'il puisse lire les entrées utilisateur
        menu.show(); // Affiche le menu principal
        scanner.close(); // Ferme le scanner pour libérer les ressources
    }
}

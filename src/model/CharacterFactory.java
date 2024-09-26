package model;

public class CharacterFactory {

    // Méthode statique pour créer un personnage ou un ennemi
    public static model.Character createCharacter(String name, int type, boolean isEnemy) {
        model.Character character = null; // Initialiser le personnage

        // Vérifie si le personnage à créer est un ennemi
        if (isEnemy) {
            character = createEnemy(name, type); // Créer un ennemi
        } else {
            character = createPlayer(name, type); // Créer un joueur
        }

        return character; // Retourner le personnage ou l'ennemi créé
    }

    // Méthode privée pour créer un personnage joueur selon son type
    private static model.Character createPlayer(String name, int type) {
        switch (CharacterType.values()[type - 1]) { // Sélectionner le type de personnage
            case GUERRIER: // Si le type est guerrier
                return createCharacterInstance(name, CharacterType.GUERRIER); // Créer un guerrier
            case MAGICIEN: // Si le type est magicien
                return createCharacterInstance(name, CharacterType.MAGICIEN); // Créer un magicien
            default:
                System.out.println("Type de personnage inconnu."); // Gérer un type inconnu
                return null; // Retourner null
        }
    }

    // Méthode privée pour créer un ennemi selon son type
    private static model.Character createEnemy(String name, int type) {
        switch (CharacterType.values()[type - 1]) { // Sélectionner le type d'ennemi
            case SORCIER: // Si le type est sorcier
                return createCharacterInstance(name, CharacterType.SORCIER); // Créer un sorcier
            case GOBELIN: // Si le type est gobelin
                return createCharacterInstance(name, CharacterType.GOBELIN); // Créer un gobelin
            case DRAGON: // Si le type est dragon
                return createCharacterInstance(name, CharacterType.DRAGON); // Créer un dragon
            default:
                System.out.println("Type d'ennemi inconnu."); // Gérer un type inconnu
                return null; // Retourner null
        }
    }

    // Méthode privée pour créer une instance de personnage
    private static model.Character createCharacterInstance(String name, CharacterType type) {
        model.Character character = new Character(name, type.name().toLowerCase()); // Créer un personnage avec le nom et le type
        character.setLifePoints(type.getLifePoints()); // Définir les points de vie
        character.setAttackPower(type.getAttackPower()); // Définir la puissance d'attaque
        printCharacterArt(type.getId()); // Afficher l'art ASCII correspondant au personnage
        return character; // Retourner le personnage créé
    }

    // Méthode privée pour afficher l'art ASCII en fonction du type de personnage
    public static void printCharacterArt(int type) {
        switch (type) { // Sélectionner le type pour afficher l'art ASCII
            case 1: // Art ASCII pour le guerrier
                System.out.println("             /\\  \n" +
                        "            /__\\ \n" +
                        "           |    |\n" +
                        "           |____|\n" +
                        "           |    |\n" +
                        "           |____|\n" +
                        "           |    |\n" +
                        "          _|____|_\n" +
                        "         |________|\n"+
                        "<>...:::::::`.......`:::::::..<>\n" +
                        "<>:         Guerrier         :<>\n" +
                        "<>:..........................:<>\n" +
                        "<><><><><><><><><><><><><><><><>");
                break;
            case 2: // Art ASCII pour le magicien
                System.out.println("                .\n" +
                        "               /|\\\n" +
                        "              /_|_\\\n" +
                        "             .-'|'-.\n" +
                        "            /   |   \\\n" +
                        "           /    |    \\\n" +
                        "          |     |     |\n" +
                        "          |  _  |  _  |\n" +
                        "          | (_) | (_) |\n" +
                        "           \\    |    /\n" +
                        "            \\   |   /\n" +
                        "             '._|_.'\n" +
                        "<>...:::::::`.......`:::::::..<>\n" +
                        "<>:         Magicien         :<>\n" +
                        "<>:..........................:<>\n" +
                        "<><><><><><><><><><><><><><><><>");
                break;
            case 3: // Art ASCII pour le sorcier
                System.out.println("               .--.\n" +
                        "              |o_o |\n" +
                        "              |:_/ |\n" +
                        "             //   \\ \\\n" +
                        "            (|     | )\n" +
                        "           /'\\_   _/`\\\n" +
                        "           \\___)=(___/\n"+
                        "<>...:::::::`.......`:::::::..<>\n" +
                        "<>:         Sorcier         :<>\n" +
                        "<>:..........................:<>\n" +
                        "<><><><><><><><><><><><><><><><>");
                break;
            case 4: // Art ASCII pour le gobelin
                System.out.println("         .--.\n" +
                        "        |o_o |\n" +
                        "        |:_/ |\n" +
                        "       //   \\ \\\n" +
                        "      (|     | )\n" +
                        "     /'\\_   _/`\\\n" +
                        "     \\___)=(___/\n"+
                        "<>...:::::::`.......`:::::::..<>\n" +
                        "<>:         Gobelin         :<>\n" +
                        "<>:..........................:<>\n" +
                        "<><><><><><><><><><><><><><><><>");
                break;
            case 5: // Art ASCII pour le dragon
                System.out.println("             __====-_  _-====__\n" +
                        "        _--^^^#####//      \\#####^^^--_\n" +
                        "     _-^##########// (    ) \\##########^-_\n" +
                        "    -############//  |\\^^/|  \\############-\n" +
                        "   -############//   (@::@)   \\############-\n" +
                        "  -#############((      \\//      ))#############-\n" +
                        " -###############\\     (oo)     //###############-\n" +
                        "-#################\\    / \"\" \\    /#################-\n" +
                        "-###################\\  /     \\  /###################-\n" +
                        " -###################\\/       \\/###################-\n" +
                        "  -###################\\       /###################-\n" +
                        "   -###################\\     /###################-\n" +
                        "    -###################\\   /###################-\n" +
                        "     -###################\\ /###################-\n" +
                        "      -###################\\###################-\n"+
                        "            <>...:::::::`.......`:::::::..<>\n" +
                        "            <>:         Dragon         :<>\n" +
                        "            <>:..........................:<>\n" +
                        "            <><><><><><><><><><><><><><><><>");
                break;
        }
    }
}

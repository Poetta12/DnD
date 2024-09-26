package exceptions;

// Exception personnalisée pour gérer les personnages qui dépassent la case finale du plateau
public class PersonnageHorsPlateauException extends Exception {

    // Constructeur prenant un message d'erreur en paramètre
    public PersonnageHorsPlateauException(String message) {
        super(message); // Appelle le constructeur de la classe parent Exception avec le message
    }
}

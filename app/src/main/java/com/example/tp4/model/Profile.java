package com.example.tp4.model;

public class Profile {

    private int valeurAchercher;
    private int valeurSaisie;
    private String response;
    public Profile(int valeurSaisie, int valeurAchercher)
    {
        this.valeurAchercher = valeurAchercher;
        this.valeurSaisie = valeurSaisie;
    }
    public String getResponse()
    {
        if (valeurSaisie==valeurAchercher)
            response = "Bravo! Vous avez trouvé la valeur";
        if (valeurSaisie<valeurAchercher)
            response = "Veuillez saisir une valeur plus grande";
        if (valeurSaisie>valeurAchercher)
            response = "Veuillez saisir une valeur plus petite";
        return response;
    }


}

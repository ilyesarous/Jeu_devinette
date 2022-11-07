package com.example.tp4.controler;

import com.example.tp4.model.Profile;

public final class Controler {
        private static Controler instance = null;
        private static Profile profil;
        Controler(){
            super();
        }
        public static Controler getInstance()
        {
            if(Controler.instance == null)
                Controler.instance = new Controler();
            return (Controler.instance);
        }
        public void createProfil (int valeurSaisie, int valeurAchercher)
        {
            profil = new Profile(valeurSaisie,valeurAchercher);
        }
        public String getResponse() {
            return profil.getResponse();
        }

}

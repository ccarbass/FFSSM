package FFSSM;

import java.time.LocalDate;

public class Plongeur extends Personne {
    private int niveau;

    public Plongeur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance,int niveau){
        super(numeroINSEE,nom, prenom, adresse, telephone, naissance);
        this.niveau=niveau;
    }

}

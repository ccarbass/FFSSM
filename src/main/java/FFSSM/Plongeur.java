package FFSSM;

import java.time.LocalDate;

public class Plongeur extends Personne {
    private int niveau;
    private GroupeSanguin groupeSanguin;

    public Plongeur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance,int niveau, GroupeSanguin groupeSanguin){
        super(numeroINSEE,nom, prenom, adresse, telephone, naissance);
        this.niveau=niveau;
        this.groupeSanguin=groupeSanguin;
    }

}

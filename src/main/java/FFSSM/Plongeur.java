package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Plongeur extends Personne {
    private int niveau;
    private GroupeSanguin groupeSanguin;

    public List<Licence> licences = new ArrayList<>();

    public Plongeur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance,int niveau, GroupeSanguin groupeSanguin){
        super(numeroINSEE,nom, prenom, adresse, telephone, naissance);
        this.niveau=niveau;
        this.groupeSanguin=groupeSanguin;
    }
    public void ajouteLicence(String numero, LocalDate delivrance, Club club) {

        for (Licence l : licences) {

            if (l.estValide(LocalDate.now())) {
                l.setValid(false);
            }

        }

        licences.add(new Licence(this, numero, delivrance, niveau, club));
    }

    public Licence getLicence() {

        return licences.get(licences.size() - 1);

    }
}

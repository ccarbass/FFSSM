/**
 * @(#) Moniteur.java
 */
package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Moniteur extends Plongeur  {

    public int numeroDiplome;
    ArrayList<Embauche> jobs = new ArrayList<>();

    public Moniteur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance,int niveau,GroupeSanguin groupeSanguin ,int numeroDiplome) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance, niveau, groupeSanguin);
        this.numeroDiplome = numeroDiplome;
    }

    /**
     * Si ce moniteur n'a pas d'embauche, ou si sa dernière embauche est terminée,
     * ce moniteur n'a pas d'employeur.
     * @return l'employeur actuel de ce moniteur sous la forme d'un Optional
     */
    public Optional<Club> employeurActuel() throws Exception{
        if(jobs.isEmpty())
            throw new Exception("Aucun emploi");
        return Optional.ofNullable(jobs.get(jobs.size()-1).getEmployeur());

    }
    
    /**
     * Enregistrer une nouvelle embauche pour cet employeur
     * @param employeur le club employeur
     * @param debutNouvelle la date de début de l'embauche
     */
    public void nouvelleEmbauche(Club employeur, LocalDate debutNouvelle) {
        Embauche embauche = new Embauche(LocalDate.now(), this, employeur);
        jobs.add(embauche);
    }

    public List<Embauche> emplois() {
        return jobs;
    }

}

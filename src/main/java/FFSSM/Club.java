/**
 * @(#) Club.java
 */
package FFSSM;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Club {


    public Moniteur president;

    public String nom;

    public String adresse;

    public String telephone;

    ArrayList<Plongee> plongees = new ArrayList<>();

    public Club(Moniteur président, String nom, String telephone) {
        this.president = président;
        this.nom = nom;
        this.telephone = telephone;
    }

    /**
     * Calcule l'ensemble des plongées non conformes organisées par ce club.
     * Une plongée est conforme si tous les plongeurs de la palanquée ont une licence
     * valide à la date de la plongée
     *
     * @return l'ensemble des plongées non conformes
     */
    public Set<Plongee> plongeesNonConformes() {
        Set<Plongee> plongee_conformes = new HashSet<>();

        for (Plongee p : plongees) {

            if (!p.estConforme()) {
                plongee_conformes.add(p);
            }

        }

        return plongee_conformes;
    }


    /**
     * Enregistre une nouvelle plongée organisée par ce club
     *
     * @param p la nouvelle plongée
     */
    public void organisePlongee(Plongee p) {
        if (!plongees.contains(p)){
            plongees.add(p);
        }

    }


    public Moniteur getPresident() {
        return president;
    }

    public void setPresident(Moniteur président) {
        this.president = président;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Club{" + "président: " + president + ", nom: " + nom + ", adresse: " + adresse + ", telephone: " + telephone + '}';
    }

}

/**
 * @(#) LicencePlongeur.java
 */
package FFSSM;

import java.time.LocalDate;

public class Licence {

    public Personne possesseur;

    public String numero;

    public LocalDate delivrance;

    public int niveau;

    public Club club;

    public boolean valide;

    public Licence(Personne possesseur, String numero, LocalDate delivrance, int niveau, Club club) {
        this.possesseur = possesseur;
        this.numero = numero;
        this.delivrance = delivrance;
        this.niveau = niveau;
        this.club = club;
    }

     /**
     * Est-ce que la licence est valide à la date indiquée ?
     * Une licence est valide pendant un an à compter de sa date de délivrance
     * @param d la date à tester
     * @return vrai si valide à la date d
     **/
    public boolean estValide(LocalDate d) {
        LocalDate delivranceplus1= this.delivrance.plusYears(1);
        if(d.isBefore(delivranceplus1) ){
            return true;
         }
         else{
             return false;
         }
    }

    public void setValid(boolean b) {
        valide=b;
    }
}

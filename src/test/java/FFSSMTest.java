import FFSSM.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.time.LocalDate;
import java.util.Optional;

public class FFSSMTest {
    Plongeur P1,P2;
    Moniteur M1,M2;
    Club C1,C2;
    Embauche E1,E2;
    Licence L1, L2,L3;
    Plongee PL1, PL2;
    Site S1, S2;
    LocalDate D1, D2, D3, D4, D5;


     @BeforeEach
    public void setUp(){
         D1= LocalDate.of(1999,4,12);
         D2= LocalDate.of(1968,3,10);
         D3= LocalDate.of(2020,6,2);
         D4= LocalDate.of(1989,8,20);
         D5= LocalDate.of(2019,5,20);

         P1 = new Plongeur("123","dupont","jean","Rue du surf","0987654332",D1,4,GroupeSanguin.APLUS);
         P1.ajouteLicence("1",D5,C1);

         P2 = new Plongeur("123","dupont","Marie","Rue du surf","0987643332",D2,4,GroupeSanguin.APLUS);
         P2.ajouteLicence("1",D3,C1);

         M1 = new Moniteur("12","tructruc","francine","Rue du paddle","0997654332",D2,6,GroupeSanguin.BPLUS,2390);
         M1.ajouteLicence("2",D3,C1);
         M2 = new Moniteur("143","xu","win","Rue du skate","0909654332",D4,6,GroupeSanguin.BMOINS,24);
         M2.ajouteLicence("3",D3,C2);

         C1 = new Club(M1,"PEPOUZE","059688734");
         C2 = new Club(M2,"PEPOUZE","059688734");

         L1= new Licence(P1,"1",D5,4,C1);
         L2= new Licence(M1,"2",D3,6,C1);
         L3= new Licence(M2,"3",D3,6,C2);

         E1= new Embauche(D3,M1,C1);
         E2= new Embauche(D5,M2,C2);

         PL1= new Plongee(S1,M1,D3,100,300);
         PL2= new Plongee(S2,M2,D3,400,300);

         S1 = new Site("Goerge du lac","peu profonde");
         S2 = new Site("Gouffre du paradis","Très profonde avec une eau magnifique et des fonds superbes");

     }

    //Test class Club
    @Test
    public void PlongeeNonConforme(){
         //ajout de participants
         PL1.ajouteParticipant(P1);
         PL2.ajouteParticipant(P2);
         //Attribution au club
         C1.organisePlongee(PL1);
         C1.organisePlongee(PL2);

         assertTrue(C1.plongeesNonConformes().contains(PL1) && !C1.plongeesNonConformes().contains(PL2));
    }

    @Test
    public void VerficiationAjoutPlongee(){
        //ajout de participants
        PL1.ajouteParticipant(P1);
        //Attribution au club
        C1.organisePlongee(PL1);
        assertTrue(C1.getPlongees().contains(PL1));

    }
    //Test class Embauche

    @Test
    public void verificationFin(){
         M1.nouvelleEmbauche(C1,D5);
            M1.emplois().get(M1.emplois().size() - 1).terminer(LocalDate.now());

        //Vérification que l'emploi est bien fini
        assertTrue(M1.emplois().get(M1.emplois().size() - 1).estTerminee());
    }
    @Test
    public void estTerminer(){
         assertTrue(M1.emplois().isEmpty());
        M1.nouvelleEmbauche(C1, LocalDate.now());
        assertTrue(!M1.emplois().isEmpty());
    }


    @Test
    public void VerificationEmployeur(){
        M1.nouvelleEmbauche(C1,D5);
        //Supposition d'un employeur
        Optional<Club> employeur = Optional.of(M1.emplois().get(M1.emplois().size() - 1).getEmployeur());

        //Les deux employeurs sont égaux
        assertEquals(Optional.ofNullable(M1.emplois().get(M1.emplois().size() - 1).getEmployeur()), employeur);
    }


    //Test class Licence
    @Test
    public void VerificationValideLicence(){
        assertTrue(P1.licences.get(0).estValide(D5.plusMonths(11)));
        assertFalse(P1.licences.get(0).estValide(D5.plusMonths(12)));
    }
    //Test class Moniteur
    @Test
    public void VerificationEmployeurActuel() throws Exception {
         M2.nouvelleEmbauche(C2,D5);
        assertEquals(C2, M2.employeurActuel().get(), "Pas le même employeur");
    }
    //Test class Plongee
    //Test class Plongeur


}

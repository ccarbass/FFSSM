import FFSSM.*;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;

public class FFSSMTest {
    Plongeur P1;
    Moniteur M1,M2;
    Club C1,C2;
    Embauche E1,E2;
    Licence L1, L2,L3;
    Plongee PL1, PL2;
    Site S1, S2;
    LocalDate D1, D2, D3, D4;


     @BeforeEach
    public void setUp(){
         D1= LocalDate.of(1999,04,12);
         D2= LocalDate.of(1968,03,10);
         D3= LocalDate.of(2020,06,02);
         D4= LocalDate.of(1989,8,20);

         P1 = new Plongeur("123","dupont","jean","Rue du surf","0987654332",D1,4,GroupeSanguin.APLUS);
         M1 = new Moniteur("12","tructruc","francine","Rue du paddle","0997654332",D2,6,GroupeSanguin.BPLUS,2390);
         M2 = new Moniteur("143","xu","win","Rue du skate","0909654332",D4,6,GroupeSanguin.BMOINS,24);
         C1 = new Club(M1,"PEPOUZE","059688734");
         C2 = new Club(M2,"PEPOUZE","059688734");
         L1= new Licence(P1,"1",D3,4,C1);
         L2= new Licence(M1,"2",D3,6,C1);
         L3= new Licence(M2,"3",D3,6,C2);






     }


}

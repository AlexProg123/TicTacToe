
import java.util.Scanner;

public class Main {
    //TicTacToeGame!!!
    //FIKSOVANI ZMINNI
    public static final String POROZHNYA = "   ", KHRESTYK = " X ",NULYK = " O ";
public static String aktyvnyjGravets;
    //IGROVE POLE

    public static final int RYADKIV = 3,STOVPCHYKIV = 3;
    public static String [][] sitka = new String[RYADKIV][STOVPCHYKIV];
    public static int statusGry;
    public static final int STATUS_GRA_TRYVAYE = 0,STATUS_NICHYJA = 1,STATUS_PEREMOGA_X= 3,STATUS_PEREMOGA_O= 4;
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
PochatyGru();
do {
OtrymatyVedennyaGravtsya();
ProanalizuvatySitku();
VyvestySitku();
if (statusGry ==STATUS_PEREMOGA_X){
    System.out.println("X Peremig!");
} else if (statusGry == STATUS_PEREMOGA_O) {
    System.out.println("O Peremig !");

} else if (statusGry == STATUS_NICHYJA) {
    System.out.println("Nichyja!!");
}
aktyvnyjGravets = (aktyvnyjGravets== KHRESTYK?NULYK:KHRESTYK);
}while (statusGry == STATUS_GRA_TRYVAYE);



    }
    public static void PochatyGru(){
for (int ryad = 0;ryad<RYADKIV;ryad++){
    for (int stovp = 0;stovp<STOVPCHYKIV;stovp++){
        sitka[ryad][stovp] = POROZHNYA;
    }
}
aktyvnyjGravets = KHRESTYK;
VyvestySitku();
    }
    public static void OtrymatyVedennyaGravtsya(){
        boolean vedennyaDijsne = false;
do {
    System.out.println("Gravets " + aktyvnyjGravets + " Vvedit nomer ryadka (1-3) i stovpchyka (1-3) cherez probil  ");
    int ryad = in.nextInt()-1;int stovp = in.nextInt() - 1;
    if (ryad>=0 && ryad<RYADKIV && stovp >=0 && stovp<STOVPCHYKIV && sitka[ryad][stovp ]==POROZHNYA){
        sitka[ryad][stovp] = aktyvnyjGravets;
        vedennyaDijsne = true;
    }else  {
        System.out.println("Vybrane rozmischennya (" + (ryad + 1) + "," + (stovp + 1)
                + ") ne mozhe buty vykorystane. Sprobui sche raz...");
    }
}
while (!vedennyaDijsne);
    }
    public static void ProanalizuvatySitku(){
String peremozhets = ZnajtyPeremozhtsya();
if (peremozhets.equals(KHRESTYK)){
    statusGry = STATUS_PEREMOGA_X;
}else if (peremozhets.equals(NULYK)){
statusGry = STATUS_PEREMOGA_O;
} else if (ChyVsiKlitynkyZapovneny()) {
statusGry = STATUS_NICHYJA;

}else {
    statusGry = STATUS_GRA_TRYVAYE;
}

    }

    public static boolean ChyVsiKlitynkyZapovneny(){
for (int ryad = 0;ryad<RYADKIV;ryad++){
    for (int stovp = 0;stovp<STOVPCHYKIV;stovp++){
        if (sitka[ryad][stovp] == POROZHNYA){
            return false;
        }
    }
}
return true;
    }
    public static String ZnajtyPeremozhtsya(){
int iKilkistOdnakovych;
for (int ryad = 0;ryad <RYADKIV;ryad++){
     iKilkistOdnakovych = 0;
    for (int stovp = 0;stovp<STOVPCHYKIV;stovp++){
        if (sitka[ryad][0]!=POROZHNYA && sitka[ryad][0] == sitka[ryad][stovp]){
iKilkistOdnakovych++;
        }
    }
    if (iKilkistOdnakovych==3){
        return sitka[ryad][0];
    }
}
        for (int stovp = 0; stovp < STOVPCHYKIV; stovp++) {
            iKilkistOdnakovych = 0;
            for (int ryad = 0; ryad < RYADKIV; ryad++) {
                if (sitka[0][stovp] != POROZHNYA && sitka[0][stovp] == sitka[ryad][stovp]) {
                    iKilkistOdnakovych++;
                }
            }
            if (iKilkistOdnakovych == 3) {
                return sitka[0][stovp];
            }
        }
        if (sitka[0][0]!=POROZHNYA && sitka [0][0]==sitka[1][1]&&sitka[0][0]==sitka[2][2]){
            return sitka[0][0];
        }
        if (sitka[0][2]!=POROZHNYA && sitka[0][2]==sitka[1][1]&& sitka[0][2] == sitka[2][0]){
            return sitka[0][2];
        }
        return POROZHNYA;
    }
    public static void VyvestySitku(){
        for (int ryad = 0;ryad<RYADKIV;ryad++){
            for (int stovp = 0;stovp<STOVPCHYKIV;stovp++){
                System.out.print(sitka[ryad][stovp]);
                if (stovp!=STOVPCHYKIV-1){
                    System.out.print("|");
                }
            }
            System.out.println();
            if (ryad!=RYADKIV-1){
                System.out.println("-----------");
            }
        }
        System.out.println();

    }

}
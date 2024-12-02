import java.util.ArrayList;

public class Træner {

    private ArrayList<Medlem> medlemsListe;

    public Træner(){

    }





    //___________________________metode til at udtage konkurrence svømmerne fra medlemsfilen____________________________
    public String konkurrenceUdtagning() {
        String udskriv = " ";
        int tæller = 1;
        for (Medlem medlem : medlemsListe) {
            if (medlem.getAktivitetsForm() == "konkurrence" && medlem.getMedlemsstatus() == MedlemsStatus.AKTIV ) {
                udskriv += tæller++ + ". " + medlem.getNavn() + ", " + medlem.getCpr() + "(" + medlem.cprOmregningTilAlder() +
                        " år), " + medlem.getMedlemsstatus() + ", " + medlem.getSvømmedisciplin() + ", " + medlem.getBedsteTid();
            }
        }
        return udskriv.isEmpty() ? "ingen medlemmer i restnace" : udskriv;
    }

}

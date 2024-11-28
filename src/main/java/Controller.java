import java.util.ArrayList;

public class Controller {
    private Formand formand;
    private Kasserer kasserer;


    //________________________konstruktør_______________________________________________________________________________
    public Controller() {
        formand = new Formand();
        kasserer = new Kasserer();

    }


    //_______________________metode til at oprette medlem_______________________________________________________________
    public void opretMedlem(String navn, String cpr, MedlemsStatus status, String aktivitetsForm, boolean harBetalt) {
        formand.tilføjMedlem(navn, cpr, status, aktivitetsForm, harBetalt);
    }


    //_______________________metode til at slette medlem________________________________________________________________
    public void sletMedlem(String cpr) {
        formand.sletMedlem(cpr);
    }


    //_______________________metode til at redigerer i medlemmets oplysninger___________________________________________
    public void redigerMedlem(Medlem medlem, int valg, String newValue){
        formand.redigerMedlem(medlem, valg, newValue);
    }


    //_______________________metode til at vise listen af medlemmer_____________________________________________________
    public ArrayList<Medlem> visMedlemmer() {
       return formand.visMedlemmer();
    }


    //_______________________metode til at finde et specifikt medlems navn ud fra cpr___________________________________
    public String findSpecifiktMedlemsNavn(String cpr){
        return formand.findSpecifiktMedlemsNavn(cpr);
    }


    //_______________________metode til at finde specifikt medlem_______________________________________________________
    public Medlem findSpecifiktMedlem(String cpr){
        return formand.findSpecifiktMedlem(cpr);
    }


    //_______________________metode til at sorterer i medlemlisten efter ønsket kategori________________________________
    public void sorterMedlemmerValgMetode(int valg) {
        formand.sorterMedlemmerValgMetode(valg);
    }


    //_______________________metode til at gemme listen med medlemmer___________________________________________________
    public ArrayList<Medlem> gemListeAfMedlemmer (){
        return formand.gemMedlem();
    }


    //_________________________Kasserer metoder_________________________________________________________________________


    //_______________________metode til at se forventet kontigent for svømmeklubben_____________________________________
    public int forventetKontingent(){
        return kasserer.samletForventetKontingent();
    }


    //_______________________metode til at se indbetalte kontingenter___________________________________________________
    public int inbetaltKontingentForNu(){
        return kasserer.indbetaltKontingentForNu();
    }


    //_______________________metode til at se liste af medlemmer der har betalt_________________________________________
    public String medlemmerDerHarBetalt(){
        return kasserer.medlemmerDerHarBetalt();
    }


    //_______________________metode til at se retance beløbet___________________________________________________________
    public int restanceBeløb(){
        return kasserer.restanceKontingent();
    }


    //_______________________metode til at se liste af medlemmer der ikke har betalt endnu______________________________
    public String medlemmerIRestance(){
        return kasserer.medlemmerIRestance();
    }



}

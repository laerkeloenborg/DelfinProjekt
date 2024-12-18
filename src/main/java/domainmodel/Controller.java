package domainmodel;

import java.util.ArrayList;

public class Controller {
    private Formand formand;
    private Kasserer kasserer;
    private Træner træner;


    //________________________konstruktør_______________________________________________________________________________
    public Controller() {
        formand = new Formand();
        kasserer = new Kasserer();
        træner = new Træner();
    }


    //______________________Formands metoder____________________________________________________________________________


    //_______________________metode til at oprette medlem_______________________________________________________________
    public void opretMedlem(String navn, String cpr, MedlemsStatus STATUS, boolean harBetalt, String aktivitetsForm) {
        formand.tilføjMedlem(navn, cpr, STATUS, harBetalt, aktivitetsForm);
    }


    //_______________________metode til at oprette konkurrence Svømmer__________________________________________________
    public void opretKonkurrenceSvømmer(String navn, String cpr, MedlemsStatus STATUS, boolean harBetalt, String aktivitetsForm, SvømmeDiscipliner svømmeDisciplin, double bedsteTid, boolean harKonkurreret) {
        formand.tilføjKonkurrenceSvømmer(navn, cpr, STATUS, harBetalt, aktivitetsForm, svømmeDisciplin, bedsteTid, harKonkurreret);
    }


    //_______________________metode til at slette medlem________________________________________________________________
    public boolean sletMedlem(String navn) {
        return formand.sletMedlem(navn);
    }


    //_______________________metode til at redigerer i medlemmets oplysninger___________________________________________
    public void redigerMedlem(Medlem medlem, int valg, String nyVærdi) {
        formand.redigerMedlem(medlem, valg, nyVærdi);
    }


    //_______________________metode til at vise listen af medlemmer_____________________________________________________
    public String visMedlemmerne() {
        return formand.visMedlemmerne();
    }


    //_______________________metode til at få fat på medlemslisten______________________________________________________
    public ArrayList<Medlem> getMedlemsListen() {
        return formand.getMedlemsListen();
    }


    //_______________________metode til at finde et specifikt medlems navn ud fra cpr___________________________________
    public String findSpecifiktMedlemsNavn(String navn) {
        return formand.findSpecifiktMedlemsNavn(navn);
    }


    //_______________________metode til at finde specifikt medlem_______________________________________________________
    public Medlem findSpecifiktMedlem(String navn) {
        return formand.findSpecifiktMedlem(navn);
    }


    //________________________metode til at vise medlemmets oplysninger_________________________________________________
    public String visMedlemOplysninger(String navn) {
        return formand.visMedlemsOplysninger(navn);
    }


    //_______________________metode til at sorterer i medlemlisten efter ønsket kategori________________________________
    public void sorterMedlemmerValgMetode(int valg) {
        formand.sorterMedlemmerValgMetode(valg);
    }


    //_______________________metode til at sortere i medlemslisten efter navn___________________________________________
    public void sorteringNavn() {
        formand.sorteringNavn();
    }


    //_______________________metode til at gemme listen med medlemmer___________________________________________________
    public ArrayList<Medlem> gemListeAfMedlemmer() {
        return formand.gemMedlem();
    }

    //________________________metode til at se antallet af medlemmer i klubben__________________________________________
    public int antalAfMedlemmer() {
        return formand.antalMedlemmer();
    }


    //_________________________Kasserer metoder_________________________________________________________________________


    //_______________________metode til at se forventet kontigent for svømmeklubben_____________________________________
    public int forventetKontingent() {
        return kasserer.samletForventetKontingent();
    }


    //_______________________metode til at se indbetalte kontingenter___________________________________________________
    public int indbetaltKontingentForNu() {
        return kasserer.indbetaltKontingentForNu();
    }


    //_______________________metode til at se liste af medlemmer der har betalt_________________________________________
    public String medlemmerDerHarBetalt() {
        return kasserer.medlemmerDerHarBetalt();
    }


    //_______________________metode til at se retance beløbet___________________________________________________________
    public int restanceBeløb() {
        return kasserer.restanceKontingent();
    }


    //_______________________metode til at se liste af medlemmer der ikke har betalt endnu______________________________
    public String medlemmerIRestance() {
        return kasserer.medlemmerIRestance();
    }


    //_______________________Træner metoder_____________________________________________________________________________

    //_______________________metode til at sortere efter svømmers bedste tid________________________________________________
    public void sorteringTid() {
        træner.sorteringTid();
    }


    //_______________________metode til at se sortere efter om svømmerne har konkurreret før____________________________
    public void sorteringKonkurrenceStatus() {
        træner.sortertingKonkurrenceStatus();
    }


    //_______________________metode til at se konkurrencesvømmere der er på juniorholdet________________________________
    public String visJuniorHold() {
        return træner.printJuniorHold();
    }


    //_______________________metode til at se konkurrencesvømmere der er på seniorholdet________________________________
    public String visSeniorHold() {
        return træner.printSeniorHold();
    }

    //________________________metode til at se seniorHoldene____________________________________________________________
    public ArrayList<KonkurrenceSvømmer> hentSeniorHold() {
        return træner.hentSeniorSvømmere();
    }

    //________________________metode til at se juniorholdene____________________________________________________________
    public ArrayList<KonkurrenceSvømmer> hentJuniorHold() {
        return træner.hentJuniorSvømmere();
    }


    //_______________________metode til at få listen over konkurrencesvømmere (uden layout)_____________________________


    //_______________________metode til at se se top5 svømmere (pæn layout)_____________________________________________
    public String printTop5(AldersGruppe ALDERSGRUPPE, SvømmeDiscipliner SVØMMEDISCIPLIN) {
        return træner.printTop5(ALDERSGRUPPE, SVØMMEDISCIPLIN);
    }


    //________________________metode til at redigerer i et konkurrenceSvømmerObjekt_____________________________________
    public String ændringAfKonkurrenceSvømmer(Medlem konkurrenceSvømmer, int valg, String nyInfo) {
        return træner.ændringAfKonkurrenceSvømmer(konkurrenceSvømmer, valg, nyInfo);
    }

    //_______________________metode til at finde et specifikt medlems navn______________________________________________
    public String findSpecifiktKonkurrenceSvømmersNavn(String info) {
        return træner.findSpecifiktKonkurrenceSvømmersNavn(info);
    }


    //_______________________metode til at finde specifikt medlem_______________________________________________________
    public Medlem findSpecifiktKonkurrenceSvømmer(String info) {
        return træner.findSpecifiktKonkurrenceSvømmer(info);
    }


    // Metode til at gemme konkurrenceSvømmere
    public void gemKonkurrenceSvømmere(ArrayList<KonkurrenceSvømmer> konkurrenceSvømmerListe) {
        træner.gemKonkurrenceSvømmere(konkurrenceSvømmerListe);
    }


    // Metode til at hente konkurrenceSvømmere
    public String hentKonkurrenceSvømmere() {
        return træner.hentKonkurrenceSvømmere();
    }
}

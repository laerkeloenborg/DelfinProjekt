import java.util.ArrayList;

public class Listen {

    private FileHandler fileHandler;

    public Listen(){
        this.fileHandler = new FileHandler();
    }

    public ArrayList<Medlem> getMedlemsListen(){
        return fileHandler.hentListeAfMedlemmer();
    }

    public ArrayList<KonkurrenceSvømmer> getKonkurrenceSvømmer() {
        ArrayList<KonkurrenceSvømmer> konkurrenceSvømmerListe = new ArrayList<>();
        for (Medlem medlem : fileHandler.hentListeAfMedlemmer()) {
            if (medlem instanceof KonkurrenceSvømmer) {
                konkurrenceSvømmerListe.add(((KonkurrenceSvømmer) medlem));
            }
        }
        return konkurrenceSvømmerListe;
    }

    public void tilføjMedlem(Medlem medlem){
        ArrayList<Medlem> medlemmer = this.getMedlemsListen();
        medlemmer.add(medlem);
        fileHandler.gemListeAfMedlemmer(medlemmer);
    }

    public void fjernMedlem(Medlem medlem){
        ArrayList<Medlem> medlemmer = this.getMedlemsListen();
        medlemmer.remove(medlem);
        fileHandler.gemListeAfMedlemmer(medlemmer);
    }




}

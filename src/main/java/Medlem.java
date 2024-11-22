public class Medlem {
    private String navn;
    private int cpr;
    private boolean aktivitetsStatus;
    private boolean aktivitetsForm;

    public Medlem(String navn, int cpr, boolean aktivitetsStatus, boolean aktivitetsForm){
        this.navn = navn;
        this.cpr = cpr;
        this.aktivitetsStatus = aktivitetsStatus;
        this.aktivitetsForm = aktivitetsForm;
    }

    //------------------ GETTER & SETTER ----------------
    public String getNavn(){
        return navn;
    }
    public void setNavn(String navn){
        this.navn = navn;
    }

    public int getCpr(){
        return cpr;
    }
    public void setCpr(int cpr){
        this.cpr = cpr;
    }

    public boolean getAktivitetsStatus(){
        return aktivitetsStatus;
    }
    public void setAktivitetsStatus(boolean aktivitetsStatus){
        this.aktivitetsStatus = aktivitetsStatus;
    }

    public boolean getAktivitetsForm(){
        return aktivitetsForm;
    }
    public void setAktivitetsForm(boolean aktivitetsForm){
        this.aktivitetsForm = aktivitetsForm;
    }

    //Metode til omregning af cpr til alder
    public int cprOmregning(int cpr){



    }



}

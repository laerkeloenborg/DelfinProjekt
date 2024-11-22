import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Medlem {
    private String navn;
    private String cpr;
    private boolean aktivitetsStatus;
    private boolean aktivitetsForm;

    public Medlem(String navn, String cpr, boolean aktivitetsStatus, boolean aktivitetsForm){
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

    public String getCpr(){
        return cpr;
    }
    public void setCpr(String cpr){
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
        public String cprOmregning(){
            LocalDate date = LocalDate.now();
            DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("ddMMyy");
            String formattedDate = date.format(formatDate);
            int result = Integer.parseInt(formattedDate) - Integer.parseInt(this.getCpr());
            String trim = String.valueOf(result);
            trim.getChars([4],[5]);

        }


    @Override
    public String toString() {
        return "navn: "+ getNavn() +
                " Alder: " + cprOmregning() +
                " aktivitets status: " + getAktivitetsStatus() +
                " aktivitetsform: "+ getAktivitetsForm();
    }
}






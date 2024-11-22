import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;


public class Medlem {
    private String navn;
    private String cpr;
    private boolean aktivitetsStatus;
    private String aktivitetsForm;

    public Medlem(String navn, String cpr, boolean aktivitetsStatus, String aktivitetsForm) {
        this.navn = navn;
        this.cpr = cpr;
        this.aktivitetsStatus = aktivitetsStatus;
        this.aktivitetsForm = aktivitetsForm;
    }


    //------------------ GETTER & SETTER ----------------
    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    //TODO: LAV EN EXCEPTION SÅ MAN SKAL SKRIVE 6 TAL
    public String getCpr() {
        return cpr;
    }

    public void setCpr(String cpr) {
        this.cpr = cpr;
    }

    public boolean getAktivitetsStatus() {
        return aktivitetsStatus;
    }

    public void setAktivitetsStatus(boolean aktivitetsStatus) {
        this.aktivitetsStatus = aktivitetsStatus;
    }

    public String getAktivitetsForm() {
        if (aktivitetsForm.equalsIgnoreCase("konkurrence")) {
            setAktivitetsForm("Konkurrence svømmer");
        } else if (aktivitetsForm.equalsIgnoreCase("motionist")) {
            setAktivitetsForm("Motionist");
        }
        return aktivitetsForm;
    }

    public void setAktivitetsForm(String aktivitetsForm) {
        this.aktivitetsForm = aktivitetsForm;
    }


    //Metode til omregning af cpr til alder
    public int cprOmregning() {
        LocalDate nu = LocalDate.now();
        String cpr = this.getCpr();
        int dag = Integer.parseInt(cpr.substring(0, 2));
        int måned = Integer.parseInt(cpr.substring(2, 4));
        int år = Integer.parseInt(cpr.substring(4, 6));
        if (år >= 0 && år <= LocalDate.now().getYear() % 100) {
            år += 2000;
        } else {
            år += 1900;
        }
        LocalDate fødselsdato = LocalDate.of(år, måned, dag);
        int alder = Period.between(fødselsdato, nu).getYears();
        return alder;
    }



@Override
public String toString() {
    return "navn: " + getNavn() +
            "\nAlder: " + cprOmregning() +
            "\naktivitets status: " + (getAktivitetsStatus() ? "aktiv" : "passiv") +
            "\naktivitetsform: " + getAktivitetsForm();
}
}






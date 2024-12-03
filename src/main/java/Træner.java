public class Træner {

    private FileHandler fileHandler;

    public Træner() {
        fileHandler = new FileHandler();
    }


    public String ændringAfKonkurrenceSvømmer(KonkurrenceSvømmer konkurrenceSvømmer, int valg, String nyInfo) {
        switch (valg) {
            case 1:
                double nySvømmetid = Double.parseDouble(nyInfo);
                konkurrenceSvømmer.setBedsteTid(nySvømmetid);
                break;
            case 2:
                Boolean nyKonkurrenceStatus = nyInfo.equalsIgnoreCase("ja");
                konkurrenceSvømmer.setHarKonkurreret(nyKonkurrenceStatus);
                break;

            case 3:
                SvømmeDiscipliner nySvømmedisciplin = SvømmeDiscipliner.valueOf(nyInfo);
                konkurrenceSvømmer.setSVØMMEDISCIPLIN(nySvømmedisciplin);
                break;
            default:
                return "Ugyldigt valg";
        }
        return "";
    }


    public String hentKonkurrenceSvømmereFraFil() {
        String string = "";
        int tæller = 1;
        for (KonkurrenceSvømmer konkurrenceSvømmer : fileHandler.hentListeAfKonkurrenceSvømmere()){
            string += tæller++ + ". " +  konkurrenceSvømmer.getNavn() + ",  " + konkurrenceSvømmer.getAldersGruppe() + ", " + konkurrenceSvømmer.getMedlemsstatus() +
            ", " + konkurrenceSvømmer.getSVØMMEDISCIPLIN() + ", " + konkurrenceSvømmer.getBedsteTid() + ", " + konkurrenceSvømmer.getHarKonkurreret() +"\n";
    }
    return string;
}

}

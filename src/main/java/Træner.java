public class Træner {

    public Træner() {

    }


    public String ændringAfKonkurrenceSvømmer(KonkurrenceSvømmer konkurrenceSvømmer, int valg, String nyInfo) {
        switch (valg) {
            case 1:
                //set ny svømmetid
                double nySvømmetid = Double.parseDouble(nyInfo);
                konkurrenceSvømmer.setBedsteTid(nySvømmetid);
                break;
            case 2:
                //set ny status konkurrence
                Boolean nyKonkurrenceStatus = nyInfo.equalsIgnoreCase("ja");
                konkurrenceSvømmer.setHarKonkurreret(nyKonkurrenceStatus);
                break;

            case 3:
                //set ny svømmedisciplin
                SvømmeDiscipliner nySvømmedisciplin = SvømmeDiscipliner.valueOf(nyInfo);
                konkurrenceSvømmer.setSVØMMEDISCIPLIN(nySvømmedisciplin);
                break;
            default:
                return "Ugyldigt valg";
        }
        return "";
    }

}

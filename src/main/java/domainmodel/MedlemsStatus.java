package domainmodel;

public enum MedlemsStatus {
    AKTIV,
    PASSIV;


    //_____metode der gør at vi kan split enum i fileHandler metoden hentListeAfMedlemmer_______________________________
    public static MedlemsStatus parseMedlemsStatus(String statusString){
        for (MedlemsStatus status : MedlemsStatus.values()) {
            if (status.name().equalsIgnoreCase(statusString)) {
                return status;
            }
        }
        return MedlemsStatus.PASSIV;
    }


}

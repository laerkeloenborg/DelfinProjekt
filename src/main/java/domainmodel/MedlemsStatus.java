package domainmodel;

public enum MedlemsStatus {
    AKTIV,
    PASSIV;


    //metode der gør at vi kan split enum i fileHandler metoden hentListeAfMedlemmer
    public static MedlemsStatus parseMedlemsStatus(String statusString){
        for (MedlemsStatus status : MedlemsStatus.values()) {
            if (status.name().equalsIgnoreCase(statusString)) {
                return status;
            }
        }
        return MedlemsStatus.PASSIV;
    }


}
package domainmodel;

public enum SvømmeDiscipliner {
    INGEN,
    BUTTERFLY,
    CRAWL,
    RYGCRAWL,
    BRYSTSVØMNING;


    //_____________________metode til at parse enum til string__________________________________________________________
   public static SvømmeDiscipliner parseSvømmeDescipliner(String disciplinString){
        for (SvømmeDiscipliner disciplin : SvømmeDiscipliner.values()) {
            if (disciplin.name().equalsIgnoreCase(disciplinString)) {
                return disciplin;
            }
        }
        return SvømmeDiscipliner.INGEN;
    }


    //____________________to string til at udskrive pænt________________________________________________________________
    static String toString(SvømmeDiscipliner disciplin){
        switch (disciplin){
            case CRAWL:
                return "crawl";
            case RYGCRAWL:
                return "Rygcrawl";
            case BRYSTSVØMNING:
                return "Brystsvømning";
            case BUTTERFLY:
                return "Butterfly";
            default:
                return "ingen disciplin registreret";
        }
    }


}

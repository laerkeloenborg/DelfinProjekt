package domainmodel;

public enum SvømmeDiscipliner {
    INGEN,
    BUTTERFLY,
    CRAWL,
    RYGCRAWL,
    BRYSTSVØMNING;

   public static SvømmeDiscipliner parseSvømmeDescipliner(String disciplinString){
        for (SvømmeDiscipliner disciplin : SvømmeDiscipliner.values()) {
            if (disciplin.name().equalsIgnoreCase(disciplinString)) {
                return disciplin;
            }
        }
        return SvømmeDiscipliner.INGEN;
    }

    static String ToString(SvømmeDiscipliner disciplin){
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

public enum SvømmeDiscipliner {
    INGEN,
    BUTTERFLY,
    CRAWL,
    RYGCRAWL,
    BRYSTSVØMNING;

    static SvømmeDiscipliner parseSvømmeDescipliner(String disciplinString){
        for (SvømmeDiscipliner disciplin : SvømmeDiscipliner.values()) {
            if (disciplin.name().equalsIgnoreCase(disciplinString)) {
                return disciplin;
            }
        }
        return SvømmeDiscipliner.INGEN;
    }
}

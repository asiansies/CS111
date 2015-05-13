public static final String[] SCHOOL_ABBREVS = {"CAS", "CFA", "CGS",
    "COM", "ENG", "GMS", "GRS", "GSM", "LAW", "MED", "MET", "SAR", "SED",
    "SHA", "SMG", "SPH", "SSW", "STH"};


public static int schoolNumber(String school){
    for(int i = 0; i < SCHOOL_ABBREVS.length; i++){
        if (SCHOOL_ABBREVS[i].equals(school)){
            return i;
        }
    }
    return -1;
}

package fr.imag.clips.papillon.business.locales;

import java.util.Locale;

/**
 * Provide the set of characters traditionaly used as index keys for dictionary access.
 */

public class LanguageIndexKeys {

    private Locale myLocale;

    private String[] keys;


    public Locale getMyLocale() {
        return myLocale;
    }

    public String[] getKeys() {
        return keys;
    }

    public LanguageIndexKeys() {
        this(Locale.getDefault());
    }

    public LanguageIndexKeys(Locale locale) {
        myLocale = locale;
        setup();
    }

    public LanguageIndexKeys(String language) {
        this(new Locale(LanguageFactory.getISO2LanguageCode(language)));
    }

    protected void setup() {
        String isoLang = myLocale.getISO3Language();
        if ("fra".equals(isoLang) ) {
            keys = new String[] {
                "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
            };
        } else if ("deu".equals(isoLang) ) {
            keys = new String[] {
                "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
            };
        } else if ("ita".equals(isoLang) ) {
            keys = new String[] {
                "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
            };
        } else if ("slv".equals(isoLang) ) {
            keys = new String[] {
                "A", "B", "C", "Č", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "R", "S", "Š", "T", "U", "V", "Z", "Ž"
            };
        } else {
            keys = new String[] {
                "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
            };
        }
    }
}

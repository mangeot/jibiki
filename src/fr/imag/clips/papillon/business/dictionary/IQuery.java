package fr.imag.clips.papillon.business.dictionary;


/**
 * Insert the type's description here.
 * Creation date: (10.08.01 20:55:06)
 * @author: Administrator
 */
public interface IQuery {
/**
 * Insert the method's description here.
 * Creation date: (10.08.01 20:55:40)
 * @return org.dict.IDatabase
 */
    public static final int STRATEGY_NONE = -1;
    // exact "Match words exactly"
    public static final int STRATEGY_EXACT = 0;

    // prefix "Match prefixes"
    public static final int STRATEGY_PREFIX = 1;

    // suffix "Match suffixes"
    public static final int STRATEGY_SUFFIX = 2;

    // substring "Match substring occurring anywhere in word"
    public static final int STRATEGY_SUBSTRING = 3;

    // insensitive "Match words case-insensitively"
     public static final int STRATEGY_INSENSITIVE_EXACT = 4;

    // inprefix "Match case-insensitive prefixes"
    public static final int STRATEGY_INSENSITIVE_PREFIX = 5;

    // insuffix "Match case-insensitive suffixes"
    public static final int STRATEGY_INSENSITIVE_SUFFIX = 6;

    // insubstring "Match case-insensitive substring occurring anywhere in word"
    public static final int STRATEGY_INSENSITIVE_SUBSTRING = 7;

    // lemmatize "Using XRCE lemmatizer module, for eng, fra, esp, ita"
    public static final int STRATEGY_LEMMATIZE = 8;
	
    // foks "Using Slaven BILAC's FOKS module, only for Japanese"
    public static final int STRATEGY_FOKS = 9;
}

/*
 * papillon
 *
 * LanguageFactory.java
 *
 * © Mathieu Mangeot & Gilles Sérasset - GETA CLIPS IMAG
 * Projet Papillon
 *-----------------------------------------------
 * $Id$
 *-----------------------------------------------
 * $Log$
 * Revision 1.3  2005/01/15 12:51:24  mangeot
 * Deleting old cvs comments + bug fixes with xhtml and enhydra5.1
 *
 * Revision 1.2  2004/12/24 14:31:28  mangeot
 * I merged the latest developments of Papillon5.0 with this version 5.1.
 * Have to be tested more ...
 *
 * Revision 1.1.1.1  2004/12/06 16:38:31  serasset
 * Papillon for enhydra 5.1. This version compiles and starts with enhydra 5.1.
 * There are still bugs in the code.
 *
 *-----------------------------------------------
 * Language Name Factory.
 */

package fr.imag.clips.papillon.business.locales;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;

import fr.imag.clips.papillon.business.PapillonLogger;

public class LanguageFactory {

		//public static final ResourceBundle ISO6391to2TBundle = ResourceBundle.getBundle("/fr/imag/clips/papillon/properties/ISO-639-1to2T", Locale.getDefault());
//		public static final ResourceBundle ISO6391to2TBundle = ResourceBundle.getBundle("fr.imag.clips.papillon.properties.ISO-639-1to2T", Locale.getDefault());
//		public static final ResourceBundle ISO6392to1Bundle = ResourceBundle.getBundle("fr.imag.clips.papillon.properties.ISO-639-2to1", Locale.getDefault());
		//public static final ResourceBundle ISO6392to1Bundle = ResourceBundle.getBundle("/fr/imag/clips/papillon/properties/ISO-639-2to1", Locale.getDefault());

		public static final HashMap ISO6391to2TMap = new HashMap();
		static {
ISO6391to2TMap.put("aa","aar");
ISO6391to2TMap.put("ab","abk");
ISO6391to2TMap.put("ae","ave");
ISO6391to2TMap.put("af","afr");
ISO6391to2TMap.put("ak","aka");
ISO6391to2TMap.put("am","amh");
ISO6391to2TMap.put("an","arg");
ISO6391to2TMap.put("ar","ara");
ISO6391to2TMap.put("as","asm");
ISO6391to2TMap.put("av","ava");
ISO6391to2TMap.put("ax","axi");
ISO6391to2TMap.put("ay","aym");
ISO6391to2TMap.put("az","aze");
ISO6391to2TMap.put("ba","bak");
ISO6391to2TMap.put("be","bel");
ISO6391to2TMap.put("bg","bul");
ISO6391to2TMap.put("bh","bih");
ISO6391to2TMap.put("bi","bis");
ISO6391to2TMap.put("bm","bam");
ISO6391to2TMap.put("bn","ben");
ISO6391to2TMap.put("bo","bod");
ISO6391to2TMap.put("br","bre");
ISO6391to2TMap.put("bs","bos");
ISO6391to2TMap.put("ca","cat");
ISO6391to2TMap.put("ce","che");
ISO6391to2TMap.put("ch","cha");
ISO6391to2TMap.put("co","cos");
ISO6391to2TMap.put("cr","cre");
ISO6391to2TMap.put("cs","ces");
ISO6391to2TMap.put("cu","chu");
ISO6391to2TMap.put("cv","chv");
ISO6391to2TMap.put("cy","cym");
ISO6391to2TMap.put("da","dan");
ISO6391to2TMap.put("de","deu");
ISO6391to2TMap.put("dv","div");
ISO6391to2TMap.put("dz","dzo");
ISO6391to2TMap.put("ee","ewe");
ISO6391to2TMap.put("el","ell");
ISO6391to2TMap.put("en","eng");
ISO6391to2TMap.put("eo","epo");
ISO6391to2TMap.put("es","esp");
ISO6391to2TMap.put("et","est");
ISO6391to2TMap.put("eu","eus");
ISO6391to2TMap.put("fa","fas");
ISO6391to2TMap.put("ff","ful");
ISO6391to2TMap.put("fi","fin");
ISO6391to2TMap.put("fj","fij");
ISO6391to2TMap.put("fo","fao");
ISO6391to2TMap.put("fr","fra");
ISO6391to2TMap.put("fy","fry");
ISO6391to2TMap.put("ga","gle");
ISO6391to2TMap.put("gd","gla");
ISO6391to2TMap.put("gl","glg");
ISO6391to2TMap.put("gn","grn");
ISO6391to2TMap.put("gu","guj");
ISO6391to2TMap.put("gv","glv");
ISO6391to2TMap.put("ha","hau");
ISO6391to2TMap.put("he","heb");
ISO6391to2TMap.put("hi","hin");
ISO6391to2TMap.put("ho","hmo");
ISO6391to2TMap.put("hr","hrv");
ISO6391to2TMap.put("ht","hat");
ISO6391to2TMap.put("hu","hun");
ISO6391to2TMap.put("hy","hye");
ISO6391to2TMap.put("hz","her");
ISO6391to2TMap.put("ia","ina");
ISO6391to2TMap.put("id","ind");
ISO6391to2TMap.put("ie","ile");
ISO6391to2TMap.put("ig","ibo");
ISO6391to2TMap.put("ii","iii");
ISO6391to2TMap.put("ik","ipk");
ISO6391to2TMap.put("in","ind");
ISO6391to2TMap.put("io","ido");
ISO6391to2TMap.put("is","isl");
ISO6391to2TMap.put("it","ita");
ISO6391to2TMap.put("iu","iku");
ISO6391to2TMap.put("iw","heb");
ISO6391to2TMap.put("ja","jpn");
ISO6391to2TMap.put("ji","yid");
ISO6391to2TMap.put("jv","jav");
ISO6391to2TMap.put("jw","jav");
ISO6391to2TMap.put("ka","kat");
ISO6391to2TMap.put("kg","kon");
ISO6391to2TMap.put("ki","kik");
ISO6391to2TMap.put("kj","kua");
ISO6391to2TMap.put("kk","kaz");
ISO6391to2TMap.put("kl","kal");
ISO6391to2TMap.put("km","khm");
ISO6391to2TMap.put("kn","kan");
ISO6391to2TMap.put("ko","kor");
ISO6391to2TMap.put("kr","kau");
ISO6391to2TMap.put("ks","kas");
ISO6391to2TMap.put("ku","kur");
ISO6391to2TMap.put("kv","kom");
ISO6391to2TMap.put("kw","cor");
ISO6391to2TMap.put("ky","kir");
ISO6391to2TMap.put("la","lat");
ISO6391to2TMap.put("lb","ltz");
ISO6391to2TMap.put("lg","lug");
ISO6391to2TMap.put("li","lim");
ISO6391to2TMap.put("ln","lin");
ISO6391to2TMap.put("lo","lao");
ISO6391to2TMap.put("lt","lit");
ISO6391to2TMap.put("lu","lub");
ISO6391to2TMap.put("lv","lav");
ISO6391to2TMap.put("mg","mlg");
ISO6391to2TMap.put("mh","mah");
ISO6391to2TMap.put("mi","mri");
ISO6391to2TMap.put("mk","mkd");
ISO6391to2TMap.put("ml","mal");
ISO6391to2TMap.put("mn","mon");
ISO6391to2TMap.put("mo","mol");
ISO6391to2TMap.put("mr","mar");
ISO6391to2TMap.put("ms","msa");
ISO6391to2TMap.put("mt","mlt");
ISO6391to2TMap.put("my","mya");
ISO6391to2TMap.put("na","nau");
ISO6391to2TMap.put("nb","nob");
ISO6391to2TMap.put("nd","nde");
ISO6391to2TMap.put("ne","nep");
ISO6391to2TMap.put("ng","ndo");
ISO6391to2TMap.put("nl","nld");
ISO6391to2TMap.put("nn","nno");
ISO6391to2TMap.put("no","nor");
ISO6391to2TMap.put("nr","nbl");
ISO6391to2TMap.put("nv","nav");
ISO6391to2TMap.put("ny","nya");
ISO6391to2TMap.put("oc","oci");
ISO6391to2TMap.put("oj","oji");
ISO6391to2TMap.put("om","orm");
ISO6391to2TMap.put("or","ori");
ISO6391to2TMap.put("os","oss");
ISO6391to2TMap.put("pa","pan");
ISO6391to2TMap.put("pi","pli");
ISO6391to2TMap.put("pl","pol");
ISO6391to2TMap.put("ps","pus");
ISO6391to2TMap.put("pt","por");
ISO6391to2TMap.put("qu","que");
ISO6391to2TMap.put("rm","roh");
ISO6391to2TMap.put("rn","run");
ISO6391to2TMap.put("ro","ron");
ISO6391to2TMap.put("ru","rus");
ISO6391to2TMap.put("rw","kin");
ISO6391to2TMap.put("sa","san");
ISO6391to2TMap.put("sc","srd");
ISO6391to2TMap.put("sd","snd");
ISO6391to2TMap.put("se","sme");
ISO6391to2TMap.put("sg","sag");
ISO6391to2TMap.put("sh","scr");
ISO6391to2TMap.put("si","sin");
ISO6391to2TMap.put("sk","slk");
ISO6391to2TMap.put("sl","slv");
ISO6391to2TMap.put("sm","smo");
ISO6391to2TMap.put("sn","sna");
ISO6391to2TMap.put("so","som");
ISO6391to2TMap.put("sq","sqi");
ISO6391to2TMap.put("sr","srp");
ISO6391to2TMap.put("ss","ssw");
ISO6391to2TMap.put("st","sot");
ISO6391to2TMap.put("su","sun");
ISO6391to2TMap.put("sv","swe");
ISO6391to2TMap.put("sw","swa");
ISO6391to2TMap.put("ta","tam");
ISO6391to2TMap.put("te","tel");
ISO6391to2TMap.put("tg","tgk");
ISO6391to2TMap.put("th","tha");
ISO6391to2TMap.put("ti","tir");
ISO6391to2TMap.put("tk","tuk");
ISO6391to2TMap.put("tl","tgl");
ISO6391to2TMap.put("tn","tsn");
ISO6391to2TMap.put("to","ton");
ISO6391to2TMap.put("tr","tur");
ISO6391to2TMap.put("ts","tso");
ISO6391to2TMap.put("tt","tat");
ISO6391to2TMap.put("tw","twi");
ISO6391to2TMap.put("ty","tah");
ISO6391to2TMap.put("ug","uig");
ISO6391to2TMap.put("uk","ukr");
ISO6391to2TMap.put("un","unl");
ISO6391to2TMap.put("ur","urd");
ISO6391to2TMap.put("uz","uzb");
ISO6391to2TMap.put("ve","ven");
ISO6391to2TMap.put("vi","vie");
ISO6391to2TMap.put("vo","vol");
ISO6391to2TMap.put("wa","wln");
ISO6391to2TMap.put("wo","wol");
ISO6391to2TMap.put("xh","xho");
ISO6391to2TMap.put("yi","yid");
ISO6391to2TMap.put("yo","yor");
ISO6391to2TMap.put("za","zha");
ISO6391to2TMap.put("zh","zho");
ISO6391to2TMap.put("zu","zul");
ISO6391to2TMap.put("zz","zzz");

		}

		public static final HashMap ISO6392to1Map = new HashMap();
		static {
ISO6392to1Map.put("aar","aa");
ISO6392to1Map.put("abk","ab");
ISO6392to1Map.put("afr","af");
ISO6392to1Map.put("aka","ak");
ISO6392to1Map.put("alb","sq");
ISO6392to1Map.put("amh","am");
ISO6392to1Map.put("ara","ar");
ISO6392to1Map.put("arg","an");
ISO6392to1Map.put("arm","hy");
ISO6392to1Map.put("asm","as");
ISO6392to1Map.put("ava","av");
ISO6392to1Map.put("ave","ae");
ISO6392to1Map.put("axi","ax");
ISO6392to1Map.put("aym","ay");
ISO6392to1Map.put("aze","az");
ISO6392to1Map.put("bak","ba");
ISO6392to1Map.put("bam","bm");
ISO6392to1Map.put("baq","eu");
ISO6392to1Map.put("bel","be");
ISO6392to1Map.put("ben","bn");
ISO6392to1Map.put("bih","bh");
ISO6392to1Map.put("bis","bi");
ISO6392to1Map.put("bod","bo");
ISO6392to1Map.put("bos","bs");
ISO6392to1Map.put("bre","be");
ISO6392to1Map.put("bul","bg");
ISO6392to1Map.put("bur","my");
ISO6392to1Map.put("cat","ca");
ISO6392to1Map.put("ces","cs");
ISO6392to1Map.put("cha","ch");
ISO6392to1Map.put("che","ce");
ISO6392to1Map.put("chi","zh");
ISO6392to1Map.put("chu","cu");
ISO6392to1Map.put("chv","cv");
ISO6392to1Map.put("cor","kw");
ISO6392to1Map.put("cos","co");
ISO6392to1Map.put("cre","cr");
ISO6392to1Map.put("cym","cy");
ISO6392to1Map.put("cze","cs");
ISO6392to1Map.put("dan","da");
ISO6392to1Map.put("deu","de");
ISO6392to1Map.put("div","dv");
ISO6392to1Map.put("dut","nl");
ISO6392to1Map.put("dzo","dz");
ISO6392to1Map.put("ell","el");
ISO6392to1Map.put("eng","en");
ISO6392to1Map.put("epo","eo");
ISO6392to1Map.put("esl","es");
ISO6392to1Map.put("esp","es");
ISO6392to1Map.put("est","et");
ISO6392to1Map.put("eus","eu");
ISO6392to1Map.put("ewe","ee");
ISO6392to1Map.put("fao","fo");
ISO6392to1Map.put("fas","fa");
ISO6392to1Map.put("fij","fj");
ISO6392to1Map.put("fin","fi");
ISO6392to1Map.put("fra","fr");
ISO6392to1Map.put("fre","fr");
ISO6392to1Map.put("fry","fy");
ISO6392to1Map.put("ful","ff");
ISO6392to1Map.put("gai","ga");
ISO6392to1Map.put("geo","ka");
ISO6392to1Map.put("ger","de");
ISO6392to1Map.put("glg","gl");
ISO6392to1Map.put("glv","gv");
ISO6392to1Map.put("gre","el");
ISO6392to1Map.put("grn","gn");
ISO6392to1Map.put("guj","gu");
ISO6392to1Map.put("hat","ht");
ISO6392to1Map.put("hau","ha");
ISO6392to1Map.put("heb","he");
ISO6392to1Map.put("her","hz");
ISO6392to1Map.put("hin","hi");
ISO6392to1Map.put("hmo","ho");
ISO6392to1Map.put("hrv","hr");
ISO6392to1Map.put("hun","hu");
ISO6392to1Map.put("hye","hy");
ISO6392to1Map.put("ibo","ig");
ISO6392to1Map.put("ice","is");
ISO6392to1Map.put("ido","io");
ISO6392to1Map.put("iii","ii");
ISO6392to1Map.put("iku","iu");
ISO6392to1Map.put("ina","ia");
ISO6392to1Map.put("ind","id");
ISO6392to1Map.put("ipk","ik");
ISO6392to1Map.put("iri","ga");
ISO6392to1Map.put("isl","is");
ISO6392to1Map.put("ita","it");
ISO6392to1Map.put("jav","jv");
ISO6392to1Map.put("jaw","jv");
ISO6392to1Map.put("jpn","ja");
ISO6392to1Map.put("kal","kl");
ISO6392to1Map.put("kan","kn");
ISO6392to1Map.put("kas","ks");
ISO6392to1Map.put("kat","ka");
ISO6392to1Map.put("kau","kr");
ISO6392to1Map.put("kaz","kk");
ISO6392to1Map.put("khm","km");
ISO6392to1Map.put("kik","ki");
ISO6392to1Map.put("kin","rw");
ISO6392to1Map.put("kir","ky");
ISO6392to1Map.put("kom","kv");
ISO6392to1Map.put("kon","kg");
ISO6392to1Map.put("kor","ko");
ISO6392to1Map.put("kua","kj");
ISO6392to1Map.put("kur","ku");
ISO6392to1Map.put("lao","lo");
ISO6392to1Map.put("lat","la");
ISO6392to1Map.put("lav","lv");
ISO6392to1Map.put("lim","li");
ISO6392to1Map.put("lin","ln");
ISO6392to1Map.put("lit","lt");
ISO6392to1Map.put("ltz","lb");
ISO6392to1Map.put("lub","lu");
ISO6392to1Map.put("lug","lg");
ISO6392to1Map.put("mac","mk");
ISO6392to1Map.put("mah","mh");
ISO6392to1Map.put("mak","mk");
ISO6392to1Map.put("mao","mi");
ISO6392to1Map.put("mar","mr");
ISO6392to1Map.put("may","ms");
ISO6392to1Map.put("mlg","mg");
ISO6392to1Map.put("mlt","ml");
ISO6392to1Map.put("mol","mo");
ISO6392to1Map.put("mon","mn");
ISO6392to1Map.put("mri","mi");
ISO6392to1Map.put("msa","ms");
ISO6392to1Map.put("mya","my");
ISO6392to1Map.put("nau","na");
ISO6392to1Map.put("nav","nv");
ISO6392to1Map.put("nbl","nr");
ISO6392to1Map.put("nde","nd");
ISO6392to1Map.put("ndo","ng");
ISO6392to1Map.put("nep","ne");
ISO6392to1Map.put("nla","nl");
ISO6392to1Map.put("nno","nn");
ISO6392to1Map.put("nob","nb");
ISO6392to1Map.put("nor","no");
ISO6392to1Map.put("nya","ny");
ISO6392to1Map.put("oci","oc");
ISO6392to1Map.put("oci","oc");
ISO6392to1Map.put("oji","oj");
ISO6392to1Map.put("ori","or");
ISO6392to1Map.put("orm","om");
ISO6392to1Map.put("oss","os");
ISO6392to1Map.put("pan","pa");
ISO6392to1Map.put("per","fa");
ISO6392to1Map.put("pli","pi");
ISO6392to1Map.put("pol","pl");
ISO6392to1Map.put("por","pt");
ISO6392to1Map.put("pus","ps");
ISO6392to1Map.put("que","qu");
ISO6392to1Map.put("roh","rm");
ISO6392to1Map.put("ron","ro");
ISO6392to1Map.put("rum","ro");
ISO6392to1Map.put("run","rn");
ISO6392to1Map.put("rus","ru");
ISO6392to1Map.put("sag","sg");
ISO6392to1Map.put("san","sa");
ISO6392to1Map.put("scc","sr");
ISO6392to1Map.put("scr","sh");
ISO6392to1Map.put("sin","si");
ISO6392to1Map.put("slk","sk");
ISO6392to1Map.put("slo","sk");
ISO6392to1Map.put("slv","sl");
ISO6392to1Map.put("sme","se");
ISO6392to1Map.put("smo","sm");
ISO6392to1Map.put("sna","sn");
ISO6392to1Map.put("snd","sd");
ISO6392to1Map.put("som","so");
ISO6392to1Map.put("sot","st");
ISO6392to1Map.put("spa","es");
ISO6392to1Map.put("sqi","sq");
ISO6392to1Map.put("srd","sc");
ISO6392to1Map.put("srp","sr");
ISO6392to1Map.put("ssw","ss");
ISO6392to1Map.put("sun","su");
ISO6392to1Map.put("sve","sv");
ISO6392to1Map.put("swa","sw");
ISO6392to1Map.put("swe","sv");
ISO6392to1Map.put("tah","ty");
ISO6392to1Map.put("tam","ta");
ISO6392to1Map.put("tat","tt");
ISO6392to1Map.put("tel","te");
ISO6392to1Map.put("tgk","tg");
ISO6392to1Map.put("tgl","tl");
ISO6392to1Map.put("tha","th");
ISO6392to1Map.put("tib","bo");
ISO6392to1Map.put("tir","ti");
ISO6392to1Map.put("tog","to");
ISO6392to1Map.put("tsn","tn");
ISO6392to1Map.put("tso","ts");
ISO6392to1Map.put("tuk","tk");
ISO6392to1Map.put("tur","tr");
ISO6392to1Map.put("twi","tw");
ISO6392to1Map.put("uig","ug");
ISO6392to1Map.put("ukr","uk");
ISO6392to1Map.put("unl","un");
ISO6392to1Map.put("urd","ur");
ISO6392to1Map.put("uzb","uz");
ISO6392to1Map.put("ven","ve");
ISO6392to1Map.put("vie","vi");
ISO6392to1Map.put("vol","vo");
ISO6392to1Map.put("wel","cy");
ISO6392to1Map.put("wln","wa");
ISO6392to1Map.put("wol","wo");
ISO6392to1Map.put("xho","xh");
ISO6392to1Map.put("yid","yi");
ISO6392to1Map.put("yor","yo");
ISO6392to1Map.put("zha","za");
ISO6392to1Map.put("zho","zh");
ISO6392to1Map.put("zul","zu");
ISO6392to1Map.put("zzz","zz");

		}



    /**
			* input: a String representing the ISO-639-1 two letter code of a language
		 * output: a String representing the ISO-639/T 3 letter code representing the language
		 * or a String with max 3 characters if the code is not found.
		 *
		 * To add a new language code, please edit the fr.imag.clips.papillon.properties.ISO-639-1to2T.properties
		 *    and fr.imag.clips.papillon.properties.ISO-639-2to1.properties file
		 *
		 * @return ArrayList containing the accepted languages.
		 */
    public static String getISO3LanguageCode(String lang) {
			String res = lang;
			if (lang.length() > 3) {
				lang=lang.substring(0,3);
			}
			if (lang.length() >= 2) {
				try {
				//	res = ISO6391to2TBundle.getString(lang.substring(0,2));
					res = (String) ISO6391to2TMap.get(lang.substring(0,2));
				}
				catch (Exception e) {
					/* code was not found */
					res=lang;
				}
			}
			return res;
    }

    /**
			* input: a String representing the ISO-639-2 3 letter code of a language
		 * output: a String representing the ISO-639/T 2 letter code representing the language
		 * or a String with max 2 characters if the code is not found.
		 *
		 * To add a new language code, please edit the fr.imag.clips.papillon.properties.ISO-639-2to1.properties file
		 *    and fr.imag.clips.papillon.properties.ISO-639-1to2T.properties file
		 *
		 * @return ArrayList containing the accepted languages.
		 */
    public static String getISO2LanguageCode(String lang) {
			String res = lang;
			if (lang.length() >= 3) {
				lang=lang.substring(0,3);
				try {
					//res = ISO6392to1Bundle.getString(lang.substring(0,3));
					res = (String)ISO6392to1Map.get(lang.substring(0,3));
				}
				catch (Exception e) {
					/* code was not found */
					res=lang.substring(0,2);
				}
			}
			return res;
    }

    /**
    * Returns a List of String representing the languages accepted by the user, in
    * the user's preference order.
    *
    * @return ArrayList containing the accepted languages.
    */
    public static ArrayList decodeAcceptLanguages(String languages) {
        ArrayList result = new ArrayList(); 

        if (null == languages) return result;
        String[] languagesArray = languages.split(",");

        if (null == languagesArray) return result;

        for (int i=0; i<languagesArray.length; i++) {
            String lang =  languagesArray[i];
            String[] langSplit = lang.split(";");
            lang = (null == langSplit || 0 == langSplit.length) ? "" : langSplit[0];

            result.add(getISO3LanguageCode(lang));
        }
        return result;
    }        
}

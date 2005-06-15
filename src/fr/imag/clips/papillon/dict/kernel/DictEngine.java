package fr.imag.clips.papillon.dict.kernel;

import java.util.Collection;
import java.util.Vector;

import fr.imag.clips.papillon.business.dictionary.AvailableLanguages;
import fr.imag.clips.papillon.business.dictionary.DictionariesFactory;
import fr.imag.clips.papillon.business.dictionary.Dictionary;
import fr.imag.clips.papillon.business.dictionary.ErrorAnswer;
import fr.imag.clips.papillon.business.dictionary.IAnswer;
import fr.imag.clips.papillon.business.dictionary.IQuery;
import fr.imag.clips.papillon.business.dictionary.Volume;
import fr.imag.clips.papillon.business.dictionary.VolumesFactory;
import fr.imag.clips.papillon.business.transformation.XslTransformation;
import fr.imag.clips.papillon.business.user.User;
import fr.imag.clips.papillon.business.user.UsersFactory;

import com.lutris.appserver.server.Application;
import com.lutris.appserver.server.Enhydra;

/**
* Insert the type's description here.
* Creation date: (29.07.01 12:47:32)
* @author: Administrator
*/
public class DictEngine implements IDictEngine {

    protected Application enhydraApp;
    protected User theUser = null;
	protected boolean mime = false;
	protected String view = "";
	protected static final IAnswer errorAnswer = new ErrorAnswer();
	protected static final IAnswer[] errorAnswers = {errorAnswer};

    /**
        * DatabaseFactory constructor comment.
        */
    public DictEngine(Application myApplication) {
        super();
        enhydraApp = myApplication;
    }
    public void initialize() {
        Enhydra.register(enhydraApp);
    }

    public void finalize() {
        Enhydra.unRegister();
    }
	
	public void setMime(boolean newMime) {
		mime = newMime;
	}
	public boolean IsMime() {
		return mime;
	}

	public void setView(String newView) {
		view = newView;
	}
	public String processView (IAnswer entry) {
		String res = null;
		try {
		// disabled
			// is there a way to obtain a dom result which is a text string?
			if (view!=null && !view.equals("")) {
				if (view.equals(IDictEngine.TEXT_view)) {
					res = XslTransformation.applyXslSheetForText(entry);
				}
				else if (view.equals(IDictEngine.HTML_view)) {
					res = XslTransformation.applyXslSheetsAndSerialize(entry);
				}
				else {
					res = entry.getXmlCode();
				}
			}
			else { 
				res = entry.getXmlCode();
			}
		}
		catch (Exception e) {
            throw new RuntimeException("Error in processView");
        }
		return res;
	}
	
    public String[] getDictionariesInfo() {
        String[] Infos = null;
        try {
            Dictionary[] Dicts = DictionariesFactory.getDictionariesArray();
            Infos = new String[Dicts.length];
            for (int i=0; i<Dicts.length;i++) {
                Infos[i] = Dicts[i].getName() + " \"" + Dicts[i].getFullName() + "\"";
            }
        }
        catch (Exception e) {
            throw new RuntimeException("Error in getDictionariesInfo");
        }
        return Infos;
    }

    public String[] getDatabaseInfo() {
        String[] Infos = null;
        try {
            Dictionary[] Dicts = DictionariesFactory.getDictionariesArray();
            Infos = new String[Dicts.length];
            for (int i=0; i<Dicts.length;i++) {
                Dictionary dict = Dicts[i];
                int count = 0;
                Volume[] Volumes = VolumesFactory.getVolumesArray(dict.getName());
                if (Volumes != null && Volumes.length > 0) {
                    for (int j=0 ; j< Volumes.length; j++) {
                        count += Volumes[j].getCount();
                    }
                }
                
                Infos[i] = dict.getName() + " has " + count + " entries";
            }
        }
        catch (Exception e) {
            throw new RuntimeException("Error in getDatabaseInfo");
        }
        return Infos;
    }

    public String getDictionaryInfo(String dictName) {
        String info = null;
        try {
            Dictionary dict = DictionariesFactory.findDictionaryByName(dictName);
			if (dict != null && !dict.isEmpty()) {
				info = dict.getName() + " \"" + dict.getFullName() + "\"\n";
				String[] Sources = AvailableLanguages.getSourceLanguagesArrayForDict(dict.getName());
				String languages = "";
				if (Sources != null && Sources.length > 0) {
					for (int i=0 ; i< Sources.length; i++) {
						languages = languages + " " + Sources[i];
					}
				}
				info = info + "Available source languages: " + languages + "\n";
				int count = 0;
				Volume[] Volumes = VolumesFactory.getVolumesArray(dict.getName());
				if (Volumes != null && Volumes.length > 0) {
					for (int j=0 ; j< Volumes.length; j++) {
						count = count + Volumes[j].getCount();
					}
				}            
				info = info + dict.getName() + " has " + count + " entries";
			}
			else {
				info = null;
			}

        }
        catch (Exception e) {
            throw new RuntimeException("Error in getDictionaryInfo with dict: "+dictName);
        }
        return info;
    }

    /**
        * defineMatch method comment.
        */
    public IAnswer[] lookup(String dictName, String lang, String word, int strategy) {
        Collection Answers = null;
        try {
            if (dictName.equals("*")) return lookupAll(lang, word, strategy);
            if (dictName.equals("!")) return lookupAny(lang, word, strategy);
            Dictionary dict = DictionariesFactory.findDictionaryByName(dictName);
            if (dict != null && !dict.isEmpty()) {
                Answers = lookupDict(dict, lang, word, strategy);
            }
        }
        catch (Exception e) {
//            throw new RuntimeException("Error in Lookup with Dictionary: " + dictName);
			System.out.println("Error in Lookup with Dictionary: " + e.toString());
			e.printStackTrace();
			return errorAnswers; 
        }
        if (null != Answers) {
            return (IAnswer[])Answers.toArray(new IAnswer[0]);
        }
        else {
            return null;
        }
    }

    public IAnswer[] lookupAll(String lang, String word, int strategy) {
        Collection Answers = null;
		Vector theEntries = null;
			//Headword[0] = key
			//Headword[1] = lang
			//Headword[2] = value
			//Headword[3] = strategy
		String[] Headword = new String[4];
		Headword[0] = Volume.CDM_headword;
		Headword[1] = lang;
		Headword[2] = word;
		Headword[3] = IQuery.QueryBuilderStrategy[IQuery.STRATEGY_EXACT+1];
		Vector myVector = new Vector();
		myVector.add(Headword);
		
        try {
            Answers = DictionariesFactory.getAllDictionariesEntriesCollection(myVector,
																	null,
                                                                     null,
                                                                     this.getUser());
        }
        catch (Exception e) {
//            throw new RuntimeException("Error in Lookup All");
			System.out.println("Error in LookupAll: " + e.toString());
			e.printStackTrace();
			return errorAnswers; 
        }
        return (IAnswer[])Answers.toArray(new IAnswer[0]);
    }

    public IAnswer[] lookupAny(String lang, String word, int strategy) {
        Vector Answers = new Vector();
        try {
            Dictionary[] Dictionaries = DictionariesFactory.getDictionariesArray();
            if (null != Dictionaries && Dictionaries.length > 0) {
                int i=0;
                while (i < Dictionaries.length) {
                    Answers.addAll(lookupDict(Dictionaries[i], lang, word, strategy));
                    if (Answers.size()>0) {
                        i=Dictionaries.length;
                    }
                    else {
                        i++;
                    }
                }
            }
        }
        catch (Exception e) {
//            throw new RuntimeException("Error in Lookup Any");
			System.out.println("Error in Lookup Any: " + e.toString());
			e.printStackTrace();
			return errorAnswers; 
        }
        return (IAnswer[])Answers.toArray(new IAnswer[0]);
    }

    public Collection lookupDict(Dictionary dict, String lang, String word, int strategy) 
		throws fr.imag.clips.papillon.business.PapillonBusinessException {
		System.out.println("lookupDict user: " + this.getUser());
		Vector theEntries = null;
			//Headword[0] = key
			//Headword[1] = lang
			//Headword[2] = value
			//Headword[3] = strategy
		String[] Headword = new String[4];
		Headword[0] = Volume.CDM_headword;
		Headword[1] = lang;
		Headword[2] = word;
		Headword[3] = IQuery.QueryBuilderStrategy[IQuery.STRATEGY_EXACT+1];
		Vector myVector = new Vector();
		myVector.add(Headword);
		
            return DictionariesFactory.getDictionaryEntriesCollection(dict,
                                                                     lang,
																	 null,
                                                                     myVector,
                                                                     null,
																	 null,
                                                                     this.getUser(),
																	 0);
    }

    public String authenticate(String login, String password) {
        String userMessage = "User unknown";
        try {
            if (null != login && !login.equals("") &&
                null != password && !password.equals("")) {
                User myUser = UsersFactory.findUserByLogin(login);
                if (null != myUser && !myUser.isEmpty()) {
                    if (myUser.HasCorrectPassword(password)) {
                        setUser(myUser);
                        userMessage = "User authenticated";
                    } else {
                        userMessage = "Wrong password";
                    }
                }
            }
        }
        catch (Exception ex) {
            userMessage = ex.toString();
        }

        return userMessage;
    }
	
	protected Object clone() {
		return new DictEngine(enhydraApp);
	}

	public IDictEngine copy() {
		return (IDictEngine)this.clone();
	}

    private void setUser(User aUser) {
        theUser = aUser;
    }
    private User getUser() {
        return theUser;
    }
}

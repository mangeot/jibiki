//
//  ParseVolume.java
//  PapillonStable
//
//  Created by Mathieu MANGEOT on Mon Sep 29 2003.
//  Copyright (c) 2003 __MyCompanyName__. All rights reserved.
//

package fr.imag.clips.papillon.business.dictionary;


// java.io
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

// java.util
import java.util.StringTokenizer;

// java.net.
import java.net.URL;
import java.net.URLConnection;

//  Imported JAVA API for XML Parsing classes
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

//Dom objects
import org.w3c.dom.Document;
import org.w3c.dom.Node;

// XPath
import org.apache.xpath.XPathAPI;

// internal imports
import fr.imag.clips.papillon.business.PapillonLogger;
import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.business.utility.Utility;

public class ParseVolume {

	// constants
        // constants for Foks
	protected static final int FOKS_TOKENS = 4;
	protected static final String FOKS_DELIMITER = "\t";
	protected static final String FOKS_ENCODING = "EUC-JP";
        protected static final String FOKSEDICT_VOLUME = "FoksEdict_jpn";

	// constants
	protected static final String ENCODING = "encoding";
	protected static final String DEFAULT_ENCODING = "UTF-8";
	protected static final String XMLHEADER = "<?xml version='1.0' encoding='UTF-8' standalone='yes' ?>";
	protected static final String XMLDECLSTART = "<?xml ";
	protected static final String CDM_entry = "e";
	protected static final String CDM_volume = "volume";
	protected static final int MAX_TRY = 5;

        public static int parseFoksVolume (String url) throws PapillonBusinessException {
            return parseFoksVolume(url, FOKS_ENCODING, FOKS_DELIMITER,FOKS_TOKENS);
        }

        public static int parseFoksVolume (String urlString, String encoding, String delimiter, int tokensNb) 
            throws PapillonBusinessException {
  		int entry = 0;
          try {
            java.net.URL url = new java.net.URL(urlString);
            java.net.URLConnection connection = url.openConnection();

	//	FileInputStream file = new FileInputStream(new File(url));
		// throws FileNotFoundException
		InputStreamReader inReader = new InputStreamReader(connection.getInputStream(), encoding);
		// throws UnsupportedEncodingException
		BufferedReader buffer = new BufferedReader(inReader);
		String str = "";
		while (buffer.ready()) {
			str = buffer.readLine();
                        StringTokenizer myTokenizer = new StringTokenizer(str,delimiter);
                        if (myTokenizer.countTokens() == tokensNb) {
                            FoksEntry myEntry = new FoksEntry(myTokenizer.nextToken(),
                            myTokenizer.nextToken(),
                            myTokenizer.nextToken(),
                            myTokenizer.nextToken());
                            if (myEntry != null && !myEntry.IsEmpty()) {
                                myEntry.save();
                                entry++;
                            }
                            if ((entry % 1000) == 0) {
                                PapillonLogger.writeDebugMsg("Foks Volume: " + entry + " entries parsed");
                            }
                        }
                }
                buffer.close();
                PapillonLogger.writeDebugMsg("Foks Volume Parsed, " + entry + " entries added!");
		} catch (FileNotFoundException exp) {
			throw new PapillonBusinessException("ParseVolume.parseFoksVolume, error FileNotFoundException: " + urlString);

		} catch (IOException exp) {
                    throw new PapillonBusinessException("ParseVolume.parseFoksVolume, error IOException");
		}
		return entry;
	}

	public static void parseVolume (String url) {
		String xmlHeader = getXMLHeader(url);
		String encoding = getEncoding(xmlHeader);
		parseEntries(url,encoding);
	}

	protected static String getXMLHeader(String url) {
		String res = XMLHEADER;
		try {
			FileInputStream file = new FileInputStream(url);
			// throws FileNotFoundException
			InputStreamReader inReader = new InputStreamReader(file, DEFAULT_ENCODING);
			// throws UnsupportedEncodingException
			BufferedReader buffer = new BufferedReader(inReader);
			String str = "";
			int countTry = 0;
			while (buffer.ready() && (countTry <=MAX_TRY)) {
				str = buffer.readLine();
				countTry++;
				if (str.indexOf(XMLDECLSTART)>=0) {
					res = str;
					break;
				}
				if (str.indexOf(CDM_entry)>=0) {
					break;
				}
			}
		} catch (FileNotFoundException exp) {
			System.out.println("FileNotFoundException: " + url);

		} catch (IOException exp) {
			System.out.println("IOException");
		}
		return res;
	}

	protected static String getEncoding(String XMLHeader) {
		String res = "UTF-8";
		int start = XMLHeader.indexOf(ENCODING);
		if (start>0) {
			// looking for the string encoding
			String tmpString = XMLHeader.substring(start+ENCODING.length());
			tmpString = tmpString.trim();
			// looking for the '='
			start = tmpString.indexOf('=');
			if (start>=0) {
				tmpString = tmpString.substring(start+1);
				tmpString = tmpString.trim();
				// cut the quotes
				if (tmpString.length()>2) {
					String quote = tmpString.substring(0,1);
					tmpString =  tmpString.substring(1);
					int end = tmpString.indexOf(quote);
					if (end>0) {
						res = tmpString.substring(0,end);
					}
				}
			}
		}
		return res;
	}

	protected static String parseEntries(String url, String encoding) {
		PapillonLogger.writeDebugMsg("parseEntries, encoding: [" + encoding + "]");
		try {
			FileInputStream file = new FileInputStream(url);
			// throws FileNotFoundException
			InputStreamReader inReader = new InputStreamReader(file, encoding);
			// throws UnsupportedEncodingException
			BufferedReader buffer = new BufferedReader(inReader);
			StringBuffer xmlHeaderBuffer = new StringBuffer();
			String str = "";
			int entry = -1;
			while (buffer.ready() && entry <0) {
				str = buffer.readLine();
				entry = str.indexOf("<" + CDM_entry);
				if (entry >=0) {
					if (entry>0) {
						xmlHeaderBuffer.append(str.substring(0,entry));
						str = str.substring(entry);
					}
				}
				else {
					xmlHeaderBuffer.append(str);
				}
			}
			int countEntries = 0;
			String xmlHeader = xmlHeaderBuffer.toString();
			StringBuffer entryBuffer = new StringBuffer(xmlHeader);
			StringBuffer xmlFooter= new StringBuffer("</" + CDM_volume + ">");
			while (buffer.ready()) {
				entry = str.indexOf("<" + CDM_entry);
				while (entry>=0) {
					if (entry>0) {
						entryBuffer.append(str.substring(0,entry));
						str = str.substring(entry);
					}
					if (entryBuffer.length()>xmlHeaderBuffer.length()) {
						countEntries += parseEntry(entryBuffer.append(xmlFooter));
						entryBuffer = new StringBuffer(xmlHeader);
					}
					entry = str.indexOf("<" + CDM_entry,entry+CDM_entry.length()+1);
				}
				entryBuffer.append(str);
				str = buffer.readLine();
			}
			countEntries += parseEntry(entryBuffer.append(xmlFooter));
			PapillonLogger.writeDebugMsg("volume parsed, " + countEntries + " entries added.");
			buffer.close();
		} catch (FileNotFoundException exp) {
			System.out.println("FileNotFoundException");

		} catch (IOException exp) {
			System.out.println("IOException");
		}
		return "OK";
	}

	protected static int parseEntry(StringBuffer entryBuffer) {
		return parseEntry(entryBuffer.toString());
	}

		protected static int parseEntry(String entryString) {
			int result=0;
			PapillonLogger.writeDebugMsg("Parse entry [" + entryString + "]");
		try {
			Document myDoc = Utility.buildDOMTree(entryString);
			//	Node myEntry = XPathAPI.selectSingleNode(myDoc,"/volume/e");
   //	Node myHw = XPathAPI.selectSingleNode(myEntry,"hw");
			if (myDoc!=null) {
				String headword = XPathAPI.eval(myDoc,"/volume/e/hw/text()").str();
				PapillonLogger.writeDebugMsg("Parse entry, headword [" + headword + "]");
				if (headword!=null && !headword.equals("")) {
					result=1;
				}
			}
		}
		catch (javax.xml.transform.TransformerException e) {
			PapillonLogger.writeDebugMsg("javax.xml.transform.TransformerException: " + e);
		}
		return result;
	}
	//TODO:
	// pour booster les perfs, utiliser un StringBuffer plutôt qu'une String
	//
}

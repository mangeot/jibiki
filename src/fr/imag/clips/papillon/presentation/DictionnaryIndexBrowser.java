package fr.imag.clips.papillon.presentation;

import org.w3c.dom.Node;
import org.enhydra.xml.xhtml.dom.XHTMLAnchorElement;
import org.enhydra.xml.xhtml.dom.XHTMLLIElement;
import org.enhydra.xml.xhtml.dom.XHTMLUListElement;
import org.enhydra.xml.xhtml.dom.XHTMLSpanElement;
import fr.imag.clips.papillon.Papillon;
import fr.imag.clips.papillon.business.dictionary.HeadwordListQuery;
import fr.imag.clips.papillon.business.locales.LanguageIndexKeys;
import fr.imag.clips.papillon.presentation.xhtml.orig.DictionaryIndexXHTML;

import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;

/**
 * Created by IntelliJ IDEA.
 * User: serasset
 * Date: Aug 28, 2007
 * Time: 5:10:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class DictionnaryIndexBrowser extends PapillonBasePO {

    private static String URL_0 = "Home.po?FACET.0=cdm-headword&OPERATOR.0=2&FACETVALUE.0=";
    private static final String URL_1 = "&SOURCE.0=";
    private static final String URL_2 ="&TARGETS=*ALL*&XSL=Default&NB_RESULT_PER_PAGE=5&OFFSET=&action=lookup";

    protected boolean loggedInUserRequired() {
        return false;
    }

    protected boolean userMayUseThisPO() {
        return true;
    }


    protected int getCurrentSection() {
        return NO_SECTION;
    }

    public Node getContent()
            throws Exception {
        // Retrieve parameters
        String volumeName = myGetParameter("VOLUME");
        String language = myGetParameter("LANG");
        String key = myGetParameter("KEY");
        String sampleSize = myGetParameter("SAMPLESIZE");
        int limit = 0;
        if (null != sampleSize) {
            try {
                limit = Integer.parseInt(sampleSize);
            } catch (NumberFormatException e) {
                // Do nothing
            }
        }

        DictionaryIndexXHTML content = (DictionaryIndexXHTML) MultilingualXHtmlTemplateFactory.createTemplate("DictionaryIndexXHTML", this.getComms(), this.getSessionData());

        Node currentCell = content.getElementLeftColumn();
        Node keySummary = content.getElementKeySummary();
        XHTMLAnchorElement anchor = content.getElementHeadwordAnchor();
        XHTMLSpanElement hwText = content.getElementHeadwordText();
        XHTMLLIElement li = content.getElementHeadwordListItem();
        XHTMLUListElement ul = content.getElementHeadwordList();

        anchor.removeAttribute("id");
        hwText.removeAttribute("id");
        li.removeAttribute("id");
        ul.removeAttribute("id");

        currentCell.removeChild(keySummary);
        ul.removeChild(li);

        LanguageIndexKeys indexKeys = new LanguageIndexKeys(language);
        String[] keys = indexKeys.getKeys();
        for (int i = 0; i < keys.length; i++) {
            key = keys[i];
            Collection headwords = HeadwordListQuery.getHeadwordListForLanguageIgnoringAccents(language, key, limit);
            // Set the key
            content.setTextKeyTitle(key.toUpperCase());
            for (Iterator it = headwords.iterator(); it.hasNext();) {
                String hw = (String) it.next();
                // System.out.println(hw);
                content.setTextHeadwordText(hw);
                anchor.setHref(URL_0 + myUrlEncode(hw) + URL_1 + language + URL_2);
                ul.appendChild(content.importNode(li.cloneNode(true), true));
            }

            Node newSection = content.importNode(keySummary.cloneNode(true), true);
            currentCell.appendChild(newSection);
            // Clean up the cell
            while (ul.hasChildNodes()) {
                ul.removeChild(ul.getFirstChild());
            }
        }
        return content.getElementDictionaryIndexContent();
    }


}

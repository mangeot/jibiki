// List of XmlHttpObject
var xmlHttpList


// Get select element depending on cdm element (Ajax function)
// view function stateChanged
function getSelector(value, name) {
    // Identify the element: Search number with regular expression
    var regexp = /.*\.(.*)/i;
    var result = regexp.exec(name);

    // Make ID and name value
    var ValueFieldId = 'ValueField.' + result[1];
    var FACETVALUEName = 'FACETVALUE.' + result[1];
    var container = document.getElementById('tmp');
    var oldNode = document.getElementById(ValueFieldId);

    if (value == "cdm-modification-author"
            || value == "cdm-contribution-author"
            || value == "cdm-contribution-status"
            || value == "lexalp-domain") {

        var url = "AdvancedQueryFormAjax.po?id=" + result[1] + "&value=" + value;
        $.get(url, function(data, textStatus) {
            // Create the node A in tmp node
            var container = document.getElementById('tmp');
            container.innerHTML = data;
            var newNode = document.getElementById('selectNode');

            // Make ID and name value
            var number = newNode.getAttribute('name');
            var ValueFieldId = 'ValueField.' + number;
            var FACETVALUEName = 'FACETVALUE.' + number

            // Replace node B by node A
            var oldNode = document.getElementById(ValueFieldId);
            var oldValue = getOldValue(oldNode);

            var parentNode = oldNode.parentNode;
            parentNode.replaceChild(newNode, oldNode);

            //
            newNode.id = ValueFieldId;
            newNode.setAttribute('name', FACETVALUEName);
            setOldValue(newNode, oldValue);
        });

    } else {


            // Create the node A in tmp node
            switch (value)
                    {
                case "cdm-pos":
                    container.innerHTML = "<select id=\"ValueFieldTMP\" name=\"FACETVALUETMP\">"
                            + "<option value=\"n.\"> n. </option>"
                            + "<option value=\"n.m.\"> n.m. </option>"
                            + "<option value=\"n.m. sg.\"> n.m. sg. </option>"
                            + "<option value=\"n.m. pl.\"> n.m. pl. </option>"
                            + "<option value=\"n.m. dual.\"> n.m. dual. </option>"
                            + "<option value=\"n.f.\"> n.f. </option>"
                            + "<option value=\"n.f. sg.\"> n.f. sg. </option>"
                            + "<option value=\"n.f. pl.\"> n.f. pl. </option>"
                            + "<option value=\"n.f. dual.\"> n.f. dual. </option>"
                            + "<option value=\"n.n.\"> n.n. </option>"
                            + "<option value=\"n.n. sg.\"> n.n. sg. </option>"
                            + "<option value=\"n.n. pl.\"> n.n. pl. </option>"
                            + "<option value=\"n.n. dual.\"> n.n. dual. </option>"
                            + "<option value=\"v.\"> v. </option>"
                            + "<option value=\"adj.\"> adj. </option>"
                            + "<option value=\"adv.\"> adv. </option>"
                            + "<option value=\"UNKNOWN\"> UNKNOWN </option>"
                            + "</select>";
                    break

                case "lexalp-legal-system":
                    container.innerHTML = "<select id=\"ValueFieldTMP\" name=\"FACETVALUETMP\">"
                            + "<option value=\"AC\">Alpine Convention</option>"
                            + "<option value=\"EU\">EU</option>"
                            + "<option value=\"INT\">INT</option>"
                            + "<option value=\"IT\">Italia</option>"
                            + "<option value=\"FR\">France</option>"
                            + "<option value=\"DE\">Germany</option>"
                            + "<option value=\"CH\">Switzerland</option>"
                            + "<option value=\"SL\">Slovenia</option>"
                            + "<option value=\"AT\">Austria</option>"
                            + "<option value=\"UNKNOWN\"> UNKNOWN </option>"
                            + "</select>";
                    break
                // FIXME: This should be localized to the user language...
                case "lexalp-usage":
                    container.innerHTML = "<select id=\"ValueFieldTMP\" name=\"FACETVALUETMP\">"
                            + "<option value=\"AC\">Alpine Convention</option>"
                            + "<option value=\"EU\">EU</option>"
                            + "<option value=\"INT\">INT</option>"
                            + "<option value=\"IT\">Italia</option>"
                            + "<option value=\"FVG\" class=\"option1\" >Friuli Venezia Giulia</option>"
                            + "<option value=\"FR\">France</option>"
                            + "<option value=\"DE\">Germany</option>"
                            + "<option value=\"BAY\" class=\"option1\" >Bayern</option>"
                            + "<option value=\"CH\">Switzerland</option>"
                            + "<option value=\"SL\">Slovenia</option>"
                            + "<option value=\"AT\">Austria</option>"
                            + "<option value=\"K\" class=\"option1\" >Kärnten</option>"
                            + "<option value=\"N\" class=\"option1\" >Niederösterreich</option>"
                            + "<option value=\"O\" class=\"option1\" >Oberösterreich</option>"
                            + "<option value=\"S\" class=\"option1\" >Salzburg</option>"
                            + "<option value=\"St\" class=\"option1\" >Steiermark</option>"
                            + "<option value=\"T\" class=\"option1\" >Tirol</option>"
                            + "<option value=\"V\" class=\"option1\" >Vorarlberg</option>"
                            + "<option value=\"UNKNOWN\">UNKNOWN</option>"
                            + "</select>";
                    break

                case "lexalp-harmonising-status":
                    container.innerHTML = "<select id=\"ValueFieldTMP\" name=\"FACETVALUETMP\">"
                            + "<option value=\"HARMONISED\"> HARMONISED </option>"
                            + "<option value=\"REJECTED\"> REJECTED </option>"
                            + "<option value=\"UNKNOWN\"> UNKNOWN </option>"
                            + "</select>";
                    break

                case "lexalp-process-status":
                    container.innerHTML = "<select id=\"ValueFieldTMP\" name=\"FACETVALUETMP\">"
                            + "<option value=\"UNPROCESSED\"> UNPROCESSED </option>"
                            + "<option value=\"PROVISIONALLY_PROCESSED\"> PROVISIONALLY_PROCESSED </option>"
                            + "<option value=\"FINALISED\"> FINALISED </option>"
                            + "<option value=\"NOT_TO_BE_HARMONISED\"> NOT TO BE HARMONISED </option>"
                            + "</select>";
                    break
                case "lexalp-phraseological-unit" :
                    container.innerHTML = "<select id=\"ValueFieldTMP\" name=\"FACETVALUETMP\">"
                            + "<option value=\"true\"> checked </option>"
                            + "<option value=\"false\"> unchecked </option>"
                            + "</select>";
                    break
                default:
                    container.innerHTML = "<input type=\"text\" id=\"ValueFieldTMP\" name=\"FACETVALUETMP\" size=\"20\" maxlength=\"128\"\/>";
            }
            var newNode = document.getElementById('ValueFieldTMP');
            var oldValue = getOldValue(oldNode);

            // Replace node B by node A
            var parentNode = oldNode.parentNode;

            parentNode.replaceChild(newNode, oldNode);
            setOldValue(newNode, oldValue);
            
            //
            newNode.id = ValueFieldId;
            newNode.setAttribute('name', FACETVALUEName);
    }
}


function getOldValue(node) {
    var switcher = node.tagName +
                   (node.tagName == 'INPUT' ? '/' + node.type : '');
    var res;
    switch (switcher) {
        case 'TEXTAREA':
        case 'INPUT/text':
            res = node.value;
            break;
        case 'OPTION':
            while (node && node.tagName != 'SELECT') {
                node = node.parentNode;
            }
        case 'SELECT':
            var n = node.selectedIndex;
            res = node[n].value;
            break;
    }
    return res;
}

function setOldValue(node, value) {
    var switcher = node.tagName +
                   (node.tagName == 'INPUT' ? '/' + node.type : '');
    var res;
    switch (switcher) {
        case 'TEXTAREA':
        case 'INPUT/text':
            node.value = value;
            break;
        case 'OPTION':
            while (node && node.tagName != 'SELECT') {
                node = node.parentNode;
            }
        case 'SELECT':
            for (var i = 0; i < node.length; ++i)
                if (node[i].value == value)
                    node.selectedIndex = i;
            break;
    }
}

//
function addOrRemoveCriterion(caller, action) {
    document.getElementById('Action').value = action + caller;
    document.getElementById("SearchForm").submit();
}

// Hide or show source lang according to the tableData element
function hideOrNotSourceLang(value, name) {
    // Search number with regular expression
    var regexp = /.*\.(.*)/i;
    var result = regexp.exec(name);
    
    // Search if source lang node must hide or not in the tableData
    var table = document.getElementById('tableShowHideElement');
    var tableRows = table.rows;
    var i = 0;
    while (i < tableRows.length) {
        var thisRow = tableRows[i];
        if (thisRow.cells[0].childNodes[0].nodeValue == value) {
            document.getElementById('SourceLang.' + result[1]).parentNode.style.visibility = "hidden";
            document.getElementById('SourceLang.' + result[1]).value = "All";
            i = tableRows.length;
        } else {
            document.getElementById('SourceLang.' + result[1]).parentNode.style.visibility = "visible";
        }
        i++;
    }
}

// Hide element
function hide(id) {
    document.getElementById(id).style.visibility = "hidden";
}

// Show element
function show(id) {
    document.getElementById(id).style.visibility = "visible";
}


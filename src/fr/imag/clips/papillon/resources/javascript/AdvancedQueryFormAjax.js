// List of XmlHttpObject
var xmlHttpList


// Get select element depending on cdm element (Ajax function)
// view function stateChanged
function getSelector(value, name) {
    
    if (value=="cdm-pos" 
        || value=="lexalp-legal-system"
        || value=="lexalp-domain"
        || value=="lexalp-usage"
        || value=="cdm-modification-author"
        || value=="cdm-contribution-author"
        || value=="lexalp-harmonising-status"
        || value=="lexalp-process-status"
        || value=="cdm-contribution-status") {
        
        // Search number with regular expression
        var regexp = /.*\.(.*)/i;
        var result = regexp.exec(name);
        
        // Initialize xmlHttpList 
        var i = 0;
        if (xmlHttpList==null) {
            xmlHttpList=new Array()
        } else {
            i = xmlHttpList.length;
        }
        
        // Get XmlHttpObject
        xmlHttpList[i]=GetXmlHttpObject()
        if (xmlHttpList[i]==null) {
            alert ("Your browser does not support AJAX!");
            return;
        } 
        
        // Query to server
        var url="AdvancedQueryFormAjax.po?id=" + result[1] + "&value=" + value;
        xmlHttpList[i].onreadystatechange=stateChanged;
        xmlHttpList[i].open("GET", url, true);
        xmlHttpList[i].send(null);
        
    } else {
        
        // Search number with regular expression
        var regexp = /.*\.(.*)/i;
        var result = regexp.exec(name);
        
        // Create the node A in tmp node
        var container = document.getElementById('tmp');
        container.innerHTML = "<input type=\"text\" id=\"ValueFieldTMP\" name=\"FACETVALUETMP\" size=\"20\" maxlength=\"128\"\/>";
        var newNode = document.getElementById('ValueFieldTMP');
        
        // Make ID and name value
        var ValueFieldId = 'ValueField.' + result[1];
        var FACETVALUEName = 'FACETVALUE.' + result[1];
            
        // Replace node B by node A
        var oldNode = document.getElementById(ValueFieldId);
        var parentNode = oldNode.parentNode;
        parentNode.replaceChild(newNode, oldNode);
        
        //
        newNode.id = ValueFieldId;
        newNode.setAttribute('name', FACETVALUEName);
    }
}

// Get select element depending on cdm element (Ajax function)
// view function getSelector
function stateChanged() { 
    
    //
    for (var i=0; i<xmlHttpList.length; i=i+1) {
        if (xmlHttpList[i].readyState==4) {
            
            // Create the node A in tmp node
            var container = document.getElementById('tmp');
            container.innerHTML = xmlHttpList[i].responseText;
            var newNode = document.getElementById('selectNode');
            // FIXME: Normally, it is possible to get XML response (see below). But error for the moment
            //var newNode = xmlHttpList[i].responseXML.getElementById('cdmTest');
            
            // Make ID and name value
            var number = newNode.getAttribute('name');
            var ValueFieldId = 'ValueField.' + number;
            var FACETVALUEName = 'FACETVALUE.' + number
            
            // Replace node B by node A
            var oldNode = document.getElementById(ValueFieldId);
            var parentNode = oldNode.parentNode;
            parentNode.replaceChild(newNode, oldNode);

            //
            newNode.id = ValueFieldId;
            newNode.setAttribute('name', FACETVALUEName);
        }
    }
}

// Ajax function
function GetXmlHttpObject()
{
    var xmlHttp=null;
    try {
        // Firefox, Opera 8.0+, Safari
        xmlHttp=new XMLHttpRequest();
    
    } catch (e)  {
        // Internet Explorer
        try {
            xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e) {
            xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
        }
    }
    return xmlHttp;
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
    table = document.getElementById('tableShowHideElement');
    var tableRows = table.rows;
    var i = 0;
    while ( i < tableRows.length ) {
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


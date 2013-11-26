<!--
	var limit;
	var load = false; // aucun chargement d'entrée n'est en cours
	var entriesHeight = 0;
 	var nbentries = 0;
 	var lastEntryOffset = 0;
	var lastEntriesSize = 0;
	var entriesSize = 0;
 	var listTop = false;
 	var listBottom = false;

function lookupIndex (parameters, direction) {
	load = true;
	$('.loadmore').show();
		
	//On lance la fonction ajax
	$.ajax({
		   url: 'LookupVolume.po',
		   type: 'get',
		   data: parameters+'&DIRECTION='+direction,
		   dataType: "html",
		   
		   //Succès de la requête
		   success: function(data) {
		   //On masque le loader
		   $('.loadmore').fadeOut(500);
		  // if ($(data).children().length) {
			/* On affiche le résultat s'il n'est pas nul */
			if (direction=='ASC') {
				$('.lookupentry:last').after($(data).children());
				listBottom = ($('.lookupentry').size()-lastEntriesSize<limit);
			}
			else {
				$('.lookupentry:first').before($(data).children());
				listTop = ($('.lookupentry').size()-lastEntriesSize<limit);
				$('#lookupentries').scrollTop(entriesHeight/2);
			}
		   //}
		   //je rajoute un offset
		   if (direction=='ASC' && parameters.indexOf('action=advancedLookup')>=0 && $(data).children().length) {
			var regex = /OFFSET=(\d+)/;
			var matches = parameters.match(regex);
			if (matches) {
				var newOffset = parseInt(matches[1])+limit;
				parameters = parameters.replace(regex,"OFFSET="+newOffset);
				$('#QueryString').attr('data-query-string',parameters);
			}
		   }
		   /* On actualise la valeur offset de la dernière entrée */
			lastEntryOffset = $('.lookupentry:last').offset().top - $('.lookupentry:first').offset().top - entriesHeight;
			//On remet la valeur à faux car c'est fini
			load = false;
		   }
		   });
}


$(document).ready(function(){ // Quand le document est complètement chargé
	//on cache le loader
	$('.loadmore').hide();
	$('.loadcontent').hide();
	action = $('#actionJS').val();
	limit = parseInt($('#LIMIT').val(),10);
  	entriesHeight = $('#lookupentries').height();
 	lastEntryOffset = entriesHeight;
 
	$('#lookupentries').scroll(function(){ // On surveille l'évènement scroll
 
		/* Si l'élément offset est en bas de scroll, si aucun chargement 
		n'est en cours, et si toutes les entrées ne sont pas affichées, alors on 
		lance la fonction. */
		var scrollTop = $('#lookupentries').scrollTop();
		if ((scrollTop >= lastEntryOffset || scrollTop < 100) && load==false) {
 
 			var direction = (scrollTop >= lastEntryOffset) ? 'ASC': 'DESC';
 			if ((direction=='ASC' && !listBottom) || (direction=='DESC' && !listTop)) {


			//console.log('load: lastEntryOffset: ' + lastEntryOffset + ' scrollTop: ' +scrollTop + ' listTop: ' +listTop);

			//On récupère le headword du dernier entrée affiché
			var msort = (direction=='ASC') ? $('.lookupentry:last').attr('title') : $('.lookupentry:first').attr('title');
 			lastEntriesSize = $('.lookupentry').size();
			var volume = $('#VOLUME').val();
			var key='cdm-headword';
			if (volume=='Motamot_khm_api') {
				volume='Motamot_khm';
				key='cdm-pronunciation';
			}
							   
			var queryString = (action=='lookupVolume')?'action='+action+'&VOLUME='+volume+'&LIMIT='+limit+'&KEY='+key+'&MSORT='+msort:$('#QueryString').attr('data-query-string');
			if (queryString !== undefined) {
				lookupIndex(queryString, direction);
			}
			}
		}
	});
});


function queryPrefixVolume(word, volume) {
			//On lance la fonction ajax
			load = true;
			$('#lookupentries').children().remove();
	var halflimit = Math.floor(limit/2);
	var key='cdm-headword';
	if (volume=='Motamot_khm_api') {
		volume='Motamot_khm';
		key='cdm-pronunciation';
		word = replace_api(word);
	}
	//alert(volume+' '+ key + ' ' + word);
			$.ajax({
				url: 'LookupVolume.po',
				type: 'get',
				data: 'action=lookupVolume&VOLUME='+volume+'&LIMIT='+halflimit+'&KEY='+key+'&WORD='+word+'&DIRECTION=DESC',
				dataType: "html",
 
				//Succès de la requête
				success: function(data) {
 					/* On affiche le résultat après la dernière entrée */
				   if ($('.lookupentry').length) {
					$('.lookupentry:first').before($(data).children());
				   /* On actualise la valeur offset de la dernière entrée */
				   lastEntryOffset = $('.lookupentry:last').offset().top - $('.lookupentry:first').offset().top - entriesHeight;
				   //On remet la valeur à faux car c'est fini
				   $('#lookupentries').scrollTop((entriesHeight+lastEntryOffset-400) /2);
				   load = false;
				   }
				   else {
					$('#lookupentries').append($(data).children());
				   }
				}
			});
		$.ajax({
		   url: 'LookupVolume.po',
		   type: 'get',
		   data: 'action=lookupVolume&VOLUME='+volume+'&LIMIT='+halflimit+'&KEY='+key+'&WORD='+word+'&DIRECTION=ASC&STRATEGY=>%3D',
		   dataType: "html",
		   
		   //Succès de la requête
		   success: function(data) {
		   /* On affiche le résultat après la dernière entrée */
			if ($('.lookupentry').length) {
			   $('.lookupentry:last').after($(data).children());
			   /* On actualise la valeur offset de la dernière entrée */
			   lastEntryOffset = $('.lookupentry:last').offset().top - $('.lookupentry:first').offset().top - entriesHeight;
			   //On remet la valeur à faux car c'est fini
			   $('#lookupentries').scrollTop((entriesHeight+lastEntryOffset-400) /2);
			   load = false;
			   }
			   else {
			   $('#lookupentries').append($(data).children());
			   }
		   }
		   });
}


function lookupVolume (parameters) {
			//On lance la fonction ajax
			load = true;
			$('.loadcontent').show();
			$('#lookupcontent').children().remove();
			$('.lookupentry').css('font-weight', 'normal');

			$.ajax({
				url: 'LookupVolume.po',
				type: 'get',
				data: 'action=queryHandle&'+parameters,
 
				//Succès de la requête
				success: function(data) {
 
					//On masque le loader
					$('.loadcontent').fadeOut(500);
					// On affiche le résultat
					//$('#content').text('LookupVolume.po' + parameters);
					$('#lookupcontent').append($(data).children());
					load = false;
				}
			});
	}


function queryOneEntry (entry, volume) {
	//On lance la fonction ajax
	load = true;
	$('.loadcontent').show();
	$('#lookupcontent').children().remove();
	$('.lookupentry').css('font-weight', 'normal');

	var key='cdm-headword';
	if (volume=='Motamot_khm_api') {
		volume='Motamot_khm';
		key='cdm-pronunciation';
		entry = replace_api(entry);
	}	
	
	$.ajax({
		   url: 'LookupVolume.po',
		   type: 'get',
		   data: 'action=queryOneEntry&VOLUME='+volume+'&ENTRY='+entry + '&KEY=' + key,
		   
		   //Succès de la requête
		   success: function(data) {
		   
		   //On masque le loader
		   $('.loadcontent').fadeOut(500);
		   // On affiche le résultat
		   //$('#content').text('LookupVolume.po' + parameters);
		   $('#lookupcontent').append($(data).children());
		   load = false;
		   }
		   });
}

function replace_api(string) {
	string.replace('a'+'̄','ā');
	string.replace('e'+'̄','ē');
	string.replace('i'+'̄','ī');
	string.replace('o'+'̄','ō');
	string.replace('u'+'̄','ū');
	return string;
}

// -->
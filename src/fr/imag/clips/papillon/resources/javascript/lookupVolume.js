<!--
	var limit;
	var load = false; // aucun chargement d'entrée n'est en cours
	var entriesHeight = 0;
 	var nbentries = 0;
 	var lastEntryOffset = 0;
 	var entriesSize = 0;
 	var listTop = false;
 	var listBottom = false;

$(document).ready(function(){ // Quand le document est complètement chargé
	//on cache le loader
	$('.loadmore').hide();
	$('.loadcontent').hide();
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

			// la valeur passe à vrai, on va charger
			load = true;
			//On affiche un loader
			$('.loadmore').show();

			//console.log('load: lastEntryOffset: ' + lastEntryOffset + ' scrollTop: ' +scrollTop + ' listTop: ' +listTop);

			//On récupère le headword du dernier entrée affiché
			var msort = (direction=='ASC') ? $('.lookupentry:last').attr('title') : $('.lookupentry:first').attr('title');
 			var lastEntriesSize = $('.lookupentry').size();
			var volume = $('#VOLUME').val();
			var key='cdm-headword';
			if (volume=='Motamot_khm_api') {
				volume='Motamot_khm';
				key='cdm-pronunciation';
			}
							   
			//On lance la fonction ajax
			$.ajax({
				url: 'LookupVolume.po',
				type: 'get',
				data: 'VOLUME='+volume+'&LIMIT='+limit+'&KEY='+key+'&MSORT='+msort+'&DIRECTION='+direction,
				dataType: "html",
 
				//Succès de la requête
				success: function(data) {
					//On masque le loader
					$('.loadmore').fadeOut(500);
 					/* On affiche le résultat */
					if (direction=='ASC') {
						$('.lookupentry:last').after($(data).children());
						listBottom = ($('.lookupentry').size()-lastEntriesSize<limit);
					}
					else {
						$('.lookupentry:first').before($(data).children());
						listTop = ($('.lookupentry').size()-lastEntriesSize<limit);
 						$('#lookupentries').scrollTop(entriesHeight/2);
					}
					/* On actualise la valeur offset de la dernière entrée */
 					lastEntryOffset = $('.lookupentry:last').offset().top - $('.lookupentry:first').offset().top - entriesHeight;
					//On remet la valeur à faux car c'est fini
					load = false;
				}
			});
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
				data: 'VOLUME='+volume+'&LIMIT='+halflimit+'&KEY='+key+'&WORD='+word+'&DIRECTION=DESC',
				dataType: "html",
 
				//Succès de la requête
				success: function(data) {
 					/* On affiche le résultat après
					le dernier commentaire */
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
		   data: 'VOLUME='+volume+'&LIMIT='+halflimit+'&KEY='+key+'&WORD='+word+'&DIRECTION=ASC&STRATEGY=>%3D',
		   //data: 'VOLUME='+volume+'&LIMIT='+halflimit+'&KEY='+key+'&WORD='+word+'&DIRECTION=ASC',
		   dataType: "html",
		   
		   //Succès de la requête
		   success: function(data) {
		   /* On affiche le résultat après
			le dernier commentaire */
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
				data: parameters,
 
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
		   data: 'VOLUME='+volume+'&ENTRY='+entry + '&KEY=' + key,
		   
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
$(document).ready(function() {
	item_especie_card = function( item, i ) {

		/*$.ajaxSetup({
			async: false
		});

		$.getJSON("http://api.flickr.com/services/feeds/photos_public.gne?tags="+ item.nomeCientifico +"&format=json&jsoncallback=?",function(data) {
        	if (data.items.length > 0) {
	        	var img = data.items[0];
	        	// $("<img/>").attr("src", img.media.m);
	        	// window.console.log( img.media.m );
	        	imgs[ i ] = img.media.m;
	        }
        });

        $.ajaxSetup({
			async: true
		});*/

		var especieItem;

		if (item.img) especieItem = "<div for='especieItem" + i + "' class='item-img mdl-cell mdl-cell--2-col mdl-cell--2-col-phone'><img src='" + item.img + "' width='100px' alt='...' class='img-circle-clip'></div>";
		else especieItem = "<div class='section__circle-container mdl-cell mdl-cell--2-col mdl-cell--1-col-phone'><div class='section__circle-container__circle mdl-color--primary'></div></div>";

		  especieItem += "<div id='especieItem" + i + "' class='item-text section__text mdl-cell mdl-cell--10-col-desktop mdl-cell--6-col-tablet mdl-cell--3-col-phone' style='margin-left: -10px;'>";

          especieItem += "<h5><a style='text-decoration: none;color: #000;' href='/especieDetalhes.html?nomeCientifico=" + item.nomeCientifico + "'>" + item.nomeCientifico + " (" + item.especificacoes.nomePopular + ")</a></h5>";

          especieItem += "<span>A classe e o gênero dessa espécie " + item.especificacoes.tipo.toLowerCase() + " é <em>" + item.especificacoes.classe + "</em> e <em>" + item.especificacoes.genero + " </em>, respectivamente. Faz parte da família <em>" + item.especificacoes.familia + "</em>. ";

          if ( item.especificacoes.exotica ) especieItem += "É considerada uma espécie <em>exótica</em>. ";

          especieItem += "O autor (ou a autora) desta espécie é <a href='especies.html?nomeautor="+ item.especificacoes.nomeAutor +"'>" + item.especificacoes.nomeAutor + "</a>.</span>";

        especieItem += "</div>";

	    return especieItem;

	};


	location.queryObject = {};
	location.search.substr(1).split("&").forEach(function(part) {
		location.queryObject[part.split("=")[0]] = decodeURIComponent(part.split("=")[1]);
	});
});


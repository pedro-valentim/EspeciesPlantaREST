$(document).ready(function() {
	item_especie_card = function( item ) {

	  var especieItem = "<div class='section__circle-container mdl-cell mdl-cell--1-col mdl-cell--1-col-phone'><div class='section__circle-container__circle mdl-color--primary'></div></div>";

	        especieItem += "<div class='section__text mdl-cell mdl-cell--11-col-desktop mdl-cell--6-col-tablet mdl-cell--3-col-phone' style='padding: 10px;'>";

	          especieItem += "<h5>" + item.nomeCientifico + " (" + item.especificacoes.nomePopular + ")</h5>";

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


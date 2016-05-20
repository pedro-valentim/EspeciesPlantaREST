import org.json.JSONException;

import spark.Spark;

public class Test {
	
	static Model model = new Model();
	
	public static void main(String[] args) throws JSONException{
		
		Spark.staticFileLocation("/public");
				
		REST controller = new REST(model);
				
		controller.especieGetPostPutDelete();
		controller.getEspecieByEspecificacoes();
				
		
	}
	
	public static void initializeModel(){
		
		Especie especie;
		Especificacoes espec;
		
		especie = new Especie();
		espec = new Especificacoes();
		
		espec.setClasse("Flora");
		espec.setExotica(false);
		espec.setGenero("Bauhinia");
		espec.setFamilia("Fabaceae");
		espec.setNomeAutor("Link");
		espec.setNomePopular("Pata de Vaca");
		espec.setTipo(Tipo.Arborea);
		
		especie.setNomeCientifico("Bauhinia forficata");
		especie.setEspecie("forficata");
		especie.setEspec(espec);
		
		model.addEspecie(especie);
		
		especie = new Especie();
		espec = new Especificacoes();
		
		espec.setClasse("Flora");
		espec.setExotica(false);
		espec.setGenero("Hymenaea");
		espec.setFamilia("Fabaceae");
		espec.setNomeAutor("L.");
		espec.setNomePopular("Jatobá");
		espec.setTipo(Tipo.Arborea);
		
		especie.setNomeCientifico("Hymenaea courbaril");
		especie.setEspecie("courbaril");
		especie.setEspec(espec);
		
		model.addEspecie(especie);
		
		especie = new Especie();
		espec = new Especificacoes();
		
		espec.setClasse("Flora");
		espec.setExotica(false);
		espec.setGenero("Tabebuia");
		espec.setFamilia("Bignoniaceae");
		espec.setNomeAutor("(Ridl.) Sandwith");
		espec.setNomePopular("Ipê Branco");
		espec.setTipo(Tipo.Arborea);
		
		especie.setNomeCientifico("Tabebuia roseoalba");
		especie.setEspecie("roseoalba");
		especie.setEspec(espec);
		
		model.addEspecie(especie);
		
		especie = new Especie();
		espec = new Especificacoes();
		
		espec.setClasse("Flora");
		espec.setExotica(false);
		espec.setGenero("Joannesia");
		espec.setFamilia("Euphorbiaceae");
		espec.setNomeAutor("Vell.");
		espec.setNomePopular("Boleira");
		espec.setTipo(Tipo.Arborea);
		
		especie.setNomeCientifico("Joannesia princeps");
		especie.setEspecie("princeps");
		especie.setEspec(espec);
		
		model.addEspecie(especie);
		
		especie = new Especie();
		espec = new Especificacoes();
		
		espec.setClasse("Flora");
		espec.setExotica(false);
		espec.setGenero("Ceiba");
		espec.setFamilia("Malvaceae");
		espec.setNomeAutor("(A.St.-Hil.) Ravenna");
		espec.setNomePopular("Paineira");
		espec.setTipo(Tipo.Arborea);
		
		especie.setNomeCientifico("Ceiba speciosa");
		especie.setEspecie("speciosa");
		especie.setEspec(espec);
		
		model.addEspecie(especie);
	
	}
	
}

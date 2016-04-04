import static spark.Spark.get;

import java.util.List;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import spark.Request;
import spark.Response;
import spark.Route;


public class REST{
	
	private Model model;
	
	
	public REST(Model store){
		this.model = store;
	}
	
	public void getEspecieNomeCientifico(){
		
		get("/especie/:nomecientifico", new Route() {
	         @Override
	         public Object handle(Request request, Response response) {
	        	
	        	response.header("Access-Control-Allow-Origin", "*");
	        	 
	            String nomeCientifico = request.params(":nomecientifico");
	            
	            try {
	            	
	            	nomeCientifico = nomeCientifico.replaceAll("%20", " ");
	            	
	            	Especie especie = model.procuraEspeciePorNomeCientifico(nomeCientifico);
	            	
	            	JSONArray jsonResult = new JSONArray();
	         	    JSONObject jsonObj = new JSONObject();

	         	    jsonObj.put("nomeCientifico", especie.getNomeCientifico());
	         	    jsonObj.put("especie", especie.getEspecie());
	         	    jsonObj.put("img", especie.getImg());
	         	    jsonObj.put("nomePopular", especie.getEspec().getNomePopular());
	         	    jsonObj.put("exotica", especie.getEspec().getExotica());
	         	    jsonObj.put("classe", especie.getEspec().getClasse());
	         	    jsonObj.put("familia", especie.getEspec().getFamilia());
	         	    jsonObj.put("genero", especie.getEspec().getGenero());
	         	    jsonObj.put("nomeAutor", especie.getEspec().getNomeAutor());
	         	    jsonObj.put("tipo", especie.getEspec().getTipo());
	        		
	             	jsonResult.put(jsonObj);
	             	
	             	return jsonResult;
	             	
	        		} catch (JSONException e) {
	        				
	        			e.printStackTrace();
	        		}
	         	    	
	
	     	    return null;
	     	     
	         }
	         
	      });

	}
	
	public void getEspecieByEspecificacoes(){
		
		get("/especies/especificacoes", new Route() {
			@Override
			public Object handle(Request request, Response response) {
				response.redirect("/especies/especificacoes/");
				return null;
			}
		});
		
		get("/especies/especificacoes/*", new Route() {
	         @Override
	         public Object handle(Request request, Response response) {
	        	
	        	response.header("Access-Control-Allow-Origin", "*"); 
	        		            
	            Especificacoes espec = new Especificacoes();
	            
	            try {
	            	if (request.queryParams("nomepopular") != null)
		            	espec.setNomePopular(java.net.URLDecoder.decode(request.queryParams("nomepopular"), "UTF-8"));
		            
		            if (request.queryParams("exotica") != null)
		            	espec.setExotica(request.queryParams("exotica").equals("sim"));
		            
		            if (request.queryParams("classe") != null)
		            	espec.setClasse(request.queryParams("classe"));
		            
		            if (request.queryParams("familia") != null)
		            	espec.setFamilia(request.queryParams("familia"));
		            
		            if (request.queryParams("genero") != null)
		            	espec.setGenero(request.queryParams("genero"));
		            
		            if (request.queryParams("nomeautor") != null)
		            	espec.setNomeAutor(java.net.URLDecoder.decode(request.queryParams("nomeautor"), "UTF-8"));
		            
	            	if (request.queryParams("tipo") != null) {
	            		espec.setTipo(Tipo.Nenhum);
	            		if (Tipo.valueOf(request.queryParams("tipo")) != null) {
	            			espec.setTipo(Tipo.valueOf(request.queryParams("tipo")));
	            		}
	            	}
	            	
	            } catch(Exception e){
	            }
	            
	            	            	            
	            try {
	            	List<Especie> especies = model.procuraEspeciePorEspecificacoes(espec);
	            	
	            	JSONArray jsonResult = new JSONArray();
	            	
	            	if (request.queryParams("limit") != null)
	            		especies = especies.subList(0, Integer.parseInt(request.queryParams("limit")));
	         	    
	         	    for(Especie especie:especies){
	         	    	JSONObject jsonObj = new JSONObject();
	         	    	JSONObject jsonObj_espec = new JSONObject();
	         	    	
	         	    	jsonObj.put("nomeCientifico", especie.getNomeCientifico());
		         	    jsonObj.put("especie", especie.getEspecie());
		         	    jsonObj.put("img", especie.getImg());
		         	    jsonObj_espec.put("nomePopular", especie.getEspec().getNomePopular());
		         	    jsonObj_espec.put("exotica", especie.getEspec().getExotica());
		         	    jsonObj_espec.put("classe", especie.getEspec().getClasse());
		         	    jsonObj_espec.put("familia", especie.getEspec().getFamilia());
		         	    jsonObj_espec.put("genero", especie.getEspec().getGenero());
		         	    jsonObj_espec.put("nomeAutor", especie.getEspec().getNomeAutor());
		         	    jsonObj_espec.put("tipo", especie.getEspec().getTipo());
		         	    
		         	   jsonObj.put("especificacoes", jsonObj_espec);
		         	    
	         	    	jsonResult.put(jsonObj);
	         	    	
	         	    }

	             	
	             	return jsonResult;
	             	
	        		} catch (JSONException e) {
	        				
	        			e.printStackTrace();
	        		}
	         	    	
	
	     	    return null;
	     	     
	         }
	         
	      });

	         
	}
	
		
}

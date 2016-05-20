
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

import spark.QueryParamsMap;

public class Model{
	
	ObjectContainer especies = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "../especiesFinal.db4o");
	
	public boolean addEspecie(Especie especie){
		try {
			especies.store(especie);
			especies.commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public List<Especie> procuraEspeciePorEspecificacoes(Especificacoes espec){
		
		List<Especie> result = new LinkedList<Especie>();
		
		Query query = this.especies.query();
		query.constrain(Especie.class);
	    ObjectSet<Especie> especies = query.execute();
		
	    for(Especie especie:especies){
	    	
	    	if (espec.getNomePopular() != null && !espec.getNomePopular().equals( especie.getEspec().getNomePopular() ))
	    		continue;
	    	
	    	if (espec.getClasse() != null && !espec.getClasse().equals( especie.getEspec().getClasse() ))
	    		continue;
	    	
	    	if (espec.getFamilia() != null && !espec.getFamilia().equals( especie.getEspec().getFamilia() ))
	    		continue;
	    	
	    	if (espec.getGenero() != null && !espec.getGenero().equals( especie.getEspec().getGenero() ))
	    		continue;
	    	
	    	if (espec.getNomeAutor() != null && !espec.getNomeAutor().equals( especie.getEspec().getNomeAutor() ))
	    		continue;
	    	
	    	if (espec.getTipo() != null && !espec.getTipo().equals( especie.getEspec().getTipo() ))
	    		continue;
	    	
	    	if (espec.getExotica() != null && !espec.getExotica().equals( especie.getEspec().getExotica() ))
	    		continue;
	    	
	    	result.add(especie);
	    
	    }
		
		return result;

		
	}
	
	public Especie procuraEspeciePorNomeCientifico(String nomeCientifico){
		
		Query query = this.especies.query();
		query.constrain(Especie.class);
	    ObjectSet<Especie> especies = query.execute();
		
	    for(Especie especie:especies){
	    	if(especie.getNomeCientifico().toLowerCase().equals(nomeCientifico.toLowerCase())){
	    		return especie;
	    	}
	    	
	    }
	    
	    return null;
		
	}
	
	public Especie atualizaEspecie(QueryParamsMap queryParamsMap ) throws UnsupportedEncodingException{
		
		Especie especie = procuraEspeciePorNomeCientifico( queryParamsMap.get("nomeCientifico").value().replaceAll("%20", " ") );
		
		if (queryParamsMap.get("nomePopular").value() != null)
			especie.getEspec().setNomePopular(queryParamsMap.get("nomePopular").value());
        
		if (queryParamsMap.get("exotica").value() != null)
			especie.getEspec().setExotica(queryParamsMap.get("exotica").value().equals("sim"));

		if (queryParamsMap.get("classe").value() != null)
			especie.getEspec().setClasse(queryParamsMap.get("classe").value());

		if (queryParamsMap.get("familia").value() != null)
			especie.getEspec().setFamilia(queryParamsMap.get("familia").value());

		if (queryParamsMap.get("genero").value() != null)
			especie.getEspec().setGenero(queryParamsMap.get("genero").value());

		if (queryParamsMap.get("nomeautor").value() != null)
			especie.getEspec().setNomeAutor(java.net.URLDecoder.decode(queryParamsMap.get("nomeautor").value(), "UTF-8"));

		if (queryParamsMap.get("tipo").value() != null) {
			especie.getEspec().setTipo(Tipo.Nenhum);
			if (Tipo.valueOf(queryParamsMap.get("tipo").value()) != null) {
				especie.getEspec().setTipo(Tipo.valueOf(queryParamsMap.get("tipo").value()));
			}
		}
       	
    	especie.setNomeCientifico( java.net.URLDecoder.decode(queryParamsMap.get("nomeCientifico").value(), "UTF-8") );
		especie.setEspecie( java.net.URLDecoder.decode(queryParamsMap.get("especie").value(), "UTF-8") );
		
		especies.store(especie);			
		especies.commit();
		
		return especie;
		
	}

	public Boolean excluiEspeciePorNomeCientifico(String nomeCientifico) {
		Especie especie = procuraEspeciePorNomeCientifico( nomeCientifico );
		try {
			especies.delete(especie);
			especies.commit();
			
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
}

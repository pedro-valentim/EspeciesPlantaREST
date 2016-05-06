
import java.util.LinkedList;
import java.util.List;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

public class Model{
	
	ObjectContainer especies = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "../especies3.db4o");
	
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
	    	if(especie.getNomeCientifico().toLowerCase().equals(nomeCientifico)){
	    		return especie;
	    	}
	    	
	    }
	    
	    return null;
		
	}
	
}

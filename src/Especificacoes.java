
public class Especificacoes {

	private String nomePopular;
	private Boolean exotica;
	private String classe;
	private String familia;
	private String genero;
	private String nomeAutor;
	private Tipo tipo;
	
	public Especificacoes() {
		nomePopular = null;
		exotica = null;
		classe = null;
		familia = null;
		genero = null;
		nomeAutor = null;
		tipo = null;
	}

	public String getNomePopular() {
		return nomePopular;
	}

	public void setNomePopular(String nomePopular) {
		this.nomePopular = nomePopular;
	}

	public Boolean getExotica() {
		return exotica;
	}

	public void setExotica(Boolean exotica) {
		this.exotica = exotica;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public String getFamilia() {
		return familia;
	}

	public void setFamilia(String familia) {
		this.familia = familia;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	

}

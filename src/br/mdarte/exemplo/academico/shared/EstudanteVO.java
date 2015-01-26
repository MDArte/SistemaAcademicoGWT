package br.mdarte.exemplo.academico.shared;

import com.google.gwt.view.client.ProvidesKey;

public class EstudanteVO implements java.io.Serializable, Comparable<EstudanteVO> {

	public EstudanteVO() {
		
	}

	/**
	 * Constructor taking all properties.
	 */
	
	public EstudanteVO(java.lang.Long id, java.lang.String matricula, java.lang.String nome) {
		this.id = id;
		this.matricula = matricula;
		this.nome = nome;
	}
	
	/**
	 * Copies constructor from other EstudanteVO
	 */
	
	public EstudanteVO(EstudanteVO otherBean) {
		if (otherBean != null) {
			this.id = otherBean.getId();
			this.matricula = otherBean.getMatricula();
			this.nome = otherBean.getNome();
		}
	}
	
    public static final ProvidesKey<EstudanteVO> KEY_PROVIDER = new ProvidesKey<EstudanteVO>() {

		public Object getKey(EstudanteVO item) {
			return item == null ? null : item.getId();
		}
	};
	
	private java.lang.Long id;
	
	public java.lang.Long getId() {
		return this.id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}
	
	private java.lang.String matricula;

	public java.lang.String getMatricula() {
		return this.matricula;
	}

	public void setMatricula(java.lang.String matricula) {
		this.matricula = matricula;
	}
	
	private java.lang.String nome;

	public java.lang.String getNome() {
		return this.nome;
	}

	public void setNome(java.lang.String nome) {
		this.nome = nome;
	}

	public int compareTo(EstudanteVO o)
	{
		return (o == null || o.getNome() == null) ? -1 : -o.getNome().compareTo(this.nome);
	}
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof EstudanteVO)) {
			return false;
		}
		
		EstudanteVO other = (EstudanteVO) o;
		return nome.equals(other.getNome()) && id == other.getId() && matricula.equals(other.getMatricula());
	}
	
	@Override
	public int hashCode() {
		return id == null ? 0 : id.hashCode();
	}

}
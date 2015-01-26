package br.mdarte.exemplo.academico.shared;

public class CursoVO implements java.io.Serializable {

	public CursoVO() {

	}

	/**
	 * Constructor taking all properties.
	 */
	
	public CursoVO(java.lang.Long id, java.lang.String codigo, java.lang.String nome, java.util.Collection notas) {
		this.id = id;
		this.codigo = codigo;
		this.nome = nome;
	}

	/**
	 * Copies constructor from other CursoVO
	 */

	public CursoVO(CursoVO otherBean) {
		if (otherBean != null) {
			this.id = otherBean.getId();
			this.codigo = otherBean.getCodigo();
			this.nome = otherBean.getNome();
		}
	}

	private java.lang.Long id;

	public java.lang.Long getId() {
		return this.id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}
	
	private java.lang.String codigo;

	public java.lang.String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(java.lang.String codigo) {
		this.codigo = codigo;
	}
	
	private java.lang.String nome;

	public java.lang.String getNome() {
		return this.nome;
	}

	public void setNome(java.lang.String nome) {
		this.nome = nome;
	}

}
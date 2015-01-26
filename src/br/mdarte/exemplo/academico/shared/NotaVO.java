package br.mdarte.exemplo.academico.shared;

public class NotaVO  implements java.io.Serializable {

	public NotaVO() {
	}

	/**
	 * Constructor taking all properties.
	 */
	public NotaVO(java.lang.Long nota, java.lang.String curso, java.util.Date data, java.lang.String estudante, java.lang.Long cursoId, java.lang.Long estudanteId, java.lang.Long id) {
		this.nota = nota;
		this.curso = curso;
		this.data = data;
		this.estudante = estudante;
		this.cursoId = cursoId;
		this.estudanteId = estudanteId;
		this.id = id;
	}

	/**
	 * Copies constructor from other NotaVO
	 */
	
	public NotaVO(NotaVO otherBean) {
		if (otherBean != null) {
			this.nota = otherBean.getNota();
			this.curso = otherBean.getCurso();
			this.data = otherBean.getData();
			this.estudante = otherBean.getEstudante();
			this.cursoId = otherBean.getCursoId();
			this.estudanteId = otherBean.getEstudanteId();
			this.id = otherBean.getId();
		}
	}

	private java.lang.Long nota;

	public java.lang.Long getNota() {
		return this.nota;
	}

	public void setNota(java.lang.Long nota) {
		this.nota = (java.lang.Long)nota;
	}
	
	private java.lang.String curso;

	public java.lang.String getCurso() {
		return this.curso;
	}

	public void setCurso(java.lang.String curso) {
		this.curso = curso;
	}
	
	private java.util.Date data;

	public java.util.Date getData() {
		return this.data;
	}

	public void setData(java.util.Date data) {
		this.data = data;
	}
	
	private java.lang.String estudante;

	public java.lang.String getEstudante() {
		return this.estudante;
	}

	public void setEstudante(java.lang.String estudante) {
		this.estudante = estudante;
	}
	
	private java.lang.Long cursoId;

	public java.lang.Long getCursoId() {
		return this.cursoId;
	}

	public void setCursoId(java.lang.Long cursoId) {
		this.cursoId = cursoId;
	}
	
	private java.lang.Long estudanteId;

	public java.lang.Long getEstudanteId() {
		return this.estudanteId;
	}

	public void setEstudanteId(java.lang.Long estudanteId) {
		this.estudanteId = estudanteId;
	}
	
	private java.lang.Long id;

	public java.lang.Long getId() {
		return this.id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

}
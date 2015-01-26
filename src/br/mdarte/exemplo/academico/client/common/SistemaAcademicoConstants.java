package br.mdarte.exemplo.academico.client.common;

import com.google.gwt.i18n.client.Constants;

public interface SistemaAcademicoConstants extends Constants
{
	@Key("id")
	String getId();
	
	@Key("nome")
	String getNome();
	
	@Key("matricula")
	String getMatricula();
	
	@Key("empty")
	String getEmpty();
}

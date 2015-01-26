package br.mdarte.exemplo.academico.client.presenter.interfaces;

import com.google.gwt.user.client.ui.IsWidget;
import com.mvp4g.client.view.LazyView;

public interface DetalhaEstudanteViewInterface extends IsWidget, LazyView
{
	public interface DetalhaEstudantePresenterInterface {
		
		void goToEditaEstudante(Long id);
		
		void deletaEstudante(Long id);
	}
	
	void setMatricula (String matricula);
	
	void setNome (String text);
	
	void setIdEstudante (Long id);
	
	Long getIdEstudante();

	void setEditButtonLabel(String string);
	
	void setDeleteButtonLabel(String string);
}

package br.mdarte.exemplo.academico.client.presenter.interfaces;

import com.google.gwt.user.client.ui.IsWidget;
import com.mvp4g.client.view.LazyView;

public interface ConsultaEstudanteViewInterface extends IsWidget, LazyView
{
	public interface ConsultaEstudantePresenterInterface {
		
		void goToResultadoConsulta(String text);
	}
	
	void setText (String text);
}

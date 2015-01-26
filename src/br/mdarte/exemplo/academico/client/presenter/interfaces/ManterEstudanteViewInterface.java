package br.mdarte.exemplo.academico.client.presenter.interfaces;

import br.mdarte.exemplo.academico.shared.EstudanteVO;

import com.google.gwt.user.client.ui.IsWidget;
import com.mvp4g.client.view.LazyView;

public interface ManterEstudanteViewInterface extends IsWidget, LazyView
{
	public interface ManterEstudantePresenterInterface {
		
		void manterEstudante(EstudanteVO estudante);
	}
	
	void setManterButtonLabel(String text);
	
	void setIdEstudante (Long id);
	
	void setNome (String text);
	
	void setMatricula (String matricula);
}

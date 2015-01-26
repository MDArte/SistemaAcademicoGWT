package br.mdarte.exemplo.academico.client.presenter.interfaces;

import java.util.ArrayList;

import br.mdarte.exemplo.academico.shared.EstudanteVO;

import com.google.gwt.user.client.ui.IsWidget;
import com.mvp4g.client.view.LazyView;

public interface ResultadoConsultaViewInterface extends IsWidget, LazyView
{
	public interface ResultadoConsultaPresenterInterface {
		void goToDetalhaEstudante(Long id);
		
		void deletaEstudante(Long id);
		
		void deletaEstudantes(ArrayList<Long> listaIds);
	}
	
	void setTable (ArrayList<EstudanteVO> tabela) ;
	
	void deleteRow(EstudanteVO estudante);
	
	void deleteRows(ArrayList<EstudanteVO> listaEstudantes);
}

package br.mdarte.exemplo.academico.client.presenter;

import java.util.ArrayList;

import br.mdarte.exemplo.academico.client.EstudanteServiceAsync;
import br.mdarte.exemplo.academico.client.event.SistemaAcademicoEventBus;
import br.mdarte.exemplo.academico.client.presenter.interfaces.ResultadoConsultaViewInterface;
import br.mdarte.exemplo.academico.client.presenter.interfaces.ResultadoConsultaViewInterface.ResultadoConsultaPresenterInterface;
import br.mdarte.exemplo.academico.client.view.ResultadoConsultaView;
import br.mdarte.exemplo.academico.shared.EstudanteVO;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.LazyPresenter;

//Indica a view associada ao presenter
@Presenter( view = ResultadoConsultaView.class )
public class ResultadoConsultaPresenter extends LazyPresenter<ResultadoConsultaViewInterface, SistemaAcademicoEventBus> implements ResultadoConsultaPresenterInterface
{
	// Inicializa automaticamente o servico assincrono
	@Inject
	private EstudanteServiceAsync service;

	public void onGoToResultadoConsulta(String text) {
		
		final String eventName = "resultadoConsulta";
		final String tempText = text;
		
    	service.isLogged(new AsyncCallback<Boolean> () {
			public void onFailure(Throwable caught) {
				// Show the RPC error message to the user
				//eventBus.goToConsultaEstudante("Remote Procedure Call - Failure");
				eventBus.menuDeslogado();
				
			}

			public void onSuccess(Boolean result) {
				if (result.booleanValue()) {
					consultaEstudante(tempText);
					eventBus.setBody(view);
				} else {
					eventBus.menuDeslogado();
					eventBus.goToLogin(eventName, tempText);
				}
			}
    	});
		
	}
	
	private void consultaEstudante (String query) {
		
		service.consultaEstudante(query, new AsyncCallback< ArrayList<EstudanteVO> >() {
			public void onFailure(Throwable caught) {
				// Show the RPC error message to the user
				//eventBus.goToConsultaEstudante("Remote Procedure Call - Failure");
				eventBus.menuDeslogado();
			}

			public void onSuccess(ArrayList<EstudanteVO> result) {
				view.setTable(result);
			}
		});
		
	}

	public void goToDetalhaEstudante(Long id)
	{
		eventBus.goToDetalhaEstudante(id);
	}

	public void deletaEstudante(final Long id)
	{
		service.deletaEstudante(id, new AsyncCallback< EstudanteVO > () {
			public void onFailure(Throwable caught) {
				// Show the RPC error message to the user
				//eventBus.goToConsultaEstudante("Remote Procedure Call - Failure");
				eventBus.menuDeslogado();
			}

			public void onSuccess(EstudanteVO result) {
				view.deleteRow(result);
			}
		});
	}
	
	public void deletaEstudantes(final ArrayList<Long> listaIds)
	{
		service.deletaEstudantes(listaIds, new AsyncCallback< ArrayList<EstudanteVO> > () {
			public void onFailure(Throwable caught) {
				// Show the RPC error message to the user
				//eventBus.goToConsultaEstudante("Remote Procedure Call - Failure");
				eventBus.menuDeslogado();
			}

			public void onSuccess(ArrayList<EstudanteVO> result) {
				view.deleteRows(result);
			}
		});
	}
	
	

}

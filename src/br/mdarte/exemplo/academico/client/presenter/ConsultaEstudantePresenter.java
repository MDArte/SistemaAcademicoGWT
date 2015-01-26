package br.mdarte.exemplo.academico.client.presenter;

import br.mdarte.exemplo.academico.client.EstudanteServiceAsync;
import br.mdarte.exemplo.academico.client.event.SistemaAcademicoEventBus;
import br.mdarte.exemplo.academico.client.presenter.interfaces.ConsultaEstudanteViewInterface;
import br.mdarte.exemplo.academico.client.presenter.interfaces.ConsultaEstudanteViewInterface.ConsultaEstudantePresenterInterface;
import br.mdarte.exemplo.academico.client.view.ConsultaEstudanteView;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.LazyPresenter;

//Indica a view associada ao presenter
@Presenter( view = ConsultaEstudanteView.class )
public class ConsultaEstudantePresenter extends LazyPresenter<ConsultaEstudanteViewInterface, SistemaAcademicoEventBus> implements ConsultaEstudantePresenterInterface
{
	//Inicializa automaticamente o servico assincrono
	@Inject
	private EstudanteServiceAsync service;
	
	public void onGoToConsultaEstudante() {
		final String eventName = "consultaEstudante";
		
    	service.isLogged(new AsyncCallback<Boolean> () {
			public void onFailure(Throwable caught) {
				// Show the RPC error message to the user
				//eventBus.goToConsultaEstudante("Remote Procedure Call - Failure");
				eventBus.menuDeslogado();
				
			}

			public void onSuccess(Boolean result) {
				if (result.booleanValue()) {
					eventBus.setBody(view);
				} else {
					eventBus.menuDeslogado();
					eventBus.goToLogin(eventName);
				}
			}
    	});
	}

	public void goToResultadoConsulta(String text)
	{
		eventBus.goToResultadoConsulta(text);
	}
}

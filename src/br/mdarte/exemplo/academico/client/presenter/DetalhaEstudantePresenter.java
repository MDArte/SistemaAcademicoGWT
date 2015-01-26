package br.mdarte.exemplo.academico.client.presenter;

import br.mdarte.exemplo.academico.client.EstudanteServiceAsync;
import br.mdarte.exemplo.academico.client.event.SistemaAcademicoEventBus;
import br.mdarte.exemplo.academico.client.presenter.interfaces.DetalhaEstudanteViewInterface;
import br.mdarte.exemplo.academico.client.presenter.interfaces.DetalhaEstudanteViewInterface.DetalhaEstudantePresenterInterface;
import br.mdarte.exemplo.academico.client.view.DetalhaEstudanteView;
import br.mdarte.exemplo.academico.shared.EstudanteVO;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.LazyPresenter;

//Indica a view associada ao presenter
@Presenter( view = DetalhaEstudanteView.class )
public class DetalhaEstudantePresenter extends LazyPresenter<DetalhaEstudanteViewInterface, SistemaAcademicoEventBus> implements DetalhaEstudantePresenterInterface
{
	// Inicializa automaticamente o servico assincrono
	@Inject
	private EstudanteServiceAsync service;
	
	public void onGoToDetalhaEstudante(Long id) {
		
		final Long estudanteId = id;
		final String eventName = "consultaEstudante";
		
    	service.isLogged(new AsyncCallback<Boolean> () {
			public void onFailure(Throwable caught) {
				// Show the RPC error message to the user
				//eventBus.goToConsultaEstudante("Remote Procedure Call - Failure");
				//eventBus.goToHome();
				eventBus.menuDeslogado();
				
			}

			public void onSuccess(Boolean result) {
				if (result.booleanValue()) {
					getEstudanteData(estudanteId);
					eventBus.setBody(view);
				} else {
					eventBus.menuDeslogado();
					eventBus.goToLogin(eventName, estudanteId);
				}
			}
    	});

		
	}
	
	private void getEstudanteData(Long id) {
		
		service.getEstudante(id, new AsyncCallback< EstudanteVO> () {
			public void onFailure(Throwable caught) {
				// Show the RPC error message to the user
				//eventBus.goToConsultaEstudante("Remote Procedure Call - Failure");
				//eventBus.goToHome();
				eventBus.menuDeslogado();
				
			}

			public void onSuccess(EstudanteVO estudante) {
				view.setMatricula(estudante.getMatricula());
				view.setNome(estudante.getNome());
				view.setIdEstudante(estudante.getId());
			}
		});

		view.setEditButtonLabel("Editar");
		view.setDeleteButtonLabel("Deletar");

	}


	public void goToEditaEstudante(Long id)
	{
		eventBus.goToEditaEstudante(id);
		
	}



	public void deletaEstudante(Long id)
	{
		service.deletaEstudante(id, new AsyncCallback< EstudanteVO > () {
			public void onFailure(Throwable caught) {
				// Show the RPC error message to the user
				eventBus.menuDeslogado();
				eventBus.goToHome();
			}

			public void onSuccess(EstudanteVO result) {
				eventBus.goToConsultaEstudante();
			}
		});
	}

}

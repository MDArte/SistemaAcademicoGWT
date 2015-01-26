package br.mdarte.exemplo.academico.client.presenter;

import br.mdarte.exemplo.academico.client.EstudanteServiceAsync;
import br.mdarte.exemplo.academico.client.event.SistemaAcademicoEventBus;
import br.mdarte.exemplo.academico.client.presenter.interfaces.ManterEstudanteViewInterface;
import br.mdarte.exemplo.academico.client.presenter.interfaces.ManterEstudanteViewInterface.ManterEstudantePresenterInterface;
import br.mdarte.exemplo.academico.client.view.ManterEstudanteView;
import br.mdarte.exemplo.academico.shared.EstudanteVO;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.LazyPresenter;

//Indica a view associada ao presenter
@Presenter( view = ManterEstudanteView.class )
public class ManterEstudantePresenter extends LazyPresenter<ManterEstudanteViewInterface, SistemaAcademicoEventBus> implements ManterEstudantePresenterInterface
{
	// Inicializa automaticamente o servico assincrono
	@Inject
	private EstudanteServiceAsync service;
	
	public void onGoToAdicionaEstudante() {
		
		final String eventName = "adicionaEstudante";
		
    	service.isLogged(new AsyncCallback<Boolean> () {
			public void onFailure(Throwable caught) {
				// Show the RPC error message to the user
				//eventBus.goToConsultaEstudante("Remote Procedure Call - Failure");
				eventBus.menuDeslogado();
				
			}

			public void onSuccess(Boolean result) {
				if (result.booleanValue()) {
					setAdicionaEstudanteBody();
					eventBus.setBody(view);
				} else {
					eventBus.menuDeslogado();
					eventBus.goToLogin(eventName, null);
				}
			}
    	});
		
	}
	
	private void setAdicionaEstudanteBody() {
		
		view.setManterButtonLabel("Adicionar");
		
		view.setIdEstudante(null);
		view.setMatricula("");
		view.setNome("");
		
	}
	
	public void onGoToEditaEstudante(Long id) {
		
		final String eventName = "editaEstudante";
		final Long idEstudante = id;
		
    	service.isLogged(new AsyncCallback<Boolean> () {
			public void onFailure(Throwable caught) {
				// Show the RPC error message to the user
				//eventBus.goToConsultaEstudante("Remote Procedure Call - Failure");
				eventBus.menuDeslogado();
				
			}

			public void onSuccess(Boolean result) {
				if (result.booleanValue()) {
					getEstudanteVO(idEstudante);
					eventBus.setBody(view);
				} else {
					eventBus.menuDeslogado();
					eventBus.goToLogin(eventName, idEstudante);
				}
			}
    	});
	}
	
	private void getEstudanteVO(Long id) {
		service.getEstudante(id, new AsyncCallback< EstudanteVO> () {
			public void onFailure(Throwable caught) {
				// Show the RPC error message to the user
				//eventBus.goToConsultaEstudante("Remote Procedure Call - Failure");
			}

			public void onSuccess(EstudanteVO estudante) {
				setEditaEstudanteBody(estudante);

			}
		});
	}
	
	private void setEditaEstudanteBody(EstudanteVO estudante) {
		
		view.setIdEstudante(estudante.getId());
		view.setMatricula(estudante.getMatricula());
		view.setNome(estudante.getNome());
		
		view.setManterButtonLabel("Editar");
		
	}


	public void manterEstudante(EstudanteVO estudante)
	{
		service.manterEstudante(estudante, new AsyncCallback< Long > () {
			public void onFailure(Throwable caught) {
				// Show the RPC error message to the user
				//eventBus.goToConsultaEstudante("Remote Procedure Call - Failure");
			}

			public void onSuccess(Long result) {
				eventBus.goToDetalhaEstudante(result);
			}
		});
	}

}

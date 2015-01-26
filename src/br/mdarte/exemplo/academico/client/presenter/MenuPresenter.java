package br.mdarte.exemplo.academico.client.presenter;

import br.mdarte.exemplo.academico.client.EstudanteServiceAsync;
import br.mdarte.exemplo.academico.client.event.SistemaAcademicoEventBus;
import br.mdarte.exemplo.academico.client.presenter.interfaces.MenuViewInterface;
import br.mdarte.exemplo.academico.client.presenter.interfaces.MenuViewInterface.MenuPresenterInterface;
import br.mdarte.exemplo.academico.client.view.MenuView;
import br.mdarte.exemplo.academico.shared.EstudanteVO;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

//Indica a view associada ao presenter
@Presenter( view = MenuView.class )
public class MenuPresenter extends BasePresenter<MenuViewInterface, SistemaAcademicoEventBus> implements MenuPresenterInterface
{
	// Inicializa automaticamente o servico assincrono
	@Inject
	private EstudanteServiceAsync service;
	
	public void onMenuLogado() {
		view.loginSuccess();
	}
	
	public void onMenuDeslogado() {
		view.quitSession();
	}

	public void goToHome() {
		eventBus.goToHome();
		
	}

	public void goToNovoEstudante() {
		eventBus.goToAdicionaEstudante();
	}
	
	public void quitSession() {
		service.quitSession(new AsyncCallback< String> () {
			public void onFailure(Throwable caught) {
				// Show the RPC error message to the user
				//eventBus.goToConsultaEstudante("Remote Procedure Call - Failure");
				view.quitSession();
			}

			public void onSuccess(String result)
			{
				view.quitSession();
				eventBus.goToHome();
			}
		});
	}

	@Override
	public void goToConsultaEstudante()
	{
		eventBus.goToConsultaEstudante();
		
	}

	@Override
	public void goToLogin()
	{
		eventBus.goToLogin(null, null);
		
	}

}

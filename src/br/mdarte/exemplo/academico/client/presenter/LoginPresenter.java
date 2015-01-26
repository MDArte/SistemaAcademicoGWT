package br.mdarte.exemplo.academico.client.presenter;

import br.mdarte.exemplo.academico.client.EstudanteServiceAsync;
import br.mdarte.exemplo.academico.client.event.SistemaAcademicoEventBus;
import br.mdarte.exemplo.academico.client.presenter.interfaces.LoginViewInterface;
import br.mdarte.exemplo.academico.client.presenter.interfaces.LoginViewInterface.LoginPresenterInterface;
import br.mdarte.exemplo.academico.client.view.LoginView;
import br.mdarte.exemplo.academico.client.view.RootView;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

//Indica a view associada ao presenter
@Presenter( view = LoginView.class )
public class LoginPresenter extends BasePresenter<LoginViewInterface, SistemaAcademicoEventBus> implements LoginPresenterInterface
{
	//Inicializa automaticamente o servico assincrono
	@Inject
	private EstudanteServiceAsync service;
	
	private String eventName = "";
	
	private Object[] objects;

	public void login(String login, String senha)
	{
		service.login(login, senha, new AsyncCallback< Boolean> () {
			public void onFailure(Throwable caught) {
				// Show the RPC error message to the user
				//eventBus.goToConsultaEstudante("Remote Procedure Call - Failure");
				view.loginFail();
			}

			public void onSuccess(Boolean result)
			{
				if (result.booleanValue()) {
					view.loginSuccess();
					goToDestination();
				} else {
					view.loginFail();
				}
				
			}
		});
	}
	
	public void onGoToLogin(String eventName, Object... objects) {
		
		this.eventName = eventName;
		this.objects = objects;
		
		eventBus.setBody(view);
	}

	public void goToDestination()
	{
		eventBus.menuLogado();
		if (this.eventName != null) eventBus.dispatch(this.eventName, this.objects);
		else eventBus.dispatch("consultaEstudante", "");
		
	}

}

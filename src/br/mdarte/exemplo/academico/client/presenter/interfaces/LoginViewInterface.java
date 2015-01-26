package br.mdarte.exemplo.academico.client.presenter.interfaces;

import com.google.gwt.user.client.ui.IsWidget;

public interface LoginViewInterface extends IsWidget
{
	public interface LoginPresenterInterface {
		
		void login(String nome, String senha);
		
	}

	void loginSuccess();
	
	void loginFail();

}

package br.mdarte.exemplo.academico.client.presenter.interfaces;

import com.google.gwt.user.client.ui.IsWidget;

public interface MenuViewInterface extends IsWidget
{
	public interface MenuPresenterInterface {
		void goToHome();
		
		void goToConsultaEstudante();
		
		void goToLogin();
		
		void goToNovoEstudante();
		
		void quitSession();
	}
	
	void loginSuccess();
	
	void quitSession();
}

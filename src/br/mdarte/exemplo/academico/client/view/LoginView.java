package br.mdarte.exemplo.academico.client.view;

import br.mdarte.exemplo.academico.client.presenter.interfaces.LoginViewInterface;
import br.mdarte.exemplo.academico.client.presenter.interfaces.LoginViewInterface.LoginPresenterInterface;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Singleton;

@Singleton
public class LoginView extends ReverseCompositeView<LoginPresenterInterface> implements LoginViewInterface {

	private static LoginViewUiBinder uiBinder = GWT.create( LoginViewUiBinder.class );

	interface LoginViewUiBinder extends UiBinder<Widget, LoginView> {
	}
	
	@UiField TextBox login;
	@UiField PasswordTextBox senha;
	@UiField Button loginButton;

	public LoginView() {
		//quitButton.setVisible(false);
		initWidget( uiBinder.createAndBindUi( this ) );
		
	}
	
	public void loginSuccess() {
		login.setText("");
		senha.setText("");
		loginButton.setText("Login");
	}
	
	public void loginFail() {
		login.setText("");
		senha.setText("");
		loginButton.setText("Try Again!");
	}
	
	@UiHandler( "loginButton" )
	public void onClickLoginButton(ClickEvent e){
		presenter.login(login.getText(),senha.getText());
	}
	
	
	

}

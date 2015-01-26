package br.mdarte.exemplo.academico.client.view;

import br.mdarte.exemplo.academico.client.presenter.interfaces.MenuViewInterface;
import br.mdarte.exemplo.academico.client.presenter.interfaces.MenuViewInterface.MenuPresenterInterface;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Singleton;

@Singleton
public class MenuView extends ReverseCompositeView<MenuPresenterInterface> implements MenuViewInterface {

	private static MenuViewUiBinder uiBinder = GWT.create( MenuViewUiBinder.class );

	interface MenuViewUiBinder extends UiBinder<Widget, MenuView> {
	}
	
	@UiField Button loginButton;
	@UiField Button quitButton;
	@UiField Anchor novaConsulta;
	@UiField Anchor novoEstudante;

	public MenuView() {
		initWidget( uiBinder.createAndBindUi( this ) );
		quitButton.setVisible(false);
		novaConsulta.setVisible(false);
		novoEstudante.setVisible(false);
		
	}
	
	public void loginSuccess() {
		quitButton.setVisible(true);
		loginButton.setVisible(false);
		novaConsulta.setVisible(true);
		novoEstudante.setVisible(true);
	}
	
	public void quitSession() {
		quitButton.setVisible(false);
		loginButton.setVisible(true);
		novaConsulta.setVisible(false);
		novoEstudante.setVisible(false);
	}
	
	@UiHandler( "home" )
	public void onClickConsultaEstudante(ClickEvent e){
		presenter.goToHome();
	}
	
	@UiHandler( "novaConsulta" )
	public void onClickNovaConsulta(ClickEvent e){
		presenter.goToConsultaEstudante();
	}

	@UiHandler( "novoEstudante" )
	public void onClickNovoEstudante(ClickEvent e){
		presenter.goToNovoEstudante();
	}
	
	@UiHandler( "quitButton" )
	public void onClickQuitButton(ClickEvent e){
		presenter.quitSession();
	}
	
	@UiHandler( "loginButton" )
	public void onClickLoginButton(ClickEvent e){
		presenter.goToLogin();
	}
	
	

}

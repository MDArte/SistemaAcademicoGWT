package br.mdarte.exemplo.academico.client.view;

import br.mdarte.exemplo.academico.client.presenter.interfaces.ConsultaEstudanteViewInterface;
import br.mdarte.exemplo.academico.client.presenter.interfaces.ConsultaEstudanteViewInterface.ConsultaEstudantePresenterInterface;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class ConsultaEstudanteView extends ReverseCompositeView<ConsultaEstudantePresenterInterface> implements ConsultaEstudanteViewInterface {
	
	private static ConsultaEstudanteViewUiBinder uiBinder = GWT.create( ConsultaEstudanteViewUiBinder.class );

	interface ConsultaEstudanteViewUiBinder extends UiBinder<Widget, ConsultaEstudanteView> {
	}

	@UiField TextBox textbox;
	@UiField Button consultaButton;

	public void createView() {
		//don't create the view before to take advantage of the lazy loading mechanism
		initWidget( uiBinder.createAndBindUi( this ) );
	}
	
	public void setText( String text ) {
		textbox.setText( text ); 
	}
	
	@UiHandler( "consultaButton" )
	public void onClickConsultaButton(ClickEvent e){
		presenter.goToResultadoConsulta(textbox.getText());
	}

}

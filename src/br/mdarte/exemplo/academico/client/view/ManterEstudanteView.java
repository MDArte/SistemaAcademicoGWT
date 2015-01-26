package br.mdarte.exemplo.academico.client.view;

import br.mdarte.exemplo.academico.client.presenter.interfaces.ManterEstudanteViewInterface;
import br.mdarte.exemplo.academico.client.presenter.interfaces.ManterEstudanteViewInterface.ManterEstudantePresenterInterface;
import br.mdarte.exemplo.academico.shared.EstudanteVO;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Hidden;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class ManterEstudanteView extends ReverseCompositeView<ManterEstudantePresenterInterface> implements ManterEstudanteViewInterface {
	
	private static ManterEstudanteViewUiBinder uiBinder = GWT.create( ManterEstudanteViewUiBinder.class );

	interface ManterEstudanteViewUiBinder extends UiBinder<Widget, ManterEstudanteView> {
	}

	@UiField Hidden idEstudante;
	@UiField TextBox nome;
	@UiField TextBox matricula;
	@UiField Button manterButton;

	public void createView() {
		//don't create the view before to take advantage of the lazy loading mechanism
		initWidget( uiBinder.createAndBindUi( this ) );
	}
	
	@UiHandler( "manterButton" )
	public void onClickManterButton(ClickEvent e){
		presenter.manterEstudante(new EstudanteVO(this.getIdEstudante() ,this.matricula.getText(),this.nome.getText()));
		//presenter.manterEstudante(new EstudanteVO(new Long(1),"dddd","dddd"));
	}
	
	

	public void setNome(String text)
	{
		this.nome.setText( text ); 
		
	}

	public void setMatricula(String matricula)
	{
		this.matricula.setText( matricula ); 
		
	}

	public void setIdEstudante(Long id)
	{
		if (id != null) this.idEstudante.setValue(id.toString());
		else this.idEstudante.setValue(null);
		
	}
	
	public Long getIdEstudante()
	{
		if (this.idEstudante.getValue() == null || this.idEstudante.getValue().isEmpty()) {
			return null;
		}
		else return Long.parseLong(this.idEstudante.getValue());
		
	}

	public void setManterButtonLabel(String text)
	{
		this.manterButton.setText(text);
	}

}

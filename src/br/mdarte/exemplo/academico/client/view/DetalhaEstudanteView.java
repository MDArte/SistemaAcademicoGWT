package br.mdarte.exemplo.academico.client.view;

import br.mdarte.exemplo.academico.client.presenter.interfaces.DetalhaEstudanteViewInterface;
import br.mdarte.exemplo.academico.client.presenter.interfaces.DetalhaEstudanteViewInterface.DetalhaEstudantePresenterInterface;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Hidden;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class DetalhaEstudanteView extends ReverseCompositeView<DetalhaEstudantePresenterInterface> implements DetalhaEstudanteViewInterface {
	
	private static DetalhaEstudanteViewUiBinder uiBinder = GWT.create( DetalhaEstudanteViewUiBinder.class );

	interface DetalhaEstudanteViewUiBinder extends UiBinder<Widget, DetalhaEstudanteView> {
	}

	@UiField Hidden idEstudante;
	@UiField Label nome;
	@UiField Label matricula;
	@UiField Button editButton;
	@UiField Button deleteButton;

	public void createView() {
		//don't create the view before to take advantage of the lazy loading mechanism
		initWidget( uiBinder.createAndBindUi( this ) );
	}
	
	@UiHandler( "editButton" )
	public void onClickEditButton(ClickEvent e){
		presenter.goToEditaEstudante(getIdEstudante());
	}
	
	@UiHandler( "deleteButton" )
	public void onClickDeleteButton(ClickEvent e){
		presenter.deletaEstudante(getIdEstudante());
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
		this.idEstudante.setValue(id.toString());
		
	}
	
	public Long getIdEstudante()
	{
		return Long.parseLong(this.idEstudante.getValue());
		
	}

	public void setEditButtonLabel(String text)
	{
		this.editButton.setText(text);
	}

	public void setDeleteButtonLabel(String text)
	{
		this.deleteButton.setText(text);
	}

}

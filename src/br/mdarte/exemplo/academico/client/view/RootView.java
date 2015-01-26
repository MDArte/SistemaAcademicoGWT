package br.mdarte.exemplo.academico.client.view;

import br.mdarte.exemplo.academico.client.presenter.interfaces.RootViewInterface;
import br.mdarte.exemplo.academico.client.presenter.interfaces.RootViewInterface.RootPresenterInterface;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.SimpleLayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class RootView extends ReverseCompositeView<RootPresenterInterface> implements RootViewInterface {
	
	private static RootViewUiBinder uiBinder = GWT.create( RootViewUiBinder.class );
	
	@UiField( provided = true )
	Widget header, menu, footer;
	
	@UiField
	SimpleLayoutPanel body;
	
	interface RootViewUiBinder extends UiBinder<Widget, RootView> {
	}

	@Inject
	public RootView( HeaderView header, MenuView menu, FooterView footer) {
		this.header = header;
		this.menu = menu;
		this.footer = footer;
		initWidget( uiBinder.createAndBindUi( this ) );
	}

	public void setBody(IsWidget body) {
		this.body.setWidget( body );
	}

}

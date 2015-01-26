package br.mdarte.exemplo.academico.client.view;

import br.mdarte.exemplo.academico.client.presenter.interfaces.HeaderViewInterface;
import br.mdarte.exemplo.academico.client.presenter.interfaces.HeaderViewInterface.HeaderPresenterInterface;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Singleton;

@Singleton
public class HeaderView extends ReverseCompositeView<HeaderPresenterInterface> implements HeaderViewInterface {
	
	private static HeaderViewUiBinder uiBinder = GWT.create( HeaderViewUiBinder.class );

	interface HeaderViewUiBinder extends UiBinder<Widget, HeaderView> {
	}

	public HeaderView() {
		initWidget( uiBinder.createAndBindUi( this ) );
	}
	
}

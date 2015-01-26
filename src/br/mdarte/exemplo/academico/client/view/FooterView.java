package br.mdarte.exemplo.academico.client.view;

import br.mdarte.exemplo.academico.client.presenter.interfaces.FooterViewInterface;
import br.mdarte.exemplo.academico.client.presenter.interfaces.FooterViewInterface.FooterPresenterInterface;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;

public class FooterView extends ReverseCompositeView<FooterPresenterInterface> implements FooterViewInterface {
	
	private static FooterViewUiBinder uiBinder = GWT.create( FooterViewUiBinder.class );

	interface FooterViewUiBinder extends UiBinder<Widget, FooterView> {
	}

	public FooterView() {
		initWidget( uiBinder.createAndBindUi( this ) );
	}	
}

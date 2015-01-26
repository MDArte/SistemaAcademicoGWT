package br.mdarte.exemplo.academico.client.view;

import br.mdarte.exemplo.academico.client.presenter.interfaces.HomeViewInterface;
import br.mdarte.exemplo.academico.client.presenter.interfaces.HomeViewInterface.HomePresenterInterface;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Singleton;

@Singleton
public class HomeView extends ReverseCompositeView<HomePresenterInterface> implements HomeViewInterface {
	
	private static HomeViewUiBinder uiBinder = GWT.create( HomeViewUiBinder.class );

	interface HomeViewUiBinder extends UiBinder<Widget, HomeView> {
	}

	public HomeView() {
		initWidget( uiBinder.createAndBindUi( this ) );
	}
	
}

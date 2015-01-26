package br.mdarte.exemplo.academico.client.presenter;

import br.mdarte.exemplo.academico.client.event.SistemaAcademicoEventBus;
import br.mdarte.exemplo.academico.client.presenter.interfaces.RootViewInterface;
import br.mdarte.exemplo.academico.client.presenter.interfaces.RootViewInterface.RootPresenterInterface;
import br.mdarte.exemplo.academico.client.view.RootView;

import com.google.gwt.user.client.ui.IsWidget;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

// Indica a view associada ao presenter
@Presenter( view = RootView.class )
public class RootPresenter extends BasePresenter<RootViewInterface, SistemaAcademicoEventBus> implements RootPresenterInterface
{
	
	public void onInit() {
		eventBus.goToHome();
	}
	

	public void onSetBody( IsWidget body ) {
		view.setBody( body );
	}

}

package br.mdarte.exemplo.academico.client.presenter;

import br.mdarte.exemplo.academico.client.event.SistemaAcademicoEventBus;
import br.mdarte.exemplo.academico.client.presenter.interfaces.HomeViewInterface;
import br.mdarte.exemplo.academico.client.presenter.interfaces.HomeViewInterface.HomePresenterInterface;
import br.mdarte.exemplo.academico.client.view.HomeView;

import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

//Indica a view associada ao presenter
@Presenter( view = HomeView.class )
public class HomePresenter extends BasePresenter<HomeViewInterface, SistemaAcademicoEventBus> implements HomePresenterInterface
{
	public void onGoToHome() {
		eventBus.setBody(view);
	}

}

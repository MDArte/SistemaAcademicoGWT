package br.mdarte.exemplo.academico.client.presenter;

import br.mdarte.exemplo.academico.client.event.SistemaAcademicoEventBus;
import br.mdarte.exemplo.academico.client.presenter.interfaces.HeaderViewInterface;
import br.mdarte.exemplo.academico.client.presenter.interfaces.HeaderViewInterface.HeaderPresenterInterface;
import br.mdarte.exemplo.academico.client.view.HeaderView;

import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

//Indica a view associada ao presenter
@Presenter( view = HeaderView.class )
public class HeaderPresenter extends BasePresenter<HeaderViewInterface, SistemaAcademicoEventBus> implements HeaderPresenterInterface
{

}

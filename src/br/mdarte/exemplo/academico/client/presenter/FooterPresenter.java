package br.mdarte.exemplo.academico.client.presenter;

import br.mdarte.exemplo.academico.client.event.SistemaAcademicoEventBus;
import br.mdarte.exemplo.academico.client.presenter.interfaces.FooterViewInterface;
import br.mdarte.exemplo.academico.client.presenter.interfaces.FooterViewInterface.FooterPresenterInterface;
import br.mdarte.exemplo.academico.client.view.FooterView;

import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

//Indica a view associada ao presenter
@Presenter( view = FooterView.class )
public class FooterPresenter extends BasePresenter<FooterViewInterface, SistemaAcademicoEventBus> implements FooterPresenterInterface
{

}

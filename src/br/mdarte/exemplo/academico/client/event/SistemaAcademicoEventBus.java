package br.mdarte.exemplo.academico.client.event;

import br.mdarte.exemplo.academico.client.history.PageHistoryConverter;
import br.mdarte.exemplo.academico.client.presenter.ConsultaEstudantePresenter;
import br.mdarte.exemplo.academico.client.presenter.DetalhaEstudantePresenter;
import br.mdarte.exemplo.academico.client.presenter.FooterPresenter;
import br.mdarte.exemplo.academico.client.presenter.HeaderPresenter;
import br.mdarte.exemplo.academico.client.presenter.HomePresenter;
import br.mdarte.exemplo.academico.client.presenter.LoginPresenter;
import br.mdarte.exemplo.academico.client.presenter.ManterEstudantePresenter;
import br.mdarte.exemplo.academico.client.presenter.MenuPresenter;
import br.mdarte.exemplo.academico.client.presenter.ResultadoConsultaPresenter;
import br.mdarte.exemplo.academico.client.presenter.RootPresenter;

import com.google.gwt.user.client.ui.IsWidget;
import com.mvp4g.client.annotation.Event;
import com.mvp4g.client.annotation.Events;
import com.mvp4g.client.annotation.InitHistory;
import com.mvp4g.client.annotation.PlaceService;
import com.mvp4g.client.annotation.Start;
import com.mvp4g.client.event.EventBusWithLookup;

//Indica o PlaceService a ser usado pelo EventBus
@PlaceService( CustomPlaceService.class )

// startPresenter indica o Presenter que inicializará a aplicação
// historyOnStart indica que o histórico estará ativado desde o início
@Events( startPresenter = RootPresenter.class, historyOnStart = true  )
public interface SistemaAcademicoEventBus extends EventBusWithLookup
{
	// Start aqui indica quais presenters simplesmente inicializarão sua views
	@Start
	// bind indica quais sã os presenters
	// Referência http://mvp4g.blogspot.com.br/2011/04/mvp-pattern-associated-with-event-bus.html
	@Event( bind = { MenuPresenter.class, FooterPresenter.class, HeaderPresenter.class } )
	void start();
	
	// InitHistory indica que o histórico começará a ser registrado a part deste evento
	@InitHistory
	// handlers indica qual presenter cuidará do evento. O método OnInit terá que ser implementado no RootPresenter
	@Event( handlers = RootPresenter.class )
	void init();
	
	/*
	 * Layout events
	 * 
	 * Estes eventos apenas alteram o layout da página
	 */
	
	@Event( handlers = RootPresenter.class )
	void setBody( IsWidget body );
	
	@Event( handlers = MenuPresenter.class)
	void menuLogado();
	
	@Event( handlers = MenuPresenter.class)
	void menuDeslogado();
	
	/*
	 * Place events
	 * 
	 * Estes eventos mudam o endereço da página ou fazem comunicação com o servidor
	 * 
	 * historyConverter indica o converter que registra o token do evento
	 * name indica o nome associado ao evento
	 */
	
	@Event( handlers = HomePresenter.class, historyConverter = PageHistoryConverter.class, name = "home" )
	void goToHome();
	
	@Event( handlers = ConsultaEstudantePresenter.class, historyConverter = PageHistoryConverter.class, name = "consultaEstudante" )
	void goToConsultaEstudante();
	
	@Event( handlers = ResultadoConsultaPresenter.class, historyConverter = PageHistoryConverter.class, name = "resultadoConsulta" )
	void goToResultadoConsulta(String text);
	
	@Event( handlers = ManterEstudantePresenter.class, historyConverter = PageHistoryConverter.class, name = "adicionaEstudante" )
	void goToAdicionaEstudante();
	
	@Event( handlers = ManterEstudantePresenter.class, historyConverter = PageHistoryConverter.class, name = "editaEstudante" )
	void goToEditaEstudante(Long id);
	
	@Event( handlers = DetalhaEstudantePresenter.class, historyConverter = PageHistoryConverter.class, name = "detalhaEstudante" )
	void goToDetalhaEstudante(Long id);
	
	@Event( handlers = LoginPresenter.class)
	void goToLogin(String eventName, Object... parameters);
	
}

package br.mdarte.exemplo.academico.client.history;

import java.util.Arrays;
import java.util.List;

import br.mdarte.exemplo.academico.client.event.SistemaAcademicoEventBus;

import com.mvp4g.client.annotation.History;
import com.mvp4g.client.annotation.History.HistoryConverterType;
import com.mvp4g.client.history.HistoryConverter;

/* Aqui o tipo do HistoryConverter é SIMPLE
 *  significa que temos que implementar um método convertToToken 
 *  para cada grupo de eventos que tem a mesma assinatura de parametros
 *  Se fosse DEFAULT teria que ser criado uma função de conversão para cada evento
 *   Referência http://mvp4g.blogspot.com.br/2011/04/history-with-mvp4g.html
 */

@History( type = HistoryConverterType.SIMPLE )
public class PageHistoryConverter implements HistoryConverter<SistemaAcademicoEventBus>
{
	final private List<String> eventListWithParameters = Arrays.asList("detalhaEstudante","editaEstudante","resultadoConsulta");
	
	//Transforma o token em parametros para serem passados para os eventos
	
	public void convertFromToken(String name, String param, SistemaAcademicoEventBus eventBus)
	{
		if (eventListWithParameters.contains(name)) {
			String[] tokenParts = param.split("=");
			String trueParam = "";
			
			if (tokenParts.length > 2) trueParam = tokenParts[2];
			
			if (name.equals("detalhaEstudante") || name.equals("editaEstudante")) {
				
				eventBus.dispatch(name, Long.parseLong(trueParam));
			}
			else eventBus.dispatch(name,trueParam);
		}
		else eventBus.dispatch(name);
	}
	
	// convertToToken transforma o parametro em um token para aparecer na barra de endereços
	
	public String convertToToken( String eventName) {
		return "";
	}
	
	public String convertToToken( String eventName, String name ) {
		return "name=" + name;
	}
	
	public String convertToToken( String eventName, Long number ) {
		return "id=" + number.toString();
	}
	
	
	
	public boolean isCrawlable()
	{
		return false;
	}

}

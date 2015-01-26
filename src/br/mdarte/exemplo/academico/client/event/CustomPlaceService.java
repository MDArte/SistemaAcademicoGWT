package br.mdarte.exemplo.academico.client.event;

import com.mvp4g.client.history.PlaceService;

/*
 * Place Service define a conexão entre a aplicação e o histórico do browser.
 * 
 * Quando um evento precisa ser armazenado no histórico, o método place method do <code>PlaceService</code> é chamado. 
 * Este método irá transformar um evento em um history token da seguinte forma:
 * 
 * myurl#eventName?params
 * 
 * Onde params é a string retornada pelo método que lida com o evento
 * 
 * Referência http://mvp4g.blogspot.com.br/2011/08/custom-place-service.html
 */

public class CustomPlaceService extends PlaceService
{

	public String tokenize( String eventName, String param ) {
		// Função para mostrar na barra de endereços do browser
		// o endereço customizado
	    String token = eventName ;
	    if ( ( param != null ) && ( param.length() > 0 ) ) {
	        token = token + getParamSeparator() + param;
	    }
	    return token;
	}
}

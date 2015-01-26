package br.mdarte.exemplo.academico.client;

import java.util.ArrayList;

import br.mdarte.exemplo.academico.shared.EstudanteVO;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface EstudanteServiceAsync {
	void consultaEstudante(String input, AsyncCallback< ArrayList<EstudanteVO> > callback) throws IllegalArgumentException;
	
	void getEstudante(Long id, AsyncCallback< EstudanteVO > callback) throws IllegalArgumentException;
	
	void manterEstudante(EstudanteVO estudante, AsyncCallback< Long > callback) throws IllegalArgumentException;
	
	void deletaEstudante(Long id, AsyncCallback< EstudanteVO > callback) throws IllegalArgumentException;
	
	void deletaEstudantes(ArrayList<Long> id, AsyncCallback< ArrayList< EstudanteVO > > callback) throws IllegalArgumentException;
	
	void login(String login, String senha,AsyncCallback< Boolean > callback) throws IllegalArgumentException;
	
	void quitSession(AsyncCallback< String > callback) throws IllegalArgumentException;
	
	void isLogged(AsyncCallback< Boolean > callback) throws IllegalArgumentException;
}

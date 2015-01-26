package br.mdarte.exemplo.academico.client;

import java.util.ArrayList;

import br.mdarte.exemplo.academico.shared.EstudanteVO;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("estudante")
public interface EstudanteService extends RemoteService {
	ArrayList<EstudanteVO> consultaEstudante(String name) throws IllegalArgumentException;
	
	EstudanteVO getEstudante(Long id) throws IllegalArgumentException;
	
	EstudanteVO deletaEstudante(Long id) throws IllegalArgumentException;
	
	ArrayList<EstudanteVO> deletaEstudantes(ArrayList<Long> listaIds) throws IllegalArgumentException;
	
	Long manterEstudante(EstudanteVO estudante) throws IllegalArgumentException;
	
	Boolean login(String login, String senha) throws IllegalArgumentException;
	
	String quitSession() throws IllegalArgumentException;
	
	Boolean isLogged() throws IllegalArgumentException;
}

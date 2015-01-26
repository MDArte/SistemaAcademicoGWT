package br.mdarte.exemplo.academico.server;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.security.auth.Subject;

import br.mdarte.exemplo.academico.ServiceLocator;
import br.mdarte.exemplo.academico.accessControl.ControleAcessoImpl;
import br.mdarte.exemplo.academico.action.ListAction;
import br.mdarte.exemplo.academico.cd.Estudante;
import br.mdarte.exemplo.academico.cd.EstudanteImpl;
import br.mdarte.exemplo.academico.client.EstudanteService;
import br.mdarte.exemplo.academico.shared.EstudanteVO;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class EstudanteServiceImpl extends RemoteServiceServlet implements EstudanteService {
	
	private ControleAcessoImpl ca = new ControleAcessoImpl();
	private Subject sub = null;
	
	public Boolean login(String login, String senha) throws IllegalArgumentException {
		try
		{
			sub = ca.login(login,senha);
			
			if (sub != null) return true;

			return false;

			
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
	}
	
	public String quitSession() {
		try
		{
			sub = null;
			ca.quitLogin();
			return "Saiu";
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return "Error";
		}
	}
	
	public Boolean isLogged() {
		return ca.isLogged();
	}

	public ArrayList<EstudanteVO> consultaEstudante(String name) throws IllegalArgumentException
	{
		try
		{
			Collection estudantes =  ServiceLocator.instance().getEstudanteHandlerBI().listEstudante(new EstudanteImpl(), new ListAction());
			ArrayList<EstudanteVO> lista = new ArrayList<EstudanteVO>();
			
			Iterator it = estudantes.iterator();
			
			while (it.hasNext()) {
				Estudante t = (Estudante) it.next();
				lista.add(new EstudanteVO(t.getId(),t.getMatricula(),t.getNome()));
			}
			
			return lista;
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
		/*ArrayList<EstudanteVO> lista = new ArrayList<EstudanteVO>();
		lista.add(new EstudanteVO(new Long(1),"1","rdrt4"));
		lista.add(new EstudanteVO(new Long(2),"2","vbtynynyn"));
		lista.add(new EstudanteVO(new Long(3),"3","2d13rdf3f432"));
		lista.add(new EstudanteVO(new Long(4),"4","zzzz"));
		
		return lista;*/
	}
	
	public EstudanteVO getEstudante(Long id) throws IllegalArgumentException {
		try
		{
			EstudanteVO result = new EstudanteVO();
			EstudanteImpl est = new EstudanteImpl();
			est.setId(id);
			Estudante t =  (Estudante) ServiceLocator.instance().getEstudanteHandlerBI().selectEstudante(est).get(0);

			result.setId(t.getId());
			result.setMatricula(t.getMatricula());
			result.setNome(t.getNome());
			
			return result;
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	public EstudanteVO deletaEstudante(Long id) throws IllegalArgumentException {
		try
		{
			EstudanteImpl est = new EstudanteImpl();
			est.setId(id);
			Estudante t =  (Estudante) ServiceLocator.instance().getEstudanteHandlerBI().selectEstudante(est).get(0);
			
			EstudanteVO eVO = new EstudanteVO(t.getId(),t.getMatricula(), t.getNome());
			
			ServiceLocator.instance().getEstudanteHandlerBI().deleteEstudante(t);
			
			return eVO;
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	public Long manterEstudante(EstudanteVO estudante) {
		try
		{
			Estudante est = new EstudanteImpl();
			
			if (estudante.getId() !=null) {
				est.setId(estudante.getId());
				Estudante t =  (Estudante) ServiceLocator.instance().getEstudanteHandlerBI().selectEstudante(est).get(0);
				t.setNome(estudante.getNome());
				t.setMatricula(estudante.getMatricula());
				ServiceLocator.instance().getEstudanteHandlerBI().updateEstudante(t);
			} else {
				est.setNome(estudante.getNome());
				est.setMatricula(estudante.getMatricula());
				est = (Estudante) ServiceLocator.instance().getEstudanteHandlerBI().insertEstudante(est).get(0);
			}
			return est.getId();
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<EstudanteVO> deletaEstudantes(ArrayList<Long> listaIds) throws IllegalArgumentException
	{
		ArrayList<EstudanteVO> estudantes = new ArrayList<EstudanteVO>();
		
		try
		{
			for(Long id : listaIds) {
				EstudanteImpl est = new EstudanteImpl();
				est.setId(id);
				Estudante t =  (Estudante) ServiceLocator.instance().getEstudanteHandlerBI().selectEstudante(est).get(0);
				
				estudantes.add(new EstudanteVO(t.getId(),t.getMatricula(), t.getNome()));
				
				ServiceLocator.instance().getEstudanteHandlerBI().deleteEstudante(t);
			
			
			}
			return estudantes;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
	}
	
	/**
	 * Escape an html string. Escaping data received from the client helps to
	 * prevent cross-site script vulnerabilities.
	 * 
	 * @param html the html string to escape
	 * @return the escaped string
	 */
	private String escapeHtml(String html) {
		if (html == null) {
			return null;
		}
		return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;");
	}
	
}

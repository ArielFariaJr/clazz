package sn.server.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sn.chain.impl.AvailableCommand;
import sn.chain.impl.Chain;
import sn.chain.impl.IDchain;
import sn.chain.impl.InjectCheck;
import sn.chain.impl.StoreCommand;
import sn.server.command.Command;
import sn.server.command.CommandMapper;
import sn.session.SessionManager;
import xingu.container.Inject;

public class ApiServlet extends SocialNetworkServletSupport {
	@Inject
	private CommandMapper mapper;

	@Inject
	private SessionManager sessions;

	@Override
	protected Object process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * TODO: Trabalho
		 * 
		 * Implementar as seguintes operaçoes com Chain of Responsability 1.
		 * Verificar se o comando pode ser executado 2. Logar a execucao do
		 * comando 3. Verificar a presença de SQL Injection nos parametros
		 * antes da execucao do commando
		 *
		 */
		
		//Adding the chain's responsibilities
		Chain chains = new StoreCommand();
		chains.setNext(new InjectCheck());
		chains.setNext(new AvailableCommand());
		
		String path   = request.getPathInfo();
		String allURL = getFullURL(request); 
		
		//Performing the responsibilities
		chains.efetuarCheck(IDchain.storeCommand, allURL);
		chains.efetuarCheck(IDchain.injectCheck, allURL);
		chains.efetuarCheck(IDchain.availableCommand, path);
		
		
		String token = request.getParameter("token");
		sessions.userFor(token);

		Command command = mapper.translate(request);
		return command.execute();

	}
	
	private String getFullURL(HttpServletRequest request) {
	    StringBuffer requestURL = request.getRequestURL();
	    String queryString = request.getQueryString();

	    if (queryString == null) {
	        return requestURL.toString();
	    } else {
	        return requestURL.append('?').append(queryString).toString();
	    }
	}
}
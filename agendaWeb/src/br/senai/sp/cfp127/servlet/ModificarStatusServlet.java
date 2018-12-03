package br.senai.sp.cfp127.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.sp.cfp127.dao.CompromissoDao;
import br.senai.sp.cfp127.model.Compromisso;

@WebServlet("/ModificarStatusServlet")
public class ModificarStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ModificarStatusServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CompromissoDao dao = new CompromissoDao();
		int status = Integer.parseInt(request.getParameter("status"));
		int codCompromisso = Integer.parseInt(request.getParameter("cod_compromisso"));
		
		if(dao.cancelarCompromisso(status, codCompromisso)) {
			response.sendRedirect("compromissos.jsp");
		}else {
			System.out.println("DEU ERRRRRRRROOOOOOOOO");
		}
		
	}

}

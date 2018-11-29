package br.senai.sp.cfp127.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.sp.cfp127.model.Compromisso;

@WebServlet("/AtualizarCompromissoServlet")
public class AtualizarCompromissoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AtualizarCompromissoServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Compromisso compromisso = new Compromisso();
		compromisso.setCodCompromisso(Integer.parseInt(request.getParameter("txt-cod")));
		compromisso.setTituloCompromisso(request.getParameter("txt-titulo"));
	}

}

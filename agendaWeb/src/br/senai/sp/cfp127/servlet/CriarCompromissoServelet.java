package br.senai.sp.cfp127.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.sp.cfp127.dao.CompromissoDao;
import br.senai.sp.cfp127.dao.ContatoDao;
import br.senai.sp.cfp127.model.Compromisso;
import br.senai.sp.cfp127.model.Contato;
import br.senai.sp.cfp127.model.Usuario;

/**
 * Servlet implementation class CriarCompromissoServelet
 */
@WebServlet("/CriarCompromissoServelet")
public class CriarCompromissoServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CriarCompromissoServelet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Compromisso compromisso = new Compromisso();
		
		Usuario usuario = new Usuario();
		
		usuario = (Usuario) request.getSession().getAttribute("usuario");
		
		compromisso.setUsuario(usuario);
		compromisso.setTituloCompromisso(request.getParameter("txt-titulo"));
		compromisso.setDataCompromisso(request.getParameter("txt-data"));
		compromisso.setHoraInicio(request.getParameter("txt-horaInicio"));
		compromisso.setHoraFim(request.getParameter("txt-horaFim"));
		compromisso.setNivelPrioridade(Integer.parseInt(request.getParameter("cmb-prioridade")));
		compromisso.setDescriçãoCompromisso(request.getParameter("txt-descricao").trim());
		
		CompromissoDao dao = new CompromissoDao();
		
		if(dao.gravar(compromisso)){
			response.sendRedirect("contatos.jsp");
		}else {
			response.sendRedirect("cadastroContato.jsp");
		}
	}
	

}

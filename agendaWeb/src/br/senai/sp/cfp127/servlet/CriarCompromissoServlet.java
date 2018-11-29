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


@WebServlet("/CriarCompromissoServlet")
public class CriarCompromissoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CriarCompromissoServlet() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Compromisso compromisso = new Compromisso();
		
		Usuario usuario = new Usuario();
		
		usuario = (Usuario) request.getSession().getAttribute("usuario");
		
		compromisso.setUsuario(usuario);
		compromisso.setTituloCompromisso(request.getParameter("txt-titulo"));
		compromisso.setDataCompromisso(request.getParameter("txt-data"));
		compromisso.setHoraInicio(request.getParameter("txt-horaInicio"));
		compromisso.setHoraFim(request.getParameter("txt-horaFim"));
		compromisso.setNivelPrioridade(Integer.parseInt(request.getParameter("cmb-prioridade")));
		compromisso.setDescricaoCompromisso(request.getParameter("txt-descricao").trim());
		
		CompromissoDao dao = new CompromissoDao();
		dao.setCompromisso(compromisso);
		
		if(dao.gravar(compromisso)){
			response.sendRedirect("compromissos.jsp");
		}else {
			response.sendRedirect("cadastroCompromisso.jsp");
		}
	}
	

}

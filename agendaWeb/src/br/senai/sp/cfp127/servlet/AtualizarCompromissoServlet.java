package br.senai.sp.cfp127.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.sp.cfp127.dao.CompromissoDao;
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
		compromisso.setDataCompromisso(request.getParameter("txt-data"));
		compromisso.setHoraInicio(request.getParameter("txt-horaInicio"));
		compromisso.setHoraFim(request.getParameter("txt-horaFim"));
		compromisso.setNivelPrioridade(Integer.parseInt(request.getParameter("cmb-prioridade")));
		compromisso.setDescricaoCompromisso(request.getParameter("txt-descricao"));
		compromisso.setStatus(Integer.parseInt(request.getParameter("cmb-status")));
		
		CompromissoDao dao = new CompromissoDao();
		
		if(dao.atualizar(compromisso)){
			response.sendRedirect("compromissos.jsp");
		}else {
			System.out.println("ERRO NA ATUALIZAÇÃO");
		}	
		
	}

}

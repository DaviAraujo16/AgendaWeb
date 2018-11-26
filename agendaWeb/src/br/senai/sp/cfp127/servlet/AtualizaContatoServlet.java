package br.senai.sp.cfp127.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.sp.cfp127.dao.ContatoDao;
import br.senai.sp.cfp127.model.Contato;
import br.senai.sp.cfp127.model.Usuario;

@WebServlet("/AtualizaContatoServlet")
public class AtualizaContatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public AtualizaContatoServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Estou aqui!!!!!");
		
		Contato contato = new Contato();
		contato.setCodContato(Integer.parseInt((request.getParameter("txt-cod"))));
		contato.setNome(request.getParameter("txt-nome"));
		contato.setTelefone(request.getParameter("txt-telefone"));
		contato.setEmail(request.getParameter("txt-email"));
		contato.setEndereco(request.getParameter("txt-endereco"));
		//contato.setUsuario((Usuario)request.getSession().getAttribute("usuario"));
		
		ContatoDao dao = new ContatoDao();
		
		
		
		if(dao.atualizar(contato)){
			response.sendRedirect("contatos.jsp");
		}else {
			System.out.println("ERRO NA ATUALIZAÇÃO");
		}
		
		
	}

}

package br.senai.sp.cfp127.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.Session;

import br.senai.sp.cfp127.dao.ContatoDao;
import br.senai.sp.cfp127.model.Contato;
import br.senai.sp.cfp127.model.Usuario;

@WebServlet("/CriarContatoServlet")
public class CriarContatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CriarContatoServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Contato contato = new Contato();
		
		Usuario usuario = new Usuario();
		
		usuario = (Usuario) request.getSession().getAttribute("usuario");
		
		contato.setUsuario(usuario);
		contato.setNome(request.getParameter("txt-nome"));
		contato.setEmail(request.getParameter("txt-email"));
		contato.setTelefone(request.getParameter("txt-email"));
		contato.setEndereco(request.getParameter("txt-endereco"));
		
		
		ContatoDao dao = new ContatoDao();
		
		if(dao.gravar(contato)){
			response.sendRedirect("contatos.jsp");
		}else {
			response.sendRedirect("cadastroContato.jsp");
		}
	}

}

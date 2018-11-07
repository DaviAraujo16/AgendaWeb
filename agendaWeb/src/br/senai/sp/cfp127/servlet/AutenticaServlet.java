package br.senai.sp.cfp127.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.senai.sp.cfp127.dao.UsuarioDao;
import br.senai.sp.cfp127.model.Usuario;

@WebServlet("/AutenticaServlet")
public class AutenticaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AutenticaServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioDao dao = new UsuarioDao();
		Usuario usuario = new Usuario ();
		
		//Pega os valores digitados na caixa de texto (email e senha)
		usuario = dao.autenticar(request.getParameter("email"),request.getParameter("senha"));
		
		//variavel de sessão que contem todos os dados do usuario 
		HttpSession sessao = request.getSession();
				
		//sessão recebe o atributo usuario que recebe como valor a referência ao objeto usuario (com todas as suas informaçãoes)
		sessao.setAttribute("usuario", usuario);
				
		
		//Abaixo compara com codigo de usuario
		
		//Se o codigo do usuario for diferente de zero(logou)
		if(usuario.getCod() != 0) {
			//mande para a tela de resulta
			response.sendRedirect("index.jsp");
		}
		//Se não(não logou)
		else {
			//mande devolta para a tela de login
			response.sendRedirect("login.html");
		}
		
	}

}

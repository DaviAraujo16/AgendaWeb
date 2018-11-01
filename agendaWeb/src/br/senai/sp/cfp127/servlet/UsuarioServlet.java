package br.senai.sp.cfp127.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.sp.cfp127.dao.UsuarioDao;
import br.senai.sp.cfp127.model.Usuario;

@WebServlet("/UsuarioServlet")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public UsuarioServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Estou aqui!!!!!");
		
		//Cria um novo Usuario 
		Usuario u  = new Usuario();
		
		//Pega os dados do formulario e definiu os atributos do usuario
		u.setNome(request.getParameter("txt-nome"));
		u.setEmail(request.getParameter("txt-email"));
		u.setSenha(request.getParameter("txt-senha1"));
		u.setDtNascimento(request.getParameter("txt-nascimento"));
		u.setSexo(request.getParameter("txt-sexo"));
		
		//Cria um usuarioDao
		UsuarioDao dao = new UsuarioDao();
	
		//Passa como usuario para salvar "u"
		dao.setUsuario(u);
	
		//Chama o metodo gravar
		if (dao.gravar()) {
			response.sendRedirect("successo.html");
		}else {
			response.sendRedirect("login.html");
		}
	}

}

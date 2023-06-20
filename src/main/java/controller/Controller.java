package controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DAO;
import model.JavaBeans;
import model.Aluno;

@WebServlet(urlPatterns = { "/main", "/insert", "/select", "/update", "/delete", "/alunos", "/insertAluno","/selectAluno" ,"/updateAluno", "/deleteAluno" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	JavaBeans turma = new JavaBeans();
	Aluno aluno = new Aluno();

	public Controller() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		// teste conexao
		// dao.testeConexao();
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			turmas(request, response);
		} else if (action.equals("/insert")) {
			novaTurma(request, response);
		} else if (action.equals("/select")) {
			listarTurma(request, response);
		} else if (action.equals("/update")) {
			editarTurma(request, response);
		} else if (action.equals("/delete")) {
			removerTurma(request, response);
		} else if (action.equals("/alunos")) {
			alunos(request, response);
		} else if (action.equals("/insertAluno")) {
			novoAluno(request, response);
		} else if (action.equals("/selectAluno")) {
			listarAlunos(request, response);
		} else if (action.equals("/updateAluno")) {
			editarAluno(request, response);
		} else if (action.equals("/deleteAluno")) {
			removerAluno(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	// Listar turmas
	protected void turmas(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.sendRedirect("turma.jsp");
		// criando um obj que ira receber os dados javabeans
		ArrayList<JavaBeans> lista = dao.listarTurmas();
		// teste da lista
		/*
		 * for (int i = 0; i < lista.size(); i++) {
		 * System.out.println(lista.get(i).getId());
		 * System.out.println(lista.get(i).getNome());
		 * System.out.println(lista.get(i).getTurno()); }
		 */

		// encaminhar a lista ao documento turma.jsp
		request.setAttribute("turmas", lista);
		RequestDispatcher rd = request.getRequestDispatcher("turma.jsp");
		rd.forward(request, response);
	}

	// criar turma
	protected void novaTurma(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// System.out.println(request.getParameter("nome"));
		// System.out.println(request.getParameter("turno"));

		// setando variaveis javabeans
		turma.setNome(request.getParameter("nome"));
		turma.setTurno(request.getParameter("turno"));
		dao.inserirTurma(turma);

		// redirecionando
		response.sendRedirect("main");

	}

	protected void listarTurma(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		turma.setId(id);
		// executar selecionar contato
		dao.selecionarTurma(turma);
		// teste recebimento
		/*
		 * System.out.println(turma.getId()); System.out.println(turma.getNome());
		 * System.out.println(turma.getTurno());
		 */

		// setar os atributos do formulario com o conteudo javabeans
		request.setAttribute("id", turma.getId());
		request.setAttribute("nome", turma.getNome());
		request.setAttribute("turno", turma.getTurno());
		// encaminhar ao documento editar.jsp
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
	}

	protected void editarTurma(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// teste de recebimento
		/*
		 * System.out.println(request.getParameter("id"));
		 * System.out.println(request.getParameter("nome"));
		 * System.out.println(request.getParameter("turma"));
		 */

		// settar as variaveis javabeans
		turma.setId(Integer.parseInt(request.getParameter("id")));
		turma.setNome(request.getParameter("nome"));
		turma.setTurno(request.getParameter("turno"));
		// executatndo alterar turma
		dao.alterarTurma(turma);
		// redurecionando para turma.jsp atualizando alteracoes
		response.sendRedirect("main");
	}

	protected void removerTurma(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// recebiomento do id da turma atraves do js (confirmador)
		String id = request.getParameter("id");
		// System.out.println(id); // teste pra saber se o id vem
		// setando a variavel id javabeans
		turma.setId(Integer.parseInt(id));
		// executar o metodo deletar turma passando objeto turma
		dao.deletarTurma(turma);
		// redurecionando para turma.jsp atualizando alteracoes
		response.sendRedirect("main");

	}

	// aluno

	protected void alunos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// response.sendRedirect("alunos.jsp");
		// criando um obj que ira receber os dados javabeans
		ArrayList<Aluno> lista = dao.listarAlunos();
		// teste da lista

		// for (int i = 0; i < lista.size(); i++) {
		// System.out.println(lista.get(i).getMatricula());
		// System.out.println(lista.get(i).getNome());
		// System.out.println(lista.get(i).getTurma()); }

		// encaminhar a lista ao documento alunos.jsp
		request.setAttribute("alunos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("alunos.jsp");
		rd.forward(request, response);
	}

	protected void novoAluno(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// System.out.println(request.getParameter("nome"));
		// System.out.println(request.getParameter("turno"));

		// setando variaveis javabeans
		aluno.setNome(request.getParameter("nome"));
		aluno.setTurma(Integer.parseInt(request.getParameter("turma")));
		dao.inserirAluno(aluno);

		// redirecionando
		response.sendRedirect("alunos");

	}

	protected void listarAlunos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		aluno.setMatricula(id);
		// executar selecionar aluno
		dao.selecionarAluno(aluno);

		// setar os atributos do formulario com o conteudo javabeans
		request.setAttribute("id", aluno.getMatricula());
		request.setAttribute("nome", aluno.getNome());
		request.setAttribute("turma", aluno.getTurma());
		// encaminhar ao documento editarAluno.jsp
		RequestDispatcher rd = request.getRequestDispatcher("editarAluno.jsp");
		rd.forward(request, response);
	}

	protected void editarAluno(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println(request.getParameter("id"));
		System.out.println(request.getParameter("nome"));
		System.out.println(request.getParameter("turma"));

		aluno.setMatricula(Integer.parseInt(request.getParameter("id")));
		aluno.setNome(request.getParameter("nome"));
		aluno.setTurma(Integer.parseInt(request.getParameter("turma")));
		// executatndo alterar turma
		dao.alterarAluno(aluno);
		// redurecionando para alunos.jsp atualizando alteracoes
		response.sendRedirect("alunos");
	}
	
	
	protected void removerAluno(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// recebiomento do id do aluno atraves do js (confirmador)
		String id = request.getParameter("id");
		// System.out.println(id); // teste pra saber se o id vem
		// setando a variavel id javabeans
		aluno.setMatricula(Integer.parseInt(id));
		// executar o metodo deletar turma passando objeto turma
		dao.deletarAluno(aluno);
		// redurecionando para turma.jsp atualizando alteracoes
		response.sendRedirect("alunos");

	}
}

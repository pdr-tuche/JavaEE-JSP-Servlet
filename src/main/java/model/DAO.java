package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	// conexao
	// parametros de conexao
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/escola?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "root";
	// metodo de conexao

	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public void testeConexao() {
		try {
			Connection con = conectar();
			System.out.println(con);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void inserirTurma(JavaBeans turma) {
		String create = "insert into turma (nome, turno) values (?,?)";

		try {
			// abrir conexao
			Connection con = conectar();
			// preparar query para execucao no db
			PreparedStatement pst = con.prepareStatement(create);
			// substituindo parametros (?) pelo conteudo do java bens
			pst.setString(1, turma.getNome());
			pst.setString(2, turma.getTurno());
			// executantdo query
			pst.executeUpdate(); // comando que insere no db
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public ArrayList<JavaBeans> listarTurmas() {
		// criando um obj para acessar a classe javabens
		ArrayList<JavaBeans> turmas = new ArrayList<>();
		String read = "select * from turma order by nome";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery(); // result set faz parte do jdbc e usado para guardar o retorno do db
												// temporariamente
			// laço executado enquanto houver turmas
			while (rs.next()) {
				// variaveis de apoio que recevem daddos do banco
				String id = rs.getString(1);
				String nome = rs.getString(2);
				String turno = rs.getString(3);
				// populando o arraylist
				turmas.add(new JavaBeans(Integer.parseInt(id), nome, turno));
			}
			con.close();
			return turmas;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public void selecionarTurma(JavaBeans turma) {
		String read2 = "select * from turma where id = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setInt(1, turma.getId());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				turma.setId(rs.getInt(1));
				turma.setNome(rs.getString(2));
				turma.setTurno(rs.getString(3));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void alterarTurma(JavaBeans turma) {
		String create = "update turma set nome=?, turno=? where id = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, turma.getNome());
			pst.setString(2, turma.getTurno());
			pst.setInt(3, turma.getId());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void deletarTurma(JavaBeans turma) {
		String delete = "delete from turma where id = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setInt(1, turma.getId());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}

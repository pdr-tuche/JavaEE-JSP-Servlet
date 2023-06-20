package model;

public class JavaBeans {
	private int id;
	private String turno;
	private String nome;
	
	
	
	public JavaBeans() {
		super();
	}
	
	
	public JavaBeans(int id, String turno, String nome) {
		super();
		this.id = id;
		this.turno = turno;
		this.nome = nome;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTurno() {
		return turno;
	}


	public void setTurno(String turno) {
		this.turno = turno;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}

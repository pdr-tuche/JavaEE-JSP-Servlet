package model;

public class Aluno {
	private int matricula;
	private String nome;
	private int turma;

	public Aluno() {
		super();

	}

	public Aluno(int matricula, String nome, int turma) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.turma = turma;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTurma() {
		return turma;
	}

	public void setTurma(int turma) {
		this.turma = turma;
	}

}

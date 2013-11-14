package br.com.sesc.virtualtrainersesc.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the aluno database table.
 * 
 */
@Entity
@Table(name="aluno")
@NamedQueries({
	@NamedQuery(
	name = "Aluno.findByMatricula",
	query = "FROM Aluno al WHERE al.matricula=:matricula"
	),
	@NamedQuery(
	name = "Aluno.findByMatriculaSenha",
	query = "FROM Aluno al WHERE al.matricula = :matricula AND al.senha = :senha"
	)	
})
public class Aluno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "alu")
	@SequenceGenerator(name = "alu", sequenceName = "aluno_id_seq",allocationSize=1) 
	private Integer matricula;

	private int idade;

	private String nome;

	private BigDecimal peso;

	private String senha;

	//bi-directional many-to-one association to Treino
	@OneToMany(mappedBy="aluno")
	private List<Treino> treinos;

	public Aluno() {
	}

	public Integer getMatricula() {
		return this.matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public int getIdade() {
		return this.idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPeso() {
		return this.peso;
	}

	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Treino> getTreinos() {
		return this.treinos;
	}

	public void setTreinos(List<Treino> treinos) {
		this.treinos = treinos;
	}

	@Override
	public String toString() {
		return "Aluno [matricula=" + matricula + ", idade=" + idade + ", nome="
				+ nome + ", peso=" + peso + ", senha=" + senha + "]";
	}


}
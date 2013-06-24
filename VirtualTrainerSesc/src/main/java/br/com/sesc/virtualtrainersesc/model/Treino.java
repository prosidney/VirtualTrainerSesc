package br.com.sesc.virtualtrainersesc.model;

import static javax.persistence.GenerationType.AUTO;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the treino database table.
 * 
 */
@Entity
@Table(name="treino")
@NamedQueries({
	@NamedQuery(
	name = "Treino.findById",
	query = "FROM Treino tr WHERE tr.id=:id"
	),
	@NamedQuery(
	name = "Treino.findByAlunoMatricula",
	query = "FROM Treino tr WHERE tr.aluno.matricula = :matricula"
	)	
})
public class Treino implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=AUTO)
	private Integer id;

	private Integer qtde;
	
	@Column(name="QTDE_TOTAL")
	private Integer qtdeTotal;
	
	private String nome;

	//bi-directional many-to-one association to Exercicio
	@OneToMany(mappedBy="treino")
	private List<Exercicio> exercicios;

	//bi-directional many-to-one association to Aluno
	@ManyToOne
	private Aluno aluno;

	public Treino() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQtde() {
		return this.qtde;
	}

	public void setQtde(Integer qtde) {
		this.qtde = qtde;
	}

	public List<Exercicio> getExercicios() {
		return this.exercicios;
	}

	public void setExercicios(List<Exercicio> exercicios) {
		this.exercicios = exercicios;
	}

	public Aluno getAluno() {
		return this.aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getQtdeTotal() {
		return qtdeTotal;
	}

	public void setQtdeTotal(Integer qtdeTotal) {
		this.qtdeTotal = qtdeTotal;
	}
	
	public Integer getPorcetagemConcluido(){
		if(qtde != null && qtdeTotal != null && qtde > 0 && qtdeTotal > 0){
			Double d = (qtde.doubleValue()/qtdeTotal.doubleValue())*100;
			
			return d.intValue();
		}
		
		return 0;
	}
	
	@Override
	public String toString() {
		return "Treino [id=" + id + ", qtde=" + qtde + ", exercicios="
				+ exercicios + ", aluno=" + aluno + "]";
	}
}
package br.com.sesc.virtualtrainersesc.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the exercicio database table.
 * 
 */
@Entity
@Table(name="exercicio")
public class Exercicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String equipamento;

	private String execucao;

	private String musculatura;

	private String qualidade;

	//bi-directional many-to-one association to Treino
	@ManyToOne
	@JoinColumn(name="TREINO_ID")
	private Treino treino;

	public Exercicio() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEquipamento() {
		return this.equipamento;
	}

	public void setEquipamento(String equipamento) {
		this.equipamento = equipamento;
	}

	public String getExecucao() {
		return this.execucao;
	}

	public void setExecucao(String execucao) {
		this.execucao = execucao;
	}

	public String getMusculatura() {
		return this.musculatura;
	}

	public void setMusculatura(String musculatura) {
		this.musculatura = musculatura;
	}

	public String getQualidade() {
		return this.qualidade;
	}

	public void setQualidade(String qualidade) {
		this.qualidade = qualidade;
	}

	public Treino getTreino() {
		return this.treino;
	}

	public void setTreino(Treino treino) {
		this.treino = treino;
	}

	@Override
	public String toString() {
		return "Exercicio [id=" + id + ", equipamento=" + equipamento
				+ ", execucao=" + execucao + ", musculatura=" + musculatura
				+ ", qualidade=" + qualidade + "]";
	}
}
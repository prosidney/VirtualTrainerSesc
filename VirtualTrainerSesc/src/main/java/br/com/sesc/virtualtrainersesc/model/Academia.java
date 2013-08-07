package br.com.sesc.virtualtrainersesc.model;

import java.io.Serializable;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the academia database table.
 * 
 */
@Entity
@Table(name="academia")
public class Academia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "acad")
	@SequenceGenerator(name = "acad", sequenceName = "academia_id_seq",allocationSize=1)    
	private Integer id;

	@Column(name="capacidade_total")
	private int capacidadeTotal;

	@Column(name="hora_abertura")
	private Time horaAbertura;

	@Column(name="hora_fechamento")
	private Time horaFechamento;

	private String nome;

	public Academia() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getCapacidadeTotal() {
		return this.capacidadeTotal;
	}

	public void setCapacidadeTotal(int capacidadeTotal) {
		this.capacidadeTotal = capacidadeTotal;
	}

	public Time getHoraAbertura() {
		return this.horaAbertura;
	}

	public void setHoraAbertura(Time horaAbertura) {
		this.horaAbertura = horaAbertura;
	}

	public Time getHoraFechamento() {
		return this.horaFechamento;
	}

	public void setHoraFechamento(Time horaFechamento) {
		this.horaFechamento = horaFechamento;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Academia [id=" + id + ", capacidadeTotal=" + capacidadeTotal
				+ ", horaAbertura=" + horaAbertura + ", horaFechamento="
				+ horaFechamento + ", nome=" + nome + "]";
	}
}
package example.repository;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Produto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3062879090141569923L;
	@Id
	private int id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "categoria")
	private String categoria;
	@Column(name = "valor")
	private double valor;

	public Produto() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}

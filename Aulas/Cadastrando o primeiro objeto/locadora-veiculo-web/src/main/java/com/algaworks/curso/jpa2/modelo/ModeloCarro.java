package com.algaworks.curso.jpa2.modelo;

import com.algaworks.curso.jpa2.modelo.Fabricante;
import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import javax.persistence.*;

@Entity
public class ModeloCarro implements Serializable {

	private Long codigo;
	private String descricao;
	private Fabricante fabricante;
	private static final long serialVersionUID = 1L;

	public ModeloCarro() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}   
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}   
	public Fabricante getFabricante() {
		return this.fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}
}
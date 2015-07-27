package com.algaworks.curso.jpa2.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.algaworks.curso.jpa2.dao.ModeloCarroDAO;
import com.algaworks.curso.jpa2.modelo.ModeloCarro;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class CadastroModeloCarroService implements Serializable {
private static final long serialVersionUID = 2375373572714541176L;

	@Inject
	ModeloCarroDAO modeloCarroDAO;
	
	@Transactional
	public void salvar(ModeloCarro modeloCarro) throws NegocioException{
		if(modeloCarro.getDescricao() == null || modeloCarro.getDescricao().trim().equals("")){
			throw new NegocioException("O nome é obrigatório.");
		}
		if(modeloCarro.getFabricante() == null){
			throw new NegocioException("O fabricante é obrigatório");
		}
		this.modeloCarroDAO.salvar(modeloCarro);
	}
}
package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.dao.FabricanteDAO;
import com.algaworks.curso.jpa2.modelo.Fabricante;
import com.algaworks.curso.jpa2.modelo.ModeloCarro;
import com.algaworks.curso.jpa2.service.CadastroModeloCarroService;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroModeloCarroBean implements Serializable {
private static final long serialVersionUID = 85315315466450259L;

	private ModeloCarro modeloCarro;
	
	private List<Fabricante> fabricantes;
	
	@Inject
	private CadastroModeloCarroService cadastroModeloCarroService;
	
	@Inject
	private FabricanteDAO fabricanteDAO;
	
	public void salvar(){
		try{
			this.cadastroModeloCarroService.salvar(modeloCarro);
			FacesUtil.addSuccessMessage("Modelo de carro salvo com sucesso!");
		}catch(NegocioException e){
			FacesUtil.addErrorMessage(e.getMessage());
		}
		this.limpar();
	}
	@PostConstruct
	public void inicializar(){
		this.limpar();
		this.fabricantes = fabricanteDAO.buscarTodos();
	}
	public void limpar(){
		this.modeloCarro = new ModeloCarro();
	}
	
	public ModeloCarro getModeloCarro() {
		return modeloCarro;
	}
	public void setModeloCarro(ModeloCarro modeloCarro) {
		this.modeloCarro = modeloCarro;
	}
	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}
	public void setFabricantes(List<Fabricante> fabricantes) {
		this.fabricantes = fabricantes;
	}
	public CadastroModeloCarroService getCadastroModeloCarroService() {
		return cadastroModeloCarroService;
	}
	public void setCadastroModeloCarroService(CadastroModeloCarroService cadastroModeloCarroService) {
		this.cadastroModeloCarroService = cadastroModeloCarroService;
	}
	public FabricanteDAO getFabricanteDAO() {
		return fabricanteDAO;
	}
	public void setFabricanteDAO(FabricanteDAO fabricanteDAO) {
		this.fabricanteDAO = fabricanteDAO;
	}

}
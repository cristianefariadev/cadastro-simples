package com.form.bo;

import java.util.List;

import com.form.entidade.Produto;
import com.form.po.ProdutoPO;

public class ProdutoBO {
	private ProdutoPO po;

	public ProdutoBO() {
		po = new ProdutoPO();
	}
	
	public boolean salvar(Produto objeto){
		if (objeto.getId() == 0) {
			return po.adicionar(objeto);
		} else {
			return po.atualizar(objeto);
		}
	}
	
	public boolean deletar(int id){
		return po.deletar(id);
	}
	public List<Produto> listar(){
		return po.listar();
	}
	public Produto consultar(int id) {
		return po.consultar(id);
	}
}

package com.form.bo;

import java.util.List;

import com.form.entidade.Fornecedor;
import com.form.po.FornecedorPO;

public class FornecedorBO {

	private FornecedorPO po;

	public FornecedorBO() {
		po = new FornecedorPO();
	}

	public boolean validarCnpj() {
		return true;
	}

	public boolean salvar(Fornecedor objeto) {
		if (objeto.getId() == 0) {
			return po.adicionar(objeto);
		} else {
			return po.atualizar(objeto);
		}
	}

	public boolean deletar(int id) {
		return po.deletar(id);
	}

	public List<Fornecedor> listar() {
		return po.listar();
	}

	public Fornecedor consultar(int id) {
		return po.consultar(id);
	}
}

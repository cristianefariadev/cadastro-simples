package com.form.bo;

import java.util.List;

import com.form.entidade.Pessoa;
import com.form.po.PessoaPO;

public class PessoaBO {
	
	private PessoaPO po;

	public PessoaBO() {
		po = new PessoaPO();
	}
	
	public boolean validaCpf(){
		return true;
	}
	
	public boolean validaDataNascimento(){
		return true;
	}
	
	public boolean salvar(Pessoa objeto){
		if (objeto.getId() == 0) {
			return po.adicionar(objeto);
		} else {
			return po.atualizar(objeto);
		}
	}
	
	public boolean deletar(int id){
		return po.deletar(id);
	}
	public List<Pessoa> listar(){
		return po.listar();
	}
	public Pessoa consultar(int id) {
		return po.consultar(id);
	}
}

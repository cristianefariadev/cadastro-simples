package com.form.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.form.bo.FornecedorBO;
import com.form.entidade.Fornecedor;
import com.form.po.FornecedorPO;

@WebServlet("/FornecedorController")
public class FornecedorController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static String FORNECEDOR = "/fornecedor.jsp";
	private FornecedorPO po;
	private FornecedorBO bo;

	public FornecedorController() {
		po = new FornecedorPO();
		bo = new FornecedorBO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String caminho = "";
		String botao = request.getParameter("action");

		if (botao.equalsIgnoreCase("deletar")) {
			int id = Integer.parseInt(request.getParameter("id"));
			po.deletar(id);
			caminho = FORNECEDOR;
			request.setAttribute("lista", po.listar());
			
		} else if (botao.equalsIgnoreCase("editar")) {
			caminho = FORNECEDOR;
			int id = Integer.parseInt(request.getParameter("id"));
			Fornecedor objeto = po.consultar(id);
			request.setAttribute("inserir", objeto);
			request.setAttribute("lista", po.listar());
			
		} else if (botao.equalsIgnoreCase("listar")) {
			caminho = FORNECEDOR;
			request.setAttribute("lista", po.listar());
			
		} else {
			caminho = FORNECEDOR;
		}

		RequestDispatcher view = request.getRequestDispatcher(caminho);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Fornecedor objeto = new Fornecedor();
		objeto.setRazaoSocial(request.getParameter("razaoSocial"));
		objeto.setNomeFantasia(request.getParameter("nomeFantasia"));
		objeto.setInscricaoEstadual(request.getParameter("inscricaoEstadual"));
		objeto.setCnpj(request.getParameter("cnpj"));
		objeto.setResponsavelLegal(request.getParameter("responsavelLegal"));
		objeto.setTelefone(request.getParameter("telefone"));
		objeto.setEmail(request.getParameter("email"));
		objeto.setLogradouro(request.getParameter("logradouro"));
		objeto.setBairro(request.getParameter("bairro"));
		objeto.setCidade(request.getParameter("cidade"));
		objeto.setCep(request.getParameter("cep"));
		objeto.setEstado(request.getParameter("estado"));
		objeto.setObservacao(request.getParameter("observacao"));
		
		String id = request.getParameter("id");
		 		if (id == null || id.isEmpty()) {
		 			bo.salvar(objeto);
		 		} else {
		 			objeto.setId(Integer.parseInt(id));
		 			bo.salvar(objeto);
		 		}

		RequestDispatcher view = request.getRequestDispatcher(FORNECEDOR);
		request.setAttribute("lista", po.listar());
		view.forward(request, response);
	}
}

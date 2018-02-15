package com.form.controller;

	import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.form.bo.ProdutoBO;
import com.form.entidade.Produto;
import com.form.po.ProdutoPO;

	@WebServlet("/ProdutoController")
	public class  ProdutoController extends HttpServlet {

		private static final long serialVersionUID = 1L;
		private static String PRODUTO = "/produto.jsp";
		private ProdutoPO po;
		private ProdutoBO bo;

		public ProdutoController() {
			po = new ProdutoPO();
			bo = new ProdutoBO();
		}

		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			String caminho = "";
			String action = request.getParameter("action");

			//se acao igual a deletar 
			if (action.equalsIgnoreCase("deletar")) {
				int id = Integer.parseInt(request.getParameter("id"));
				po.deletar(id);
				caminho = PRODUTO;
				request.setAttribute("lista", po.listar());
				
			} else if (action.equalsIgnoreCase("editar")) {
				caminho = PRODUTO;
				int id = Integer.parseInt(request.getParameter("id"));
				Produto objeto = po.consultar(id);
				request.setAttribute("inserir", objeto);
				request.setAttribute("lista", po.listar());
				
			} else if (action.equalsIgnoreCase("listar")) {
				caminho = PRODUTO;
				request.setAttribute("lista", po.listar());
				
			} else {
				caminho = PRODUTO;
			}
			RequestDispatcher view = request.getRequestDispatcher(caminho);
			view.forward(request, response);
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			
			Produto objeto = new Produto();
			objeto.setDescricao(request.getParameter("descricao"));
			objeto.setPreco(Float.parseFloat(request.getParameter("preco")));
			objeto.setMarca(request.getParameter("marca"));
			objeto.setModelo(request.getParameter("modelo"));
			objeto.setCategoria(request.getParameter("categoria"));
			objeto.setSubCategoria(request.getParameter("subCategoria"));
			
			String id = request.getParameter("id");
	 		if (id == null || id.isEmpty()) {
	 			bo.salvar(objeto);
	 		} else {
	 			objeto.setId(Integer.parseInt(id));
	 			bo.salvar(objeto);
	 		}
			
			RequestDispatcher view = request.getRequestDispatcher(PRODUTO);
			request.setAttribute("lista", po.listar());
			view.forward(request, response);
		}
	}

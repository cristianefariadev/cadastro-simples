package com.form.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.form.bo.PessoaBO;
import com.form.entidade.Pessoa;
import com.form.po.PessoaPO;

@WebServlet("/PessoaController")
public class PessoaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String PESSOA = "/cliente.jsp";
	private PessoaPO dao;
	private PessoaBO bo;

	public PessoaController() {
		dao = new PessoaPO();
		bo = new PessoaBO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String caminho = "";
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("deletar")) {
			int id = Integer.parseInt(request.getParameter("id"));
			dao.deletar(id);
			caminho = PESSOA;
			request.setAttribute("lista", dao.listar());

		} else if (action.equalsIgnoreCase("editar")) {
			caminho = PESSOA;
			int id = Integer.parseInt(request.getParameter("id"));
			Pessoa objeto = dao.consultar(id);
			request.setAttribute("inserir", objeto);
			request.setAttribute("lista", dao.listar());

		} else if (action.equalsIgnoreCase("listar")) {
			caminho = PESSOA;
			request.setAttribute("lista", bo.listar());

		} else {
			caminho = PESSOA;
		}

		RequestDispatcher view = request.getRequestDispatcher(caminho);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Pessoa objeto = new Pessoa();
		objeto.setNome(request.getParameter("nome"));
		try {
            Date dataNascimento = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("dataNascimento"));
            objeto.setDataNascimento(dataNascimento);
        } catch (ParseException erro) {
            erro.printStackTrace();
        }
		objeto.setCpf(request.getParameter("cpf"));
		objeto.setRg(request.getParameter("rg"));
		objeto.setCelular(request.getParameter("celular"));
		objeto.setEmail(request.getParameter("email"));
		objeto.setLogradouro(request.getParameter("logradouro"));
		objeto.setBairro(request.getParameter("bairro"));
		objeto.setCep(request.getParameter("cep"));
		objeto.setCidade(request.getParameter("cidade"));
		objeto.setEstado(request.getParameter("estado"));

		String id = request.getParameter("id");
 		if (id == null || id.isEmpty()) {
 			bo.salvar(objeto);
 		} else {
 			objeto.setId(Integer.parseInt(id));
 			bo.salvar(objeto);
 		}
		
		RequestDispatcher view = request.getRequestDispatcher(PESSOA);
		request.setAttribute("lista", dao.listar());
		view.forward(request, response);
	}
}

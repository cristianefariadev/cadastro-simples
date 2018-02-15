package com.form.po;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.form.entidade.Fornecedor;
import com.form.util.ConexaoUtil;

public class FornecedorPO {
	private Connection connection;

	public boolean adicionar(Fornecedor objeto) {
		
		try {
			connection = ConexaoUtil.getConnection();
			PreparedStatement ps = connection
					.prepareStatement("insert into fornecedor(razao_social, nome_fantasia, inscricao_estadual"
							+ ", cnpj,  responsavel_legal, telefone, email, logradouro, bairro, cep, cidade, estado, observacao)"
							+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			ps.setString(1, objeto.getRazaoSocial());
			ps.setString(2, objeto.getNomeFantasia());
			ps.setString(3, objeto.getInscricaoEstadual());
			ps.setString(4, objeto.getCnpj());
			ps.setString(5, objeto.getResponsavelLegal());
			ps.setString(6, objeto.getTelefone());
			ps.setString(7, objeto.getEmail());
			ps.setString(8, objeto.getLogradouro());
			ps.setString(9, objeto.getBairro());
			ps.setString(10, objeto.getCep());
			ps.setString(11, objeto.getCidade());
			ps.setString(12, objeto.getEstado());
			ps.setString(13, objeto.getObservacao());	
			ps.executeUpdate();
			
			ps.close();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deletar(int id) {
		try {
			connection = ConexaoUtil.getConnection();
			PreparedStatement ps = connection
					.prepareStatement("delete from fornecedor where id=?");
			ps.setInt(1, id);
			ps.executeUpdate();

			ps.close();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean atualizar(Fornecedor objeto) {
		
		try {
			connection = ConexaoUtil.getConnection();
			PreparedStatement ps = connection
					.prepareStatement("update fornecedor set razao_social=?, nome_fantasia=?, inscricao_estadual=?, "
							+ "cnpj=?, responsavel_legal=?, telefone=?, email=?,  logradouro=?, bairro=?, cep=?, cidade=?, estado=?, observacao=? where id=?");
			
			ps.setString(1, objeto.getRazaoSocial());
			ps.setString(2, objeto.getNomeFantasia());
			ps.setString(3, objeto.getInscricaoEstadual());
			ps.setString(4, objeto.getCnpj());
			ps.setString(5, objeto.getResponsavelLegal());
			ps.setString(6, objeto.getTelefone());
			ps.setString(7, objeto.getEmail());
			ps.setString(8, objeto.getLogradouro());
			ps.setString(9, objeto.getBairro());
			ps.setString(10, objeto.getCep());
			ps.setString(11, objeto.getCidade());
			ps.setString(12, objeto.getEstado());
			ps.setString(13, objeto.getObservacao());
			ps.setInt(14, objeto.getId());
			ps.executeUpdate();
			
			ps.close();
			
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Fornecedor> listar() {
		List<Fornecedor> lista = new ArrayList<Fornecedor>();
		try {
			connection = ConexaoUtil.getConnection();
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery("select * from fornecedor");
			
			while (rs.next()) {
				Fornecedor objeto = new Fornecedor();
				objeto.setId(rs.getInt("id"));
				objeto.setRazaoSocial(rs.getString("razao_social"));
				objeto.setNomeFantasia(rs.getString("nome_fantasia"));
				objeto.setInscricaoEstadual(rs.getString("inscricao_estadual"));
				objeto.setCnpj(rs.getString("cnpj"));
				objeto.setResponsavelLegal(rs.getString("responsavel_legal"));
				objeto.setTelefone(rs.getString("telefone"));
				objeto.setEmail(rs.getString("email"));
				objeto.setLogradouro(rs.getString("logradouro"));
				objeto.setBairro(rs.getString("bairro"));
				objeto.setCidade(rs.getString("cidade"));
				objeto.setCep(rs.getString("cep"));
				objeto.setEstado(rs.getString("estado"));
				objeto.setObservacao(rs.getString("observacao"));
				lista.add(objeto);
			}
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public Fornecedor consultar(int id) {
		Fornecedor objeto = new Fornecedor();
		try {
			connection = ConexaoUtil.getConnection();
			PreparedStatement ps = connection.
					prepareStatement("select * from fornecedor where id=?");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				objeto.setId(rs.getInt("id"));
				objeto.setRazaoSocial(rs.getString("razao_social"));
				objeto.setNomeFantasia(rs.getString("nome_fantasia"));
				objeto.setInscricaoEstadual(rs.getString("inscricao_estadual"));
				objeto.setCnpj(rs.getString("cnpj"));
				objeto.setResponsavelLegal(rs.getString("responsavel_legal"));
				objeto.setTelefone(rs.getString("telefone"));
				objeto.setEmail(rs.getString("email"));
				objeto.setLogradouro(rs.getString("logradouro"));
				objeto.setBairro(rs.getString("bairro"));
				objeto.setCidade(rs.getString("cidade"));
				objeto.setCep(rs.getString("cep"));
				objeto.setEstado(rs.getString("estado"));
				objeto.setObservacao(rs.getString("observacao"));
			}
			
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return new Fornecedor();
		}
		return objeto;
	}
}

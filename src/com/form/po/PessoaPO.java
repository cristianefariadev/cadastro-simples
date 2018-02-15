package com.form.po;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.form.entidade.Pessoa;
import com.form.util.ConexaoUtil;

public class PessoaPO {
	private Connection connection;

	public PessoaPO() {
		connection = ConexaoUtil.getConnection();
	}

	public boolean adicionar(Pessoa objeto) {
		try {
			PreparedStatement ps = connection
					.prepareStatement("insert into pessoa(nome, data_nascimento, cpf, "
							+ "rg, celular, email, logradouro, bairro, cep, cidade, estado)"
							+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			ps.setString(1, objeto.getNome());
			ps.setDate(2, new java.sql.Date(objeto.getDataNascimento().getTime()));
			ps.setString(3, objeto.getCpf());
			ps.setString(4, objeto.getRg());
			ps.setString(5, objeto.getCelular());
			ps.setString(6, objeto.getEmail());
			ps.setString(7, objeto.getLogradouro());
			ps.setString(8, objeto.getBairro());
			ps.setString(9, objeto.getCep());
			ps.setString(10, objeto.getCidade());
			ps.setString(11, objeto.getEstado());
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
			PreparedStatement ps = connection
					.prepareStatement("delete from pessoa where id=?");
			ps.setInt(1, id);
			ps.executeUpdate();
			
			ps.close();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean atualizar(Pessoa objeto) {
		try {
			PreparedStatement ps = connection
					.prepareStatement("update pessoa set nome=?, data_nascimento=?, cpf=?, "
							+ "rg=?, celular=?, email=?, logradouro=?, "
							+ "bairro=?, cep=?, cidade=?, estado=? where id=?");
			
			ps.setString(1, objeto.getNome());
			ps.setDate(2, new java.sql.Date(objeto.getDataNascimento().getTime()));
			ps.setString(3, objeto.getCpf());
			ps.setString(4, objeto.getRg());
			ps.setString(5, objeto.getCelular());
			ps.setString(6, objeto.getEmail());
			ps.setString(7, objeto.getLogradouro());
			ps.setString(8, objeto.getBairro());
			ps.setString(9, objeto.getCep());
			ps.setString(10, objeto.getCidade());
			ps.setString(11, objeto.getEstado());
			ps.setInt(12, objeto.getId());
			ps.executeUpdate();
			
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Pessoa> listar() {
		List<Pessoa> lista = new ArrayList<Pessoa>();
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery("select * from pessoa");
			
			while (rs.next()) {
				Pessoa objeto = new Pessoa();
				objeto.setId(rs.getInt("id"));
				objeto.setNome(rs.getString("nome"));
				objeto.setDataNascimento(rs.getDate("data_nascimento"));
				objeto.setCpf(rs.getString("cpf"));
				objeto.setRg(rs.getString("rg"));
				objeto.setCelular(rs.getString("celular"));
				objeto.setEmail(rs.getString("email"));
				objeto.setLogradouro(rs.getString("logradouro"));
				objeto.setBairro(rs.getString("bairro"));
				objeto.setCep(rs.getString("cep"));
				objeto.setCidade(rs.getString("cidade"));
				objeto.setEstado(rs.getString("estado"));
				lista.add(objeto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}
	
	public Pessoa consultar(int id) {
		Pessoa objeto = new Pessoa();
		try {
			PreparedStatement ps = connection.
					prepareStatement("select * from pessoa where id=?");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				objeto.setId(rs.getInt("id"));
				objeto.setNome(rs.getString("nome"));
				objeto.setDataNascimento(rs.getDate("data_nascimento"));
				objeto.setCpf(rs.getString("cpf"));
				objeto.setRg(rs.getString("rg"));
				objeto.setCelular(rs.getString("celular"));
				objeto.setEmail(rs.getString("email"));
				objeto.setLogradouro(rs.getString("logradouro"));
				objeto.setBairro(rs.getString("bairro"));
				objeto.setCep(rs.getString("cep"));
				objeto.setCidade(rs.getString("cidade"));
				objeto.setEstado(rs.getString("estado"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return objeto;
	}
}

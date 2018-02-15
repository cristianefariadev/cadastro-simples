package com.form.po;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.form.entidade.Produto;
import com.form.util.ConexaoUtil;

public class ProdutoPO {

			private Connection connection;

			public ProdutoPO() {
				connection = ConexaoUtil.getConnection();
			}

			public boolean adicionar(Produto objeto) {
				try {
					PreparedStatement ps = connection
							.prepareStatement("insert into produto(descricao, preco, marca, modelo"
									+ ", categoria, sub_categoria) values (?, ?, ?, ?, ?, ?)");
					
					ps.setString(1, objeto.getDescricao());
					ps.setFloat(2, objeto.getPreco());
					ps.setString(3, objeto.getMarca());
					ps.setString(4, objeto.getModelo());
					ps.setString(5, objeto.getCategoria());
					ps.setString(6, objeto.getSubCategoria());

					ps.executeUpdate();

					return true;

				} catch (SQLException e) {
					e.printStackTrace();
					return false;
				}
			}
			
			public boolean deletar(int id) {
				try {
					PreparedStatement ps = connection
							.prepareStatement("delete from produto where id=?");
					ps.setInt(1, id);
					ps.executeUpdate();

					return true;

				} catch (SQLException e) {
					e.printStackTrace();
					return false;
				}
			}
			
			public boolean atualizar(Produto objeto) {
				try {
					PreparedStatement ps = connection
							.prepareStatement("update produto set descricao=?, preco=?, marca=?, modelo=?,"
									+ "categoria=?, sub_categoria=? where id=?");
					
					ps.setString(1, objeto.getDescricao());
					ps.setFloat(2, objeto.getPreco());
					ps.setString(3, objeto.getMarca());
					ps.setString(4, objeto.getModelo());
					ps.setString(5, objeto.getCategoria());
					ps.setString(6, objeto.getSubCategoria());
					ps.setInt(7, objeto.getId());
					ps.executeUpdate();
					
					return true;

				} catch (SQLException e) {
					e.printStackTrace();
					return false;
				}
			}

			public List<Produto> listar() {
				List<Produto> lista = new ArrayList<Produto>();
				try {
					Statement st = connection.createStatement();
					ResultSet rs = st.executeQuery("select * from produto");
					
					while (rs.next()) {
						Produto objeto = new Produto();
						objeto.setId(rs.getInt("id"));
						objeto.setDescricao(rs.getString("descricao"));
						objeto.setPreco(rs.getInt("preco"));
						objeto.setMarca(rs.getString("marca"));
						objeto.setModelo(rs.getString("modelo"));
						objeto.setCategoria(rs.getString("categoria"));
						objeto.setSubCategoria(rs.getString("sub_categoria"));
						lista.add(objeto);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

				return lista;
			}
			
			public Produto consultar(int id) {
				Produto objeto = new Produto();
				try {
					PreparedStatement ps = connection.
							prepareStatement("select * from produto where id=?");
					ps.setInt(1, id);
					ResultSet rs = ps.executeQuery();
					
					if (rs.next()) {
						objeto.setId(rs.getInt("id"));
						objeto.setDescricao(rs.getString("descricao"));
						objeto.setPreco(rs.getInt("preco"));
						objeto.setMarca(rs.getString("marca"));
						objeto.setModelo(rs.getString("modelo"));
						objeto.setCategoria(rs.getString("categoria"));
						objeto.setSubCategoria(rs.getString("sub_categoria"));
						
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

				return objeto;
			}
		
}

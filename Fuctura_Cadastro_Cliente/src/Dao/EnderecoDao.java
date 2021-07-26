package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import JDBCUtil.ConexaoJDBC;
import Model.Endereco;

public class EnderecoDao {
	// Método Salvar
		public void save(Endereco endereco)throws ClassNotFoundException {
			
			String sql = "Insert into Cep=?, Rua=?, Numero=?, Bairro=?, Cidade=?, Estado=?";
			Connection conexao;
			
			try {
				conexao = ConexaoJDBC.getConexao();
				PreparedStatement ps = conexao.prepareStatement(sql);
				
				ps.setString(1, endereco.getCep());
				ps.setString(2, endereco.getRua());
				ps.setString(3, endereco.getNumero());
				ps.setString(4, endereco.getBairro());
				ps.setString(5, endereco.getCidade());
				ps.setString(6, endereco.getEstado());
				
				ps.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// Método Atualizar
		public void Update(Endereco endereco) {
			String sql = "Update Endereco set Cep=?, Rua=?, Numero=?, Bairro=?, Cidade=?, Estado=?";
			Connection conexao;
			
			try {
				conexao = ConexaoJDBC.getConexao();
				PreparedStatement ps = conexao.prepareStatement(sql);
				
				ps.setString(1, endereco.getCep());
				ps.setString(2, endereco.getRua());
				ps.setString(3, endereco.getNumero());
				ps.setString(4, endereco.getBairro());
				ps.setString(5, endereco.getCidade());
				ps.setString(6, endereco.getEstado());
				
				ps.execute();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		// Método deletar
		public void delete(Endereco endereco) throws ClassNotFoundException {
			
			String sql = "Delete From Endereco Where ID_Endereco=?";
			Connection conexao;
			
			try {
				conexao = ConexaoJDBC.getConexao();
				PreparedStatement ps = conexao.prepareStatement(sql);
				
				ps.setLong(1, endereco.getId());
				ps.execute();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// Método Listar
		public List<Endereco>listarTodos() throws ClassNotFoundException{
			
			String sql = "Select * from Endereco";
			List<Endereco> listarEndereco = new ArrayList<Endereco>();

			Connection conexao;
			
			try {
				conexao = ConexaoJDBC.getConexao();
				PreparedStatement ps = conexao.prepareStatement(sql);

				ResultSet resultado = ps.executeQuery();
				
				while (resultado.next()) {
					
					Endereco endereco = new Endereco();
					endereco.setCep(resultado.getString("Cep"));
					endereco.setRua(resultado.getString("Rua"));
					endereco.setNumero(resultado.getString("Número"));
					endereco.setBairro(resultado.getString("Bairro"));
					endereco.setCidade(resultado.getString("Cidade"));
					endereco.setEstado(resultado.getString("Estado"));
					
					listarEndereco.add(endereco);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return listarEndereco;
		}
}

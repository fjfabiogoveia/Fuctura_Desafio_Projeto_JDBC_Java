package Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import JDBCUtil.ConexaoJDBC;
import Model.Cliente;

public class ClienteDao {
	
	
	// Método Inserir dados
	public void save (Cliente cliente) throws ClassNotFoundException, SQLException {
		
		// Passo o comando para o Insert!
		String sql = "Insert into Cliente (nome, cpf, sexo, ano_Nascimento) values (?,?,?,?)";
		
		// Criar o objeto Connection. 
		//Ele confirmar automaticamente as alterações da instrução realizadas acima.
		Connection conexao;	
		

		try {

			conexao = ConexaoJDBC.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);

			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getCpf());
			ps.setString(3, cliente.getSexo());
			ps.setString(4, cliente.getAnoNasci());

			ps.execute();
			
			// Caso não seja possivel salvar as alterações automaticamente após as instruções;
			// O método commit confirma as alterações.
			//conexao.commit();
			
		} catch (SQLException  |  ClassNotFoundException e ) {
			e.printStackTrace();
		}

	}
	// Método atualizar
	public void update (	Cliente cliente) throws ClassNotFoundException, SQLException {

		String sql = "UPDATE Cliente SET Nome=?, CPF=?, Sexo=?, ano_Nascimento=? WHERE ID_Cliente";
		Connection conexao;

		try {
			conexao = ConexaoJDBC.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);

			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getCpf());
			ps.setString(3, cliente.getSexo());
			ps.setString(4, cliente.getAnoNasci());
			ps.setLong(5, cliente.getId());

			ps.execute();


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// Método deletar
	public void delete(Cliente cliente)throws ClassNotFoundException, SQLException{

		String sql = "Delete from Cliente WHERE ID_Cliente";
		Connection conexao;
		try {
			conexao = ConexaoJDBC.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);

			ps.setLong(1, cliente.getId());
			ps.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// Listar
	public List<Cliente> listarTodos()throws ClassNotFoundException{
		
		String sql = "Select * from Cliente ";
		List<Cliente> listarCliente = new ArrayList<Cliente>();
		
		Connection conexao;
		
		try {
			conexao = ConexaoJDBC.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);
			ResultSet resultado = ps.executeQuery();
			
			while (resultado.next()) {
				
				Cliente cliente = new Cliente();
				
				cliente.setNome(resultado.getString("Nome"));
				cliente.setCpf(resultado.getString("CPF"));
				cliente.setSexo(resultado.getString("Sexo"));
				cliente.setAnoNasci(resultado.getString("ano_Nascimento"));
				cliente.setId(resultado.getLong("ID_Cliente"));
				
				listarCliente.add(cliente);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listarCliente;
	}


}

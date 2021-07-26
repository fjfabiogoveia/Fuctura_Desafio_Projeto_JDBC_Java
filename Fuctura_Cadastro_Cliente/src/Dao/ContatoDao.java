package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import JDBCUtil.ConexaoJDBC;
import Model.Contato;

public class ContatoDao {
	// Método Salvar
		public void save(Contato contato)throws ClassNotFoundException {
			String sql = "Insert into Contado = (Email, DDD, Numero) values (?, ?, ?)";

			Connection conexao;

			try {
				conexao = ConexaoJDBC.getConexao();
				PreparedStatement ps = conexao.prepareStatement(sql);

				ps.setString(1, contato.getEmail());
				ps.setString(2, contato.getDdd());
				ps.setString(3, contato.getNumero());

				ps.execute();
				// conexao.comiti ();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		// Método atualizar
		public void update (Contato contato) throws ClassNotFoundException {
			String sql = "UPDATE Contato set Email=?, DDD=?, Numero=? WHERE ID_Contato";
			Connection conexao;

			try {
				conexao = ConexaoJDBC.getConexao();
				PreparedStatement ps = conexao.prepareStatement(sql);

				ps.setString(1, contato.getEmail());
				ps.setString(2, contato.getDdd());
				ps.setString(3, contato.getNumero());
				ps.setLong(4, contato.getId());
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		// Método deletar
		public void delete(Contato contato) throws ClassNotFoundException {
			String sql = "Delete from Contato Where ID_Contato=?";
			Connection conexao;

			try {
				conexao = ConexaoJDBC.getConexao();
				PreparedStatement ps = conexao.prepareStatement(sql);

				ps.setLong(1, contato.getId());
				ps.execute();


			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		// Método listar
		public List<Contato>listarTodos() throws ClassNotFoundException{

			String sql = "Select * from Contato";
			List<Contato> listarContato = new ArrayList<Contato>();

			Connection conexao;

			try {
				conexao = ConexaoJDBC.getConexao();
				PreparedStatement ps = conexao.prepareStatement(sql);

				ResultSet resultado = ps.executeQuery();

				while (resultado.next()) {

					Contato contato = new Contato();
					contato.setEmail(resultado.getString("Email"));
					contato.setDdd(resultado.getString("DDD"));
					contato.setNumero(resultado.getString("Número"));
					contato.setId(resultado.getLong("ID_Contato"));

					listarContato.add(contato);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return listarContato;
		}
}

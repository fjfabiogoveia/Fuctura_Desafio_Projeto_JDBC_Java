import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

	public class ConectarJDBC {
		public static void main(String[] args)throws SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "System";
		String password = "182818";
		
		try {
			Connection conexao = DriverManager.getConnection(url, user, password);
			System.out.println("Conex�o Realizada com sucesso.");
			
		} 
		
		catch (Exception e) {
			System.out.println("N�o foi poss�vel realizar a conex�o");
		}
	}
}

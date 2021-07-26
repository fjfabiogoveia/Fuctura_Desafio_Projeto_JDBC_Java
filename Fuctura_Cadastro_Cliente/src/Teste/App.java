package Teste;

import java.sql.SQLException;

import Dao.ClienteDao;
import Model.Cliente;

public class App {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		Cliente cliente = new Cliente();
		
		cliente.setNome("Vittor Lucas");
		cliente.setCpf("1111111");
		cliente.setSexo("M");
		cliente.setAnoNasci("10102018");
		
		ClienteDao clienteDao = new ClienteDao();
		clienteDao.save(cliente);

	}
}

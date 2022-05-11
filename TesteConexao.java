package Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteConexao {
	public static void main(String[] args) throws SQLException {

		final String url = "jdbc:mysql://localhost";
		final String usuario = "root";
		final String senha = "guilherme97";

		Connection conexao = DriverManager
					.getConnection(url, usuario, senha); // metodo que lança uma exceção checada!
														// e uma exceção checada precisa ser tratada usando (THROWS)"USADO NO METODO MAIN"
		conexao.close();
		System.out.println("conexao efetuada com sucesso");
	
	}
}

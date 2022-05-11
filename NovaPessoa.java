package Jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class NovaPessoa {

	public static void main(String[] args) throws SQLException {
		
		Scanner entrada = new Scanner(System.in);
			
		System.out.println("informe o nome: ");
		String nome = entrada.nextLine();
		
		Connection conexao = FabricaConexao.getConexao();
		
		String sql = "INSERT INTO pessoas (nome) VALUES (?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, nome);//primeiro parametro
		//stmt.setInt(2, 100); segundo parametro (definindo o codigo"PK")
		stmt.execute();

		System.out.println("pessoa incluida com sucesso");
		entrada.close();
		
	}
}

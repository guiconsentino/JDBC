package Jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AtualizarRegistro {

	public static void main(String[] args) throws SQLException {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("digite o codigo da pessoa: "); //pedi para informar o nome
		int codigo = entrada.nextInt(); //peguei o codigo da pesso
		
		String selectSQL = "SELECT codigo,nome FROM pessoas WHERE codigo = ?";
		String updateSQL = "UPDATE pessoas SET nome = ? WHERE codigo = ?";
		
		Connection conexao = FabricaConexao.getConexao();//feito a conexao com o banco de dados
		
		PreparedStatement stmt = conexao.prepareStatement(selectSQL);
		//fiz select porque passei o parametro que é o CODIGO da pessoa
		
		stmt.setInt(1, codigo);
		ResultSet resultado = stmt.executeQuery();
		//selecionei a pessoa com o codigo a partir do ResultSet
		
		
		
		if(resultado.next()) {//se a pessoa nao for selecionada nao faz nada, ou no meu caso retorna um }else{
			//se encontrar (resultado.next() estiver presente:
			
			Pessoa p = new Pessoa(resultado.getInt(1), resultado.getString(2));
			//cria pessoa
			System.out.println("o nome atual é ==> " + p.getNome());
			entrada.nextLine();
			//mostra nome atual da pessoa
			System.out.println("informe o novo nome: ");
			String novoNome = entrada.nextLine();
			//pede novo nome
		
			stmt.close();
			//fecha statement passado
		
		stmt = conexao.prepareStatement(updateSQL);
		//criado novo statement para atualização de dados
		
		stmt.setString(1, novoNome);
		stmt.setInt(2, codigo);
		//setado dois paramentros
		
		stmt.execute();//executado

		System.out.println("pessoa alterada com sucesso");
		}else {
			System.out.println("pessoa nao encontrada");
		}
		entrada.close();
	}
}

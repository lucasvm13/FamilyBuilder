package principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class conexaoBanco {

	 private Connection connection = null;
	 private Statement statement = null;
	 private ResultSet resultset = null;
	 
	 public void conectar() {
		 String servidor = "jdbc:mysql://localhost:3306/familybuilder";
		 String usuario = "root";
		 String senha = "root";
		 String driver = "com.mysql.jdbc.Driver";
		 
		 try {
			 Class.forName(driver);
			 this.connection = DriverManager.getConnection(servidor, usuario, senha);
			 this.statement = this.connection.createStatement();
		 } catch (Exception e) {
			System.out.println("Erro: " +e.getMessage());
		}
	 }

	public boolean estaConectado() {
		if(this.connection != null) {
			return true;
		} else {
		return false;
		}
	}

	public void listarUsuariosCadastros() {

		try {
			String query = "SELECT * FROM usuarios ORDER BY nome";
			this.resultset = this.statement.executeQuery(query);
			while (this.resultset.next()) {
				System.out.println(
						"ID: " + this.resultset.getString("id") + " - Nome: " + this.resultset.getString("nome"));
			}

		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public void cadastrarUsuario(String nome, String senha) {
		try {
			String query = "INSERT INTO usuarios (nome, senha) VALUES ('" + nome + "' , '" +senha  +"');";
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println("Erro ao adicionar usu�rio !");
		}
	}
	
	public void encerrerConexao() {
		try {
			this.connection.close();
		} catch (Exception e) {
			System.out.println("Erro: " +e.getMessage());
		}
	}
	
}

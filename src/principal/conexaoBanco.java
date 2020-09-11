package principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

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
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public boolean estaConectado() {
		if (this.connection != null) {
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
			String query = "INSERT INTO usuarios (nome, senha) VALUES ('" + nome + "' , '" + senha + "');";
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println("Erro ao adicionar usuário !");
		}
	}

	public void encerrerConexao() {
		try {
			this.connection.close();
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public boolean login(String nome, String senha) {
		try {

			PreparedStatement sts = connection.prepareStatement("select * from usuarios where nome=? and senha=?");

			sts.setString(1, nome);
			sts.setString(2, senha);

			ResultSet rs = sts.executeQuery();

			if (rs.next()) {
				JOptionPane.showMessageDialog(null, "Login efetuado com sucesso !");
				return true;
			} else {
				JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos !");
				return false;
			}
		} catch (Exception e) {
			System.out.println("ERRO !" + e.getMessage());
		}
		return false;
	}
}

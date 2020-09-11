package principal;
import java.io.IOException;
import javax.swing.JOptionPane;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

	
	@FXML private TextField nome;
	@FXML private TextField senha;
	@FXML private Button btnEntrar;
	@FXML private Button btnVoltar;
	@FXML private Button btnCancelar;
	@FXML private Button btnCadastrar;
	


	@FXML
	public void abrirCadastro() {
		Stage stage = new Stage();
		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource("Cadastro.fxml"));
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, "Erro !");
		}
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		stage.setTitle("Family Builder - Cadastro");
		
		btnEntrar.getScene().getWindow().hide();
	}
	
	@FXML
	private void voltar(){
		//Verificar para fechar o stage aberto ao voltar, está ficando aberto
		Stage stage = new Stage();
		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource("Principal.fxml"));
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, "Erro !");
		}
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void limpar() {
		nome.setText("");
		senha.setText("");
	}
	
	@FXML
	public void loginEntrar() {
		conexaoBanco con = new conexaoBanco();
		con.conectar();
		if(con.login(nome.getText().toLowerCase(), senha.getText().toLowerCase())) {
			//implementar ao fazer login fechar pagina de login
			abrirPaginaHome(nome.getText());
		}
		limpar();
		con.encerrerConexao();
	}
	
	
	public void abrirPaginaHome(String nome) {
		Stage stg = new Stage();
		Parent root = null;
		try { 
			root = FXMLLoader.load(getClass().getResource("Home.fxml")); 
		} catch (IOException ex) { 
			JOptionPane.showMessageDialog(null, "Erro !"); }
				Scene scene = new Scene(root); 
				stg.setScene(scene); 
				stg.show();
				stg.setTitle("Página principal - " +nome);	
	}
}

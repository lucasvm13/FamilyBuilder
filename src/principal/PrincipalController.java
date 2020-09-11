package principal;

import java.io.IOException;
import javax.swing.JOptionPane;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PrincipalController {

	@FXML
	private Button btnAbrirLogin;
	@FXML
	private Button btnAbrirCadastrar;
	@FXML
	private Button btnSair;

	
	@FXML
	public void abrirLogin() {
		Stage stg = new Stage();
		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource("Login.fxml"));
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, "Erro !");
		}
		Scene scene = new Scene(root);
		stg.setScene(scene);
		stg.show();
		/* stg.setTitle("Página principal - " + nome); */
	}

	@FXML
	public void abrirCadastro() {
		Stage stg = new Stage();
		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource("Cadastro.fxml"));
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, "Erro !");
		}
		Scene scene = new Scene(root);
		stg.setScene(scene);
		stg.show();
		/* stg.setTitle("Página principal - " + nome); */
	}

	@FXML
	private void Sair() {
		Stage stage = (Stage) btnSair.getScene().getWindow();
		stage.close();
	}

}

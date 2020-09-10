package principal;


import org.omg.CORBA.INITIALIZE;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CadastroController {
	
	

	@FXML private Button cadastrar;

	@FXML private Button voltar;

	@FXML private Button sair;
	
	@FXML private TextField nome;
	
	@FXML private TextField senha;
	
	

	@FXML private void conectarBanco() {
		conexaoBanco con = new conexaoBanco();
		con.conectar();
		if(con.estaConectado()) {
			con.listarUsuarios();
		} else {
			System.out.println("N�o est� conectado com o banco !");
		}
	}
	
	@FXML private void voltar(ActionEvent event) {
		try {
			new FXMLLoader(getClass().getResource("Login.fxml"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML private void sair() {
		 Stage stage = (Stage) sair.getScene().getWindow();
		 stage.close();
	}

	
	
	@FXML
	private void listarUsuarios() {
		conectarBanco();
		
	}

}

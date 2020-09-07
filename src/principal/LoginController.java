package principal;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController implements Initializable {

	
	@FXML private TextField nome;
	@FXML private TextField senha;
	@FXML private Button entrar;
	@FXML private Button cancelar;
	


	@Override
	public void initialize(URL location, ResourceBundle resources) {

		nome.setText("Insira o nome aqui");
		senha.setText("Insira a senha aqui");
		
		
		
		entrar.setOnAction(new EventHandler<ActionEvent>() {
			
			
			@Override
			public void handle(ActionEvent event) {
				
				if(nome.getText().equals("Lucas")&& senha.getText().equals("123")) {
					Stage stage = new Stage();
					Parent root = null;
					try {
						root = FXMLLoader.load(getClass().getResource("Inicial.fxml"));
					} catch (IOException ex) {
						JOptionPane.showMessageDialog(null, "Erro !");
					}
					
					Scene scene = new Scene(root);
					stage.setScene(scene);
					stage.show();
					stage.setTitle("Family Builder - Home");
					
					entrar.getScene().getWindow().hide();
					
				} else {
					JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos !");
					limpar();
				}
			}
		} );
	}
	
	
	@FXML
	private void fechar(){
	    Stage stage = (Stage) cancelar.getScene().getWindow();
	    stage.close();
	}
	
	public void limpar() {
		nome.setText("");
		senha.setText("");
	}
}

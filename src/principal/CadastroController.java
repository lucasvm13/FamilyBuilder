package principal;

import javax.swing.JOptionPane;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CadastroController {


	@FXML private Button cadastrar;

	@FXML private Button voltar;

	@FXML private Button sair;
	
	@FXML private TextField nome;
	
	@FXML private TextField senha;
	
	
	/*
	 * @FXML private void listarUsuarios() { conexaoBanco con = new conexaoBanco();
	 * con.conectar(); con.listarUsuariosCadastros(); }
	 */
	
	

	@FXML
	public void cadastrarUsuario() {
		
		
		if((nome.getText().isEmpty()) || senha.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "O nome e a senha não podem ser vazios !");
		} else if((nome.getText().length()<6) || (senha.getText().length()<6)) {
			JOptionPane.showMessageDialog(null, "O nome e senha devem ter no mínimo 6 caracteres !");
		} else {
			if(verificaNome(nome.getText())){
			conexaoBanco con = new conexaoBanco();
			con.conectar();
			con.cadastrarUsuario(nome.getText().toLowerCase(), senha.getText().toLowerCase());
			JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso !");
			limpar();
			con.encerrerConexao();
			} else {
				JOptionPane.showMessageDialog(null, "Apenas permitido letras no nome !");
			}
		}
		
	}
	
	private boolean verificaNome(String nome) {
		char[] aux = nome.toCharArray();

		for ( int i = 0; i < nome.length(); i++ )
		    if (Character.isDigit( aux[ i ] ) ) {
		        return false;
		    }
		return true;
	}
		
		
	public void limpar() {
		nome.setText("");
		senha.setText("");
	}
}

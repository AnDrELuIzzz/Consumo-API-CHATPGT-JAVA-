import java.io.FileInputStream;
import java.util.Properties;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        var properties = new Properties();
        properties.load(new FileInputStream("src/app.properties"));
        final String OPENAI_API_KEY = 
            properties.getProperty("OPENAI_API_KEY");
        
        // instanciar o ChatGPTClient
        var chatGPTClient = new ChatGPTClient();
        //Pegar um assunto junto ao usuário
        String assunto = JOptionPane.showInputDialog("Assunto?");
        //Pegar uma dificuldade junto ao usuário
        String dificuldade = JOptionPane.showInputDialog("Dificuldade?");
        //Pegar um tipo junto ao usuário
        String tipo = JOptionPane.showInputDialog("Tipo?");
        //Chamar o método criarPergunta, obter o resultado
        String s = chatGPTClient.criarPergunta(
            OPENAI_API_KEY, 
            assunto, 
            tipo, 
            dificuldade,
             null
        );
        //e exibir
        JOptionPane.showMessageDialog(null, s);
    }
}

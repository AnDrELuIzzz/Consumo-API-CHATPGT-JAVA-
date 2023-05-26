import javax.swing.JOptionPane;
import java.io.FileInputStream;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws Exception {
        var properties = new Properties();
        properties.load(new FileInputStream("src/app.properties"));
        final String OPENAI_API_KEY = properties.getProperty("OPENAI_API_KEY");

        // instanciar o ChatGPTClient
        var ChatGPTClientQ1 = new ChatGPTClientQ1();
        var ChatGPTClientQ2 = new ChatGPTClientQ2();
        var ChatGPTClientQ3 = new ChatGPTClientQ3();

        int opt = Integer.parseInt(JOptionPane.showInputDialog(null,
                "[1] Para traduzir um texto inglês para portugues\n[2] Para receber três emoji ao digitar o nome de um filme\n[3] Receber explicação para uma criança"));

        switch (opt) {
            case 1: {
                String text = JOptionPane.showInputDialog(null, "Digite o texto a ser traduzido.");
                String retorno = ChatGPTClientQ1.criarPergunta(OPENAI_API_KEY, text);
                JOptionPane.showMessageDialog(null, retorno);
                break;
            }
            case 2: {
                String filme = JOptionPane.showInputDialog(null, "Digite o nome do filme:");
                String retorno = ChatGPTClientQ2.criarPergunta(OPENAI_API_KEY, filme);
                JOptionPane.showMessageDialog(null, retorno);
                break;
            }
            case 3: {
                String explicacao = JOptionPane.showInputDialog(null, "Digite a explicação");
                String retorno = ChatGPTClientQ3.criarPergunta(OPENAI_API_KEY, explicacao);
                JOptionPane.showMessageDialog(null, retorno);
                break;
            }
            default:
                JOptionPane.showMessageDialog(null, "Opção incorreta");
                break;
        }
    }
}

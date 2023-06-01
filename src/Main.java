import javax.swing.JOptionPane;
import java.io.FileInputStream;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws Exception {
        var properties = new Properties();
        properties.load(new FileInputStream("src/app.properties"));
        final String OPENAI_API_KEY = properties.getProperty("OPENAI_API_KEY");
        // instanciar o ChatGPTClient
        var ChatGPTClient = new ChatGPTClient();
        int opt = 1;

        while (opt != 4) {
            opt = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "[1] Para traduzir um texto inglês para portugues\n[2] Para receber três emoji ao digitar o nome de um filme\n[3] Receber explicação para uma criança\n[4] Para sair"));
            switch (opt) {
                case 1: {
                    String text = JOptionPane.showInputDialog(null, "Digite o texto a ser traduzido.");
                    String retorno = ChatGPTClient.criarPergunta(OPENAI_API_KEY, text, opt);
                    JOptionPane.showMessageDialog(null, retorno);
                    break;
                }
                case 2: {
                    String filme = JOptionPane.showInputDialog(null, "Digite o nome do filme:");
                    String retorno = ChatGPTClient.criarPergunta(OPENAI_API_KEY, filme, opt);
                    JOptionPane.showMessageDialog(null, retorno);
                    break;
                }
                case 3: {
                    String explicacao = JOptionPane.showInputDialog(null, "Digite a explicação");
                    String retorno = ChatGPTClient.criarPergunta(OPENAI_API_KEY, explicacao, opt);
                    JOptionPane.showMessageDialog(null, retorno);
                    break;
                }
                case 4: {
                    break;
                }
                default:
                    JOptionPane.showMessageDialog(null, "Opção incorreta");
                    break;
            }
        }
    }
}

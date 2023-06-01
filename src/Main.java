import javax.swing.JOptionPane;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Main {
    private static final String PROPRIEDADE_API_KEY = "OPENAI_API_KEY";

    public static void main(String[] args) throws Exception {
        try {
            var properties = carregarPropriedades();
            final String openaiApiKey = properties.getProperty(PROPRIEDADE_API_KEY);
            var chatGPTClient = new ChatGPTClient();

            int opt = 1;
            while (opt != 4) {
                opt = obterOpcaoUsuario();
                switch (opt) {
                    case 1:
                        traduzirTexto(chatGPTClient, openaiApiKey);
                        break;
                    case 2:
                        obterEmojiFilme(chatGPTClient, openaiApiKey);
                        break;
                    case 3:
                        receberExplicacao(chatGPTClient, openaiApiKey);
                        break;
                    case 4:
                        break;
                    default:
                        exibirMensagem("Opção incorreta");
                        break;
                }
            }
        } catch (IOException e) {
            exibirMensagem("Erro ao carregar as propriedades");
            e.printStackTrace();
        }
    }

    private static Properties carregarPropriedades() throws IOException {
        var properties = new Properties();
        properties.load(new FileInputStream("src/app.properties"));
        return properties;
    }

    private static int obterOpcaoUsuario() {
        return Integer.parseInt(JOptionPane.showInputDialog(null,
                "[1] Para traduzir um texto inglês para portugues\n" +
                        "[2] Para receber três emoji ao digitar o nome de um filme\n" +
                        "[3] Receber explicação para uma criança\n" +
                        "[4] Para sair"));
    }

    private static void traduzirTexto(ChatGPTClient chatGPTClient, String apiKey) throws Exception {
        String text = JOptionPane.showInputDialog(null, "Digite o texto a ser traduzido.");
        String retorno = chatGPTClient.criarPergunta(apiKey, text, 1);
        JOptionPane.showMessageDialog(null, retorno);
    }

    private static void obterEmojiFilme(ChatGPTClient chatGPTClient, String apiKey) throws Exception {
        String filme = JOptionPane.showInputDialog(null, "Digite o nome do filme:");
        String retorno = chatGPTClient.criarPergunta(apiKey, filme, 2);
        JOptionPane.showMessageDialog(null, retorno);
    }

    private static void receberExplicacao(ChatGPTClient chatGPTClient, String apiKey) throws Exception {
        String explicacao = JOptionPane.showInputDialog(null, "Digite a explicação:");
        String retorno = chatGPTClient.criarPergunta(apiKey, explicacao, 3);
        JOptionPane.showMessageDialog(null, retorno);
    }

    private static void exibirMensagem(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
    }
}

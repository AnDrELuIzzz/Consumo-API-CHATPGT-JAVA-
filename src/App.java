import java.io.FileInputStream;
import java.util.Properties;

public class App {
    public static void main(String[] args) throws Exception {
        var properties = new Properties();
        properties.load(new FileInputStream("src/app.properties"));
        final String OPENAI_API_KEY = 
            properties.getProperty("OPENAI_API_KEY");

        // instanciar o ChatGPTClient
        //Pegar um assunto junto ao usuário
        //Pegar uma dificuldade junto ao usuário
        //Pegar um tipo junto ao usuário
        //Pegar uma dificuldade junto ao usuário
        //Chamar o método criarPergunta, obter o resultado
        //e exibir
    }
}

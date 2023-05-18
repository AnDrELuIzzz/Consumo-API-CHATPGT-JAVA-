public class TestePrompt {
  public static void main(String[] args) throws Exception {
    var chatGPTClient = new ChatGPTClient();
    //sem pergunta exemplo
    chatGPTClient.criarPergunta(
      null, 
      "Java", 
      "alternativa", 
      "ultra hard core",
      "Por que o céu é azul?"
    );
  }
}

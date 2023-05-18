import com.google.gson.Gson;

public class TesteGSON {
  public static void main(String[] args) {
    var chatGPTRequest = new ChatGPTRequest(
      "text-davinci-003", "Por que o céu é azul?", 150
    );
    var gson = new Gson();
    String json = gson.toJson(chatGPTRequest);
    System.out.println(json);

    var copia = gson.fromJson(json, ChatGPTRequest.class);
    System.out.println(copia.getModel());
  }
}

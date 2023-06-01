import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChatGPTRequest {
  private String model;
  private String prompt;
  private int n;
  private int max_tokens;
  private double temperature;
}

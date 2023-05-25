public class Pessoa {
  private String nome;
  private int idade;

  public Pessoa nome(String nome){
    this.nome = nome;
    return this;
  }

  public Pessoa idade(int idade){
    this.idade = idade;
    return this;
  }

  public static void main(String[] args) {
    var p = new Pessoa().nome("Ana").idade(18);  
  }
}

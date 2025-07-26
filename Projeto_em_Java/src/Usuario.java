public class Usuario {
    public String nome;
    public String cpf;
    public String email;
    public String senha;
    public String endereco;
    public boolean isAdmin;
    // Construtor da classe Usuário, utilizado para criar uma nova instância com valores definidos
    public Usuario(String nome, String cpf, String email, String senha, String endereco, boolean isAdmin) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.endereco = endereco;
        this.isAdmin = isAdmin;
    }
}

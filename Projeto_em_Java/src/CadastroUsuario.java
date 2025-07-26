import java.util.Scanner;
//classe responsável pelo cadastro e login de usuários
public class CadastroUsuario {
    private Usuario[] usuarios;
    private int totalUsuarios;
    private Scanner scanner;

    //construtor que inicializa os dados da classe com os parâmetros fornecidos
    public CadastroUsuario(Usuario[] usuarios, int totalUsuarios, Scanner scanner) {
        this.usuarios = usuarios;
        this.totalUsuarios = totalUsuarios;
        this.scanner = scanner; //evita criar múltiplos objetos de leitura
    }
//cadastrar um novo usuário (cliente ou administrador)
    public void cadastrarUsuario(boolean isAdmin) {
        System.out.println(isAdmin ? "\n--------- Cadastro de Administrador ---------" : "\n------------ Cadastro de Cliente ------------");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("E-mail: ");
        String email = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();

        usuarios[totalUsuarios] = new Usuario(nome, cpf, email, senha, endereco, isAdmin);
        totalUsuarios++; //atualiza o total de usuários cadastrados internamente
        System.out.println(isAdmin ? "-----> ADMINISTRADOR CADASTRADO COM SUCESSO!" : "-----> CLIENTE CADASTRADO COM SUCESSO!");
    }
//método que permite o cadastro de um administrador mediante uma senha especial da loja
    public void cadastrarAdministradorComSenha(String senhaLoja) {
        if (!senhaLoja.equals("123456")) {
            System.out.println("Senha incorreta. Acesso negado :(");
            return;
        }
        cadastrarUsuario(true); //se a senha estiver correta, procede com o cadastro de administrador
    }
        //método para realizar login de um usuário
    public Usuario fazerLogin() {
        System.out.println("\n-------------- Dados de Login ---------------");
        System.out.print("E-mail: ");
        String email = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        for (int i = 0; i < totalUsuarios; i++) { //percorre a lista de usuários para encontrar resultados iguais
            Usuario usuarioLogado = usuarios[i];
            if (usuarioLogado != null && usuarioLogado.email.equals(email) && usuarioLogado.senha.equals(senha)) {
                System.out.println("\nLOGIN REALIZADO COM SUCESSO! \nOlá, " + usuarioLogado.nome + "!");
                //v erifica se o usuário existe e se o e-mail e a senha conferem
                return usuarioLogado;
            }
        }
        //caso nenhum usuário seja encontrado com os dados fornecidos, retorna o null (vazio)
        System.out.println("Usuário ou senha inválidos. Verifique e tente novamente.");
        return null;
    }
}

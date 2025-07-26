import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
            //arrays para armazenar usuários, produtos e o carrinho
        Usuario[] usuarios = new Usuario[10];
        Produto[] produtos = new Produto[3];
        Produto[] carrinho = new Produto[20];
        int totalUsuarios = 0;
        int totalProdutos = 0;
        int totalCarrinho = 0; //contadores são usados para rastrear quantos itens estão em cada array

        //produtos iniciais do petshop cadastrados inicialmente, com IDs, nomes e preços.
        produtos[totalProdutos++] = new Produto("1", "Ração 5kg", 79.90);
        produtos[totalProdutos++] = new Produto("2", "Mordedor de Osso", 15.50);
        produtos[totalProdutos++] = new Produto("3", "Roupinha M", 45.00);

        CadastrarProduto cadastropro = new CadastrarProduto(produtos, totalProdutos);
        CadastroUsuario cadastroUsu = new CadastroUsuario(usuarios, totalUsuarios, scanner);
        Carrinho car = new Carrinho(carrinho, totalCarrinho);

        System.out.println("============BEM VINDO A PETMANIA!============");

        while (true) {
            System.out.println("\n----------------MENU PRINCIPAL---------------");
            System.out.println("[1] Fazer Login");
            System.out.println("[2] Cadastrar Cliente");
            System.out.println("[3] Cadastrar Administrador");
            System.out.println("[4] Sair");
            System.out.print("Escolha uma opção: ");
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    Usuario usuarioLogado = cadastroUsu.fazerLogin(); //chama método para logar com usuário já cadastrado
                    if (usuarioLogado != null) {
                        if (usuarioLogado.isAdmin) {
                            System.out.println("------------ Painel de controle: ------------");
                            System.out.println("Total de vendas:                 R$10.000,00");
                            System.out.println("Clientes ativos:                 3 clientes");
                            System.out.println("Produtos em estoque:             100 unidades");
                            System.out.println("=============================================");
                            System.out.println("[1] Sair");
                            System.out.println("[2] Adicionar produtos em estoque");

                            String opcaoAdm = scanner.nextLine(); //analisa a escolha do adm

                            if (opcaoAdm.equals("1")) {
                                System.out.println("Até mais :D");
                                System.exit(0);
                            } else if (opcaoAdm.equals("2")) {
                                System.out.println("Produtos adicionados! Até mais :D");
                                System.exit(0);
                            } else {
                                System.out.println("Opção inválida. Encerrando...");
                                System.exit(0); //por falta de tempo, o código não tem integração com estoque
                            }
                        } else {
                            fluxoCompra(car, cadastropro, scanner); //segue para a utilização do carrinho
                        }
                    }
                    break;
                case "2":
                    cadastroUsu.cadastrarUsuario(false); //Chama método para cadastrar cliente
                    break;
                case "3":
                    System.out.print("Digite a senha da loja para criar administrador: ");
                    String senhaLoja = scanner.nextLine();
                    cadastroUsu.cadastrarAdministradorComSenha(senhaLoja); //chama método para verificar a senha já estabelecida da loja
                    break;
                case "4":
                    System.out.println("\nObrigada por visitar a PetMania!\nAté logo! :D"); //despedida
                    return; //encerra o programa
                default:
                    System.out.println("Opção inválida");
            }
        }
    }
        //recebe os itens solicitados pelo usuário em forma de loop que somente encerra com a decisão do usuário
    public static void fluxoCompra(Carrinho carrinho, CadastrarProduto cadastroProduto, Scanner scanner) {
        while (true) {
            System.out.println("\n=============================================");
            cadastroProduto.listarProdutos();

            System.out.println("=============================================\nDigite ID do produto para adicionar ao carrinho\nou [0] para ver carrinho atual:");
            String escolha = scanner.nextLine();

            if (escolha.equals("0")) {
                carrinho.mostrarCarrinho();

                System.out.println("\n[1] Retornar à página de compra");
                System.out.println("[2] Finalizar as compras");
                String decisao = scanner.nextLine();

                if (decisao.equals("1")) {
                    continue;
                } else if (decisao.equals("2")) {
                    carrinho.finalizarCompra();
                    return;
                } else {
                    System.out.println("Opção inválida. Verifique a grafia ;)");
                }
            } else {
                // Busca o produto com o ID recebido e armazena o resultado na variável 'produtoSelecionado'
                Produto produtoSelecionado = cadastroProduto.buscarProdutoPorId(escolha);
                if (produtoSelecionado != null) {
                    carrinho.adicionarProduto(produtoSelecionado);
                    System.out.println("PRODUTO ADICIONADO AO CARRINHO!");
                } else {
                    System.out.println("Produto não encontrado. Tente novamente!");
                }
            }
        }
    }
}

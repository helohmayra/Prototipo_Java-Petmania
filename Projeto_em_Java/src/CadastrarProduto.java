//classe que vai gerenciar a listagem e busca de produtos cadastrados
public class CadastrarProduto {
    private Produto[] produtos;
    private int totalProdutos;
    //construtor da classe que recebe o array de produtos e a quantidade total de produtos
    public CadastrarProduto(Produto[] produtos, int totalProdutos) {
        this.produtos = produtos;
        this.totalProdutos = totalProdutos;
    }
    //método para exibir todos os produtos disponíveis na loja
    public void listarProdutos() {
        System.out.println("------------ Produtos disponíveis -----------");
        for (int i = 0; i < totalProdutos; i++) { //percorre todos os produtos até o total atualmente cadastrado
            Produto p = produtos[i];
            System.out.println("ID: " + p.id + " | " + p.nome + " - R$ " + p.preco);
        }
    }
    //método que busca um produto pelo seu ID
    public Produto buscarProdutoPorId(String id) {
        for (int i = 0; i < totalProdutos; i++) {
            if (produtos[i].id.equals(id)) {
                return produtos[i];
            }
        }
        return null; //caso nenhum produto seja encontrado com o ID informado, recebe null (ausência de valor)
    }
}

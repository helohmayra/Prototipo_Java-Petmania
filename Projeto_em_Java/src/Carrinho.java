//responsável por gerenciar os produtos adicionados ao carrinho de compras
public class Carrinho {
    private Produto[] carrinho; //armazena os produtos adicionados ao carrinho
    private int totalCarrinho; //quantidade atual de produtos no carrinho

    public Carrinho(Produto[] carrinho, int totalCarrinho) { //construtor da classe
        this.carrinho = carrinho;
        this.totalCarrinho = totalCarrinho;
    }

    public void adicionarProduto(Produto produto) { //verifica se ainda há espaço no array do carrinho
        if (totalCarrinho < carrinho.length) {
            carrinho[totalCarrinho++] = produto;
        } else {
            System.out.println("Carrinho cheio!");
        }
    }

    public void mostrarCarrinho() { //método para mostrar todos os produtos do carrinho e calcular o total da compra
        if (totalCarrinho == 0) {
            System.out.println("Seu carrinho está vazio.");
            return;
        }

        System.out.println("==============RESUMO DO CARRINHO=============");
        double total = 0; //variável para armazenar o valor total da compra
        for (int i = 0; i < totalCarrinho; i++) { //percorre todos os produtos do carrinho
            Produto p = carrinho[i];
            System.out.println(p.nome + " - R$ " + p.preco);
            total += p.preco;
        }
        System.out.println("\nTOTAL: R$ " + total);
    }
//método para finalizar a compra e limpar o carrinho
    public void finalizarCompra() {
        if (totalCarrinho == 0) {
            System.out.println("Carrinho vazio. Nada foi comprado.\n=============================================");
        } else {
            System.out.println("\nCompra finalizada com sucesso.\nObrigada por comprar na PetMania!\n=============================================");
            totalCarrinho = 0; //esvazia o carrinho resetando o contador de itens
        }
    }
}

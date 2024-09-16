import java.util.Scanner;

public class Controlador {
    private Cliente cliente;
    private Pedido pedido;

    public void iniciarPedido(Cliente cliente) {
        this.cliente = cliente;
        this.pedido = new Pedido();
        System.out.println("Bem-vindo à nossa Sorveteria, " + cliente.getNome() + "!");
    }

    public void adicionarSabor(Sabor sabor) {
        if (pedido != null) {
            cliente.escolherSabor(sabor, pedido);
        } else {
            System.out.println("Pedido não iniciado.");
        }
    }

    public void finalizarPedido() {
        if (pedido != null && !pedido.getItens().isEmpty()) {
            double total = pedido.calcularTotal();
            System.out.println("Total do pedido: R$" + total);
        } else {
            System.out.println("Seu carrinho está vazio. Não há nada para finalizar.");
        }
    }

    public void processarPagamento() {
        if (pedido != null && !pedido.getItens().isEmpty()) {
            double total = pedido.calcularTotal();
            Scanner scanner = new Scanner(System.in);

            System.out.println("Escolha o método de pagamento:");
            System.out.println("1 - Cartão de Crédito");
            System.out.println("2 - Dinheiro");
            System.err.println("3 - Cancelar");

            int escolha = scanner.nextInt();
            Pagamento pagamento = null;

            switch (escolha) {
                case 1:
                    System.out.println("Digite o número do cartão:");
                    String numeroCartao = scanner.next();
                    pagamento = new PagamentoCartao(total, numeroCartao);
                    break;
                case 2:
                    pagamento = new PagamentoDinheiro(total);
                    break;
                case 3:
                    System.out.println("Compra cancelada");
                    break;
                default:
                    System.out.println("Método de pagamento inválido.");
                    return;
            }
            if (escolha != 3) {
                cliente.realizarPagamento(pagamento);
            }
        } else {
            System.out.println("Pedido vazio. Nenhum pagamento necessário.");
        }
    }
    
}

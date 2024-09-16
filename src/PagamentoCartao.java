public class PagamentoCartao implements Pagamento {
    private double valor;
    private String numeroCartao;

    public PagamentoCartao(double valor, String numeroCartao) {
        this.valor = valor;
        this.numeroCartao = numeroCartao;
    }

    @Override
    public boolean processarPagamento() {
        System.out.println("Pagamento de R$" + valor + " realizado com cartão de crédito: " + numeroCartao);
        return true;
    }
}

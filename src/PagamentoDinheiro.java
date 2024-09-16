public class PagamentoDinheiro implements Pagamento {
    private double valor;

    public PagamentoDinheiro(double valor) {
        this.valor = valor;
    }

    @Override
    public boolean processarPagamento() {
        System.out.println("Pagamento de R$" + valor + " realizado em dinheiro.");
        return true;
    }
}

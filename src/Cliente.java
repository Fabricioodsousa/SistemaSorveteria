public class Cliente {
    private String nome;
    private String cpf;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public void escolherSabor(Sabor sabor, Pedido pedido) {
        pedido.adicionarSabor(sabor);
    }

    public void realizarPagamento(Pagamento pagamento) {
        pagamento.processarPagamento();
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }
}

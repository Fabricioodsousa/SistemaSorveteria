import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<Sabor> itens;

    public Pedido() {
        this.itens = new ArrayList<>();
    }

    public void adicionarSabor(Sabor sabor) {
        itens.add(sabor);
        System.out.println(sabor.getNome() + " adicionado ao pedido.");
    }

    public double calcularTotal() {
        double total = 0;
        for (Sabor sabor : itens) {
            total += sabor.getPreco();
        }
        return total;
    }

    public List<Sabor> getItens() {
        return itens;
    }
}

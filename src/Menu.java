import java.util.List;

public class Menu {
    private List<Sabor> listaSabores;

    public Menu(List<Sabor> listaSabores) {
        this.listaSabores = listaSabores;
    }

    public void exibirSabores() {
        System.out.println("Sabores disponíveis:");
        for (int i = 0; i < listaSabores.size(); i++) {
            Sabor sabor = listaSabores.get(i);
            System.out.println(i + ": " + sabor.getNome() + " - R$" + sabor.getPreco());
        }
    }

    public Sabor selecionarSabor(int indice) {
        if (indice >= 0 && indice < listaSabores.size()) {
            return listaSabores.get(indice);
        } else {
            System.out.println("Índice inválido!");
            return null;
        }
    }
}

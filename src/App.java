import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        List<Sabor> sabores = new ArrayList<>();
        sabores.add(new Sabor("Chocolate", 5.00));
        sabores.add(new Sabor("Baunilha", 4.50));
        sabores.add(new Sabor("Morango", 4.00));

        Menu menu = new Menu(sabores);

        Controlador controlador = new Controlador();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite seu nome:");
        String nome = scanner.next();

        System.out.println("Digite seu cpf:");
        String cpf = scanner.next();

        Cliente cliente = new Cliente(nome, cpf);
        controlador.iniciarPedido(cliente);

        menu.exibirSabores();

        int continuar = 1;
        while (continuar == 1) {
            System.out.println("Digite o índice do sabor para adicionar ao carrinho:");
            int indice = scanner.nextInt();
            Sabor saborEscolhido = menu.selecionarSabor(indice);
            if (saborEscolhido != null) {
                controlador.adicionarSabor(saborEscolhido);
            }
            System.out.println("Deseja continuar comprando?");
            System.out.println("1 - Sim");
            System.out.println("2 - Não");
            continuar = scanner.nextInt();
        }

        controlador.finalizarPedido();

        controlador.processarPagamento();

        scanner.close();
    }
}

import java.util.ArrayList;
import java.util.List;

public class Cardapio {
    private List<String> pratos;
    private List<String> bebidas;

    public Cardapio() {
        this.pratos = new ArrayList<>();
        this.bebidas = new ArrayList<>();
    }

    public void adicionarPrato(String prato) {
        pratos.add(prato);
        System.out.println("O prato " + prato + " foi adicionado com sucesso!");
    }

    public void adicionarBebida(String bebida) {
        bebidas.add(bebida);
        System.out.println("A bebida " + bebida + " foi adicionada com sucesso!");
    }

    public void removerPrato(String prato) {
        if (pratos.remove(prato)) {
            System.out.println("O prato " + prato + " foi removido do cardápio!");
        } else {
            System.out.println("O prato " + prato + " não foi encontrado no cardápio.");
        }
    }

    public void removerBebida(String bebida) {
        if (bebidas.remove(bebida)) {
            System.out.println("A bebida " + bebida + " foi removida do cardápio!");
        } else {
            System.out.println("A bebida " + bebida + " não foi encontrada no cardápio.");
        }
    }

    public List<String> getPratos() {
        return new ArrayList<>(pratos);
    }

    public List<String> getBebidas() {
        return new ArrayList<>(bebidas);
    }
}


import java.util.ArrayList;

public class Cardapio {
    private ArrayList<String> pratos;
    private ArrayList<String> bebidas;

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
        pratos.remove(prato);
        System.out.println("O prato " + prato + " foi removido do cardápio!");
    }

    public void removerBebida(String bebida) {
        bebidas.remove(bebida);
        System.out.println("A bebida " + bebida + " foi removida do cardápio!");
    }

    public String[] getPratos() {

        throw new UnsupportedOperationException("Unimplemented method 'getPratos'");
    }

    public String[] getBebidas() {

        throw new UnsupportedOperationException("Unimplemented method 'getBebidas'");
    }
}

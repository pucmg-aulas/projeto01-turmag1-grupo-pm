
import java.util.List;

public class Pedido {
    private int id;
    private String descricao;

    public Pedido(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Pedido(List<String> pratos, List<String> bebidas) {

    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }
}

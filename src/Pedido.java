import java.util.List;
import java.util.Objects;

public class Pedido {
    private int id;
    private String descricao;
    private List<String> pratos;
    private List<String> bebidas;

    public Pedido(int id, String descricao, List<String> pratos, List<String> bebidas) {
        this.id = id;
        this.descricao = descricao;
        this.pratos = pratos;
        this.bebidas = bebidas;
    }

    public Pedido(List<String> pratos, List<String> bebidas) {
        this.pratos = pratos;
        this.bebidas = bebidas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<String> getPratos() {
        return pratos;
    }

    public void setPratos(List<String> pratos) {
        this.pratos = pratos;
    }

    public List<String> getBebidas() {
        return bebidas;
    }

    public void setBebidas(List<String> bebidas) {
        this.bebidas = bebidas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return id == pedido.id &&
               Objects.equals(descricao, pedido.descricao) &&
               Objects.equals(pratos, pedido.pratos) &&
               Objects.equals(bebidas, pedido.bebidas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, pratos, bebidas);
    }

    @Override
    public String toString() {
        return "Pedido{" +
               "id=" + id +
               ", descricao='" + descricao + '\'' +
               ", pratos=" + pratos +
               ", bebidas=" + bebidas +
               '}';
    }
}

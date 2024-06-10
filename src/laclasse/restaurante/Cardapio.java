package laclasse.restaurante;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cardapio implements CardapioInterface, Serializable {
    private List<ItemMenu> pratos;
    private List<ItemMenu> bebidas;

    public ItemMenu getItemPorNome(String itemNome) {
    for (ItemMenu prato : this.pratos) {
        if (prato.getNome().equals(itemNome)) {
            return prato;
        }
    }
    for (ItemMenu bebida : this.bebidas) {
        if (bebida.getNome().equals(itemNome)) {
            return bebida;
        }
    }
    return null; // retorna null se o item não foi encontrado
}


    public Cardapio() {
        this.pratos = new ArrayList<>();
        this.bebidas = new ArrayList<>();
    }


    @Override
    public void adicionarPrato(ItemMenu prato) {
        this.pratos.add(prato);
    }

 
    @Override
    public void removerPrato(ItemMenu prato) {
        this.pratos.remove(prato);
    }


    @Override
    public void adicionarBebida(ItemMenu bebida) {
        this.bebidas.add(bebida);
    }


    @Override
    public void removerBebida(ItemMenu bebida) {
        this.bebidas.remove(bebida);
    }


    @Override
    public List<ItemMenu> getPratos() {
        return new ArrayList<>(this.pratos);
    }

    @Override
    public List<ItemMenu> getBebidas() {
        return new ArrayList<>(this.bebidas);
    }


    public ItemMenu getItemPorNome(String itemNome) {
        throw new UnsupportedOperationException("Unimplemented method 'getItemPorNome'");
    }
}

package laclasse.restaurante;

import java.util.List;

public interface CardapioInterface {

    void adicionarPrato(ItemMenu prato);

    void removerPrato(ItemMenu prato);

    void adicionarBebida(ItemMenu bebida);

    void removerBebida(ItemMenu bebida);

    List<ItemMenu> getPratos();

    List<ItemMenu> getBebidas();

    ItemMenu getItemPorNome(String itemNome);
}

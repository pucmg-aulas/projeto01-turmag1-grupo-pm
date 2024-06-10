package laclasse.restaurante;

import java.util.ArrayList;
import java.util.List;

public class Restaurante {
    private List<Mesa> mesas;

    public Restaurante() {
        this.mesas = new ArrayList<>();

        // Adiciona 4 mesas com capacidade para 4 pessoas
        for (int i = 0; i < 4; i++) {
            this.mesas.add(new Mesa(i + 1, 4));
        }

        // Adiciona 4 mesas com capacidade para 6 pessoas
        for (int i = 4; i < 8; i++) {
            this.mesas.add(new Mesa(i + 1, 6));
        }

        // Adiciona 2 mesas com capacidade para 8 pessoas
        for (int i = 8; i < 10; i++) {
            this.mesas.add(new Mesa(i + 1, 8));
        }
    }
}

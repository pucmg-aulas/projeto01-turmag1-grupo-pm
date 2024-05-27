

package laclasse.restaurante.test;

import org.junit.jupiter.api.Test;

import laclasse.restaurante.Restaurante;

import static org.junit.jupiter.api.Assertions.*;

public class RestauranteTest {
    @Test
    public void testVerificarDisponibilidade() {
        Restaurante restaurante = new Restaurante();
        assertTrue(restaurante.verificarDisponibilidade(4));
        assertTrue(restaurante.verificarDisponibilidade(6));
        assertTrue(restaurante.verificarDisponibilidade(8));
        assertFalse(restaurante.verificarDisponibilidade(10));
    }
}



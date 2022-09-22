package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalavraTest {

    Palavra pal;

    @BeforeEach
    void setUp() {
        try {
            pal = new Palavra("palavra");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void palavraConstructor() {
        assertThrows(Exception.class, () -> {
            new Palavra("");
        });
        assertThrows(Exception.class, () -> {
            new Palavra(null);
        });
    }

    @Test
    void getQuantidade() {
        assertEquals(pal.getQuantidade('p'), 1);
        assertEquals(pal.getQuantidade('a'), 3);
        assertEquals(pal.getQuantidade('l'), 1);
        assertEquals(pal.getQuantidade('v'), 1);
        assertEquals(pal.getQuantidade('r'), 1);
        assertEquals(pal.getQuantidade('w'), 0);
    }

    @Test
    void getPosicaoDaIezimaOcorrencia() {
        assertThrows(Exception.class, () -> {
            pal.getPosicaoDaIezimaOcorrencia(3, 'a');
        });

        try {
            assertEquals(pal.getPosicaoDaIezimaOcorrencia(0, 'a'), 1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testEquals() {
        Palavra p1, p2, p3;

        try {
            p1 = new Palavra("palavra");
            p2 = new Palavra("palavra");
            p3 = new Palavra("xxxxxxx");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        assertEquals(p1.equals(p1), true);
        assertEquals(p1.equals(p2), true);
        assertEquals(p1.equals(p3), false);
        assertEquals(pal.equals(null), false);
    }

    /*
    @Test
    void testHashCode() {
        assertEquals(pal.hashCode(), "palavra".hashCode());
    }
    */
}
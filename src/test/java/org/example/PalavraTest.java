package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalavraTest {

    Palavra pal;

    @BeforeEach
    void setUp()
    {
        try
        {
            pal = new Palavra("teste");
        } catch (Exception exc)
        {
            throw new RuntimeException(exc);
        }
    }

    @Test
    void palavraConstructor()
    {
        assertThrows(Exception.class, () ->
        {
            new Palavra("");
        });
        assertThrows(Exception.class, () ->
        {
            new Palavra(null);
        });
    }

    @Test
    void getQuantidade()
    {
        assertEquals(pal.getQuantidade('t'), 2);
        assertEquals(pal.getQuantidade('e'), 2);
        assertEquals(pal.getQuantidade('s'), 1);
        assertEquals(pal.getQuantidade('v'), 0);
    }

    @Test
    void getPosicaoDaIezimaOcorrencia()
    {
        assertThrows(Exception.class, () ->
        {
            pal.getPosicaoDaIezimaOcorrencia(6, 'e');
        });

        assertThrows(Exception.class, () ->
        {
            pal.getPosicaoDaIezimaOcorrencia(0, 'n');
        });

        assertThrows(Exception.class, () ->
        {
            pal.getPosicaoDaIezimaOcorrencia(3, 'e');
        });

        try
        {
            assertEquals(pal.getPosicaoDaIezimaOcorrencia(0, 't'), 1);
            assertEquals(pal.getPosicaoDaIezimaOcorrencia(1, 't'), 4);
            assertEquals(pal.getPosicaoDaIezimaOcorrencia(0, 'e'), 2);
            assertEquals(pal.getPosicaoDaIezimaOcorrencia(1, 'e'), 5);
        } catch (Exception exc)
        {
            throw new RuntimeException(exc);
        }
    }

    @Test
    void testEqualsHashcode()
    {
        Palavra p1, p2, p3;

        try
        {
            p1 = new Palavra("teste");
            p2 = new Palavra("teste");
            p3 = new Palavra("abcde");
        } catch (Exception exc)
        {
            throw new RuntimeException(exc);
        }

        assertTrue(p1.equals(p1));
        assertTrue(p2.equals(p2));
        assertTrue(p3.equals(p3));
        assertTrue(p1.equals(p2) && p2.equals(p1));
        assertTrue(p1.equals(pal) && pal.equals(p2));
        assertFalse(p1.equals(p3));
        assertFalse(pal.equals(null));

        assertEquals(p1.hashCode(), p1.hashCode());
        assertEquals(p1.hashCode(), p2.hashCode());
        assertEquals(pal.hashCode(), p1.hashCode());
        assertEquals(pal.hashCode(), p2.hashCode());
        assertNotEquals(pal.hashCode(), p3.hashCode());

        try
        {
            p1 = new Palavra("teste2");
        } catch (Exception exc)
        {
            throw new RuntimeException(exc);
        }

        assertNotEquals(pal.hashCode(), p1.hashCode());
    }


}
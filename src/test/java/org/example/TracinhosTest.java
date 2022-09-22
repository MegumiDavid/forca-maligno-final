package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TracinhosTest
{
    Palavra pal;
    Tracinhos trac;

    @BeforeEach
    void setUp()
    {
        try
        {
            pal = new Palavra("teste");
            trac = new Tracinhos(pal.getTamanho());
        } catch (Exception exc)
        {
            throw new RuntimeException(exc);
        }
    }

    @Test
    void tracinhosConstructor()
    {
        assertThrows(Exception.class, () ->
        {
            new Tracinhos(-10);
        });

        assertDoesNotThrow(() ->  new Tracinhos(10));
    }

    @Test
    void reveleTeste()
    {
        assertThrows(Exception.class, () ->
        {
            trac.revele(-1,'a');
        });

        assertThrows(Exception.class, () ->
        {
            trac.revele(5,'a');
        });

        assertThrows(Exception.class, () ->
        {
            trac.revele(6,'a');
        });

        assertDoesNotThrow(() -> trac.revele(2,'e'));
    }

    @Test
    void isAindaComTracinhosTeste()
    {
        Tracinhos trac1;
        try
        {
            trac1 = new Tracinhos(pal.getTamanho());
            trac1.revele(0, 't');
            trac1.revele(1, 'e');
            trac1.revele(2, 's');
            trac1.revele(3, 't');
            trac1.revele(4, 'e');
        } catch (Exception exc)
        {
            throw new RuntimeException(exc);
        }

        assertTrue(trac.isAindaComTracinhos());
        assertFalse(trac1.isAindaComTracinhos());
    }

    @Test
    void testToString()
    {
        assertEquals("_ _ _ _ _ ", trac.toString());

        try
        {
            trac.revele(0, 't');
            trac.revele(1, 'e');

            assertEquals("t e _ _ _ ", trac.toString());

            trac.revele(2, 's');
            trac.revele(3, 't');
            trac.revele(4, 'e');
        } catch (Exception exc)
        {
            throw new RuntimeException(exc);
        }

        assertEquals("t e s t e ", trac.toString());
    }

    @Test
    void testEqualsHashcode()
    {
        Tracinhos trac1,trac2;
        Palavra p1, p2;

        try
        {
            p1 = new Palavra("teste");
            p2 = new Palavra("abcdefg");
            trac1 = new Tracinhos(p1.getTamanho());
            trac2 = new Tracinhos(p2.getTamanho());
        } catch (Exception exc)
        {
            throw new RuntimeException(exc);
        }

        assertTrue(trac1.equals(trac1));
        assertTrue(trac2.equals(trac2));
        assertTrue(trac1.equals(trac));
        assertFalse(trac1.equals(trac2));
        assertFalse(trac1.equals(null));
        assertFalse(trac.equals(null));

        assertEquals(trac1.hashCode(), trac1.hashCode());
        assertEquals(trac.hashCode(), trac1.hashCode());
        assertNotEquals(trac.hashCode(), trac2.hashCode());

        try
        {
            trac1 = new Tracinhos("teste2".length());
        } catch (Exception exc)
        {
            throw new RuntimeException(exc);
        }

        assertFalse(trac1.equals(trac));
        assertNotEquals(trac.hashCode(), trac1.hashCode());
    }

    @Test
    void testClone()
    {
        assertThrows(Exception.class, () ->
        {
            new Tracinhos(null);
        });

        try
        {
            Tracinhos copia = new Tracinhos(trac);
            assertEquals(trac, copia);

            copia.revele(0,'t');
            assertNotEquals(trac, copia);
        } catch (Exception exc)
        {
            throw new RuntimeException(exc);
        }
    }

}
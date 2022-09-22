package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControladorDeErrosTest
{
    ControladorDeErros ce;

    @BeforeEach
    void setUp()
    {
        try
        {
            ce = new ControladorDeErros(3);
        } catch (Exception exc)
        {
            throw new RuntimeException(exc);
        }
    }

    @Test
    void testeControladorDeErrosConstructor()
    {
        assertThrows(Exception.class, () ->
        {
            new ControladorDeErros(-10);
        });
    }

    @Test
    void testRegistreUmErro()
    {
        try
        {
            ce.registreUmErro();
            ce.registreUmErro();
            ce.registreUmErro();

            assertThrows(Exception.class, () ->
            {
                ce.registreUmErro();
            });
        } catch (Exception exc)
        {
            throw new RuntimeException(exc);
        }
    }


    @Test
    void testeIsAtingidoMaximoDeErros()
    {

        assertEquals(false, ce.isAtingidoMaximoDeErros());
        try
        {
            ce.registreUmErro();
            ce.registreUmErro();
            ce.registreUmErro();
        } catch (Exception exc)
        {
            throw new RuntimeException(exc);
        }

        assertEquals(true, ce.isAtingidoMaximoDeErros());
    }

    @Test
    void testToString()
    {
        assertEquals("0/3", ce.toString());

        try
        {
            ce.registreUmErro();
            ce.registreUmErro();
            ce.registreUmErro();
        } catch (Exception exc)
        {
            throw new RuntimeException(exc);
        }

        assertEquals("3/3", ce.toString());
    }

    @Test
    void testEqualsHashcode()
    {
        ControladorDeErros ce1, ce2, ce3;

        try
        {
            ce1 = new ControladorDeErros(3);
            ce2 = new ControladorDeErros(3);
            ce3 = new ControladorDeErros(4);
        } catch (Exception exc)
        {
            throw new RuntimeException(exc);
        }

        assertTrue(ce1.equals(ce1));
        assertTrue(ce2.equals(ce2));
        assertTrue(ce3.equals(ce3));
        assertTrue(ce1.equals(ce2) && ce2.equals(ce1));
        assertTrue(ce.equals(ce1) && ce.equals(ce2));
        assertFalse(ce1.equals(ce3));

        assertEquals(ce1.hashCode(), ce1.hashCode());
        assertEquals(ce1.hashCode(), ce2.hashCode());
        assertEquals(ce.hashCode(), ce1.hashCode());
        assertEquals(ce.hashCode(), ce2.hashCode());
        assertNotEquals(ce.hashCode(), ce3.hashCode());


        try
        {
            ce2.registreUmErro();
            ce2.registreUmErro();
            ce2.registreUmErro();
        } catch (Exception exc)
        {
            throw new RuntimeException(exc);
        }

        assertFalse(ce1.equals(ce2) && ce.equals(ce2));
        assertNotEquals(ce.hashCode(), ce2.hashCode());
        assertNotEquals(ce1.hashCode(), ce2.hashCode());

    }


    @Test
    void testClone()
    {
        assertThrows(Exception.class, () ->
        {
            new ControladorDeErros(null);
        });

        try {
            ControladorDeErros copia = new ControladorDeErros(ce);
            assertEquals(true, ce.equals(copia));
        } catch (Exception exc) {
            throw new RuntimeException(exc);
        }
    }
}
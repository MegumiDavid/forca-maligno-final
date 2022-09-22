package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControladorDeLetrasJaDigitadasTest {

    ControladorDeLetrasJaDigitadas cld;

    @BeforeEach
    void setUp()
    {
        try
        {
            cld = new ControladorDeLetrasJaDigitadas();
        } catch (Exception exc)
        {
            throw new RuntimeException(exc);
        }
    }

    @Test
    void isJaDigitadaRegistra()
    {
        assertFalse(cld.isJaDigitada('a'));

        try
        {
            assertDoesNotThrow(() -> cld.registre('a'));
        } catch (Exception exc)
        {
            throw new RuntimeException(exc);
        }

        assertThrows(Exception.class, () ->
        {
            cld.registre('a');
        });

        assertTrue(cld.isJaDigitada('a'));
    }

    @Test
    void testToString()
    {
    }

    @Test
    void testEqualsHashcode()
    {
        ControladorDeLetrasJaDigitadas cld1, cld2;

        try
        {
            cld1 = new ControladorDeLetrasJaDigitadas();
            cld2 = new ControladorDeLetrasJaDigitadas();
        } catch (Exception exc)
        {
            throw new RuntimeException(exc);
        }

        assertTrue(cld1.equals(cld1));
        assertTrue(cld2.equals(cld2));
        assertTrue(cld1.equals(cld2) && cld2.equals(cld1));
        assertTrue(cld.equals(cld1) && cld.equals(cld2));

        assertEquals(cld1.hashCode(), cld1.hashCode());
        assertEquals(cld1.hashCode(), cld2.hashCode());
        assertEquals(cld.hashCode(), cld1.hashCode());
        assertEquals(cld.hashCode(), cld2.hashCode());

        try
        {
            cld2.registre('a');
            cld2.registre('b');
            cld2.registre('c');
        } catch (Exception exc)
        {
            throw new RuntimeException(exc);
        }

        assertFalse(cld1.equals(cld2));
        assertFalse(cld.equals(cld2));
        assertNotEquals(cld.hashCode(), cld2.hashCode());
        assertNotEquals(cld1.hashCode(), cld2.hashCode());

    }

    @Test
    void testClone()
    {
        assertThrows(Exception.class, () ->
        {
            new ControladorDeLetrasJaDigitadas(null);
        });

        try
        {
            cld.registre('a');
            ControladorDeLetrasJaDigitadas copia = new ControladorDeLetrasJaDigitadas(cld);
            assertTrue(cld.equals(copia));

            cld.registre('b');
            assertFalse(cld.equals(copia));
        } catch (Exception exc)
        {
            throw new RuntimeException(exc);
        }
    }
}

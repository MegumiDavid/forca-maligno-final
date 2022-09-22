package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControladorDeErrosTest {

    ControladorDeErros ce;

    @BeforeEach
    void setUp() {
        try {
            ce = new ControladorDeErros(3);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testeControladorDeErrosConstructor() {
        assertThrows(Exception.class, () -> {
            new ControladorDeErros(-10);
        });
    }

    @Test
    void testRegistreUmErro() {
        try {
            ce.registreUmErro();
            ce.registreUmErro();
            ce.registreUmErro();

            assertThrows(Exception.class, () -> {
                ce.registreUmErro();
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    void testeIsAtingidoMaximoDeErros() {

        assertEquals(false, ce.isAtingidoMaximoDeErros());
        try {
            ce.registreUmErro();
            ce.registreUmErro();
            ce.registreUmErro();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        assertEquals(true, ce.isAtingidoMaximoDeErros());
    }

    @Test
    void testToString() {
        assertEquals("0/3", ce.toString());

        try {
            ce.registreUmErro();
            ce.registreUmErro();
            ce.registreUmErro();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        assertEquals("3/3", ce.toString());
    }

    @Test
    void testEquals() {
        ControladorDeErros ce1, ce2, ce3;

        try {
            ce1 = new ControladorDeErros(3);
            ce2 = new ControladorDeErros(3);
            ce3 = new ControladorDeErros(4);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        assertEquals(ce1.equals(ce1), true);
        assertEquals(ce1.equals(ce2), true);
        assertEquals(ce1.equals(ce3), false);


        try {
            ce2.registreUmErro();
            ce2.registreUmErro();
            ce2.registreUmErro();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        assertEquals(ce1.equals(ce2), false);

    }

    /*
    @Test
    void testHashCode() {
    }
    */

    /*
    @Test
    void testClone() {
        try {
            controlador.registre('a');
            controlador.registre('b');
            controlador.registre('c');
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        ControladorDeLetrasJaDigitadas c1 = (ControladorDeLetrasJaDigitadas) controlador.clone();

        assertFalse(controlador == c1);
        assertTrue(controlador.equals(c1));
    }
    */
}
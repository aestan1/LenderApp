package com.example.estan.lenderapp;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void CantidadDeCuotasAPagar(){
        double vEsperado=8;
        double vReal=Metodos.calcularCuotas(2,2);

        assertEquals(vEsperado,vReal, 0);
    }

    @Test
    public void ValorDeCadaCuota(){
        double vEsperado=4000;
        double vReal=Metodos.calcularValorCuotas(100000,20,1,1);

        assertEquals(vEsperado,vReal, 0);
    }

    @Test
    public void ValorAPagarEnTotal(){
        double vEsperado=120000;
        double vReal=Metodos.calcularTotal(100000,20,1,1);

        assertEquals(vEsperado,vReal, 0);
    }

    }
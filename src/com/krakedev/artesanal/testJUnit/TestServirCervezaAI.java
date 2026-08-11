package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import com.krakedev.artesanal.Maquina;

public class TestServirCervezaAI {

    @Test
    public void testServirCervezaExitosoConstructor1() {
        Maquina maquina = new Maquina("M01", "Pilsener", "Cerveza Rubia", 0.02, 8000);
        
        maquina.llenarMaquina(); // cantidadActual = 7800.0 (8000 - 200)
        
        double valorPagar = maquina.servirCerveza(1000);
        
        assertEquals(20.0, valorPagar, 0.0001);
        assertEquals(6800.0, maquina.getCantidadActual(), 0.0001);
    }

    @Test
    public void testServirCervezaExitosoConstructor2() {
        Maquina maquina = new Maquina("M02", "Club", "Cerveza Negra", 0.03);
        
        maquina.recargarCerveza(5000);
        
        double valorPagar = maquina.servirCerveza(500);
        
        assertEquals(15.0, valorPagar, 0.0001);
        assertEquals(4500.0, maquina.getCantidadActual(), 0.0001);
    }

    @Test
    public void testServirCervezaInsuficiente() {
        Maquina maquina = new Maquina("M03", "Golden", "Cerveza Ale", 0.02, 5000);
        
        maquina.recargarCerveza(1000);
        
        double valorPagar = maquina.servirCerveza(2000);
        
        assertEquals(0.0, valorPagar, 0.0001);
        assertEquals(1000.0, maquina.getCantidadActual(), 0.0001);
    }

    @Test
    public void testServirCervezaCantidadExacta() {
        Maquina maquina = new Maquina("M01", "Pilsener", "Rubia", 0.02);
        
        maquina.recargarCerveza(500);
        
        double valorPagar = maquina.servirCerveza(500);
        
        assertEquals(10.0, valorPagar, 0.0001);
        assertEquals(0.0, maquina.getCantidadActual(), 0.0001);
    }

}
package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.NegocioMejorado;

public class TestRecuperarMaquina {

    @Test
    public void testRecuperarMaquinaExistenteYNoExistente() {
        NegocioMejorado negocio = new NegocioMejorado();
        
        Maquina m1 = new Maquina("M-10", "Pilsen", "Cerveza rubia", 0.05);
        negocio.getMaquinas().add(m1);

        Maquina encontrada = negocio.recuperarMaquina("M-10");
        assertNotNull(encontrada);
        assertEquals("Pilsen", encontrada.getNombreCerveza());

        Maquina noEncontrada = negocio.recuperarMaquina("M-999");
        assertNull(noEncontrada);
    }
}
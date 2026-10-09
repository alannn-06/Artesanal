package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.NegocioMejorado;

public class TestAgregarMaquina {

    @Test
    public void testAgregarMaquinaDuplicada() {
        NegocioMejorado negocio = new NegocioMejorado();
        
        boolean resultado1 = negocio.agregarMaquina("IPA", "Cerveza amarga", 0.08);
        assertTrue(resultado1);

        if (!negocio.getMaquinas().isEmpty()) {
            String codigoExistente = negocio.getMaquinas().get(0).getCodigo();
            Maquina maquinaExistente = negocio.recuperarMaquina(codigoExistente);
            assertFalse(maquinaExistente == null);
        }
    }
}
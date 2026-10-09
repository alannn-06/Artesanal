package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.NegocioMejorado;

public class TestConsumo {

    @Test
    public void testConsumirCerveza() {
        NegocioMejorado negocio = new NegocioMejorado();

        negocio.agregarMaquina("IPA", "Artesanal amarga", 0.10);
        negocio.cargarMaquinas();

        Maquina m = negocio.getMaquinas().get(0);
        String codigoMaquina = m.getCodigo();

        negocio.registrarCliente("Carlos", "1755555555");
        Cliente c = negocio.buscarClientePorCedula("1755555555");
        assertNotNull(c);

        negocio.consumirCerveza(c.getCodigo(), codigoMaquina, 500);

        assertEquals(50.0, c.getTotalConsumido());
    }
}
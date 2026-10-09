package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.NegocioMejorado;

public class TestConsultarValorVendido {

    @Test
    public void testConsultarValorVendido() {
        NegocioMejorado negocio = new NegocioMejorado();

        negocio.agregarMaquina("Stout", "Cerveza negra", 0.12);
        negocio.cargarMaquinas();

        Maquina m = negocio.getMaquinas().get(0);
        String codigoMaquina = m.getCodigo();

        negocio.registrarCliente("Ana", "1711111111");
        negocio.registrarCliente("Luis", "1722222222");

        Cliente c1 = negocio.buscarClientePorCedula("1711111111");
        Cliente c2 = negocio.buscarClientePorCedula("1722222222");

        negocio.consumirCerveza(c1.getCodigo(), codigoMaquina, 100);

        negocio.consumirCerveza(c2.getCodigo(), codigoMaquina, 200);

        double totalEsperado = 36.0;
        assertEquals(totalEsperado, negocio.consultarValorVendido(), 0.01);
    }
}
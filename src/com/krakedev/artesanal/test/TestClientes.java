package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.NegocioMejorado;

public class TestClientes {

    public static void main(String[] args) {
        NegocioMejorado negocio = new NegocioMejorado();
        
        negocio.registrarCliente("Juan Pérez", "1712345678");
        negocio.registrarCliente("Maria Lopez", "1798765432");

        Cliente cCedula = negocio.buscarClientePorCedula("1712345678");
        if (cCedula != null) {
            System.out.println("Cliente encontrado por cédula: " + cCedula.getNombre() + " (Código: " + cCedula.getCodigo() + ")");
        } else {
            System.out.println("Cliente no encontrado por cédula.");
        }

        Cliente cCodigo = negocio.buscarClientePorCodigo(101);
        if (cCodigo != null) {
            System.out.println("Cliente encontrado por código: " + cCodigo.getNombre());
        } else {
            System.out.println("Cliente no encontrado por código.");
        }
    }
}
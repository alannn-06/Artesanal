package com.krakedev.artesanal.test;

import com.krakedev.artesanal.NegocioMejorado;

public class TestClientes {

    public static void main(String[] args) {
        NegocioMejorado negocio = new NegocioMejorado();
        
        negocio.registrarCliente("Juan Pérez", "1712345678");
    }
}
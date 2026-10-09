package com.krakedev.artesanal;

import java.util.ArrayList;

public class NegocioMejorado {

    private ArrayList<Maquina> maquinas;
    private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    private int ultimoCodigo = 100;

    public NegocioMejorado() {
        maquinas = new ArrayList<Maquina>();
    }

    public ArrayList<Maquina> getMaquinas() {
        return maquinas;
    }

    public void setMaquinas(ArrayList<Maquina> maquinas) {
        this.maquinas = maquinas;
    }
    
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    public void registrarCliente(String nombre, String cedula) {
        Cliente nuevoCliente = new Cliente(nombre, cedula);
        nuevoCliente.setCodigo(ultimoCodigo);
        ultimoCodigo++;
        clientes.add(nuevoCliente);
    }
    
    public String generarCodigo() {
        int numero = (int) (Math.random() * 100) + 1;
        return "M-" + numero;
    }
    
    public boolean agregarMaquina(String nombreCerveza, String descripcion, double precioPorMl) {
        String codigo = generarCodigo();
        
        if (recuperarMaquina(codigo) != null) {
            return false;
        }
        
        Maquina maquina = new Maquina(codigo, nombreCerveza, descripcion, precioPorMl);
        maquinas.add(maquina);
        return true; 
    }
    
    
    public void cargarMaquinas() {
        for (int i = 0; i < maquinas.size(); i++) {
            Maquina m = maquinas.get(i);
            m.llenarMaquina();
        }
    }
    
    public Maquina recuperarMaquina(String codigo) {
        for (int i = 0; i < maquinas.size(); i++) {
            Maquina m = maquinas.get(i);
            if (m.getCodigo().equals(codigo)) {
                return m;
            }
        }
        return null;
    }
    
    public Cliente buscarClientePorCedula(String cedula) {
        for (int i = 0; i < clientes.size(); i++) {
            Cliente c = clientes.get(i);
            if (c.getCedula().equals(cedula)) {
                return c;
            }
        }
        return null;
    }

    public Cliente buscarClientePorCodigo(int codigo) {
        for (int i = 0; i < clientes.size(); i++) {
            Cliente c = clientes.get(i);
            if (c.getCodigo() == codigo) {
                return c;
            }
        }
        return null;
    }

    public void registrarConsumo(Cliente cliente, double valorConsumido) {
        if (cliente != null) {
            double nuevoTotal = cliente.getTotalConsumido() + valorConsumido;
            cliente.setTotalConsumido(nuevoTotal);
        }
    }

    public void consumirCerveza(int codigoCliente, String codigoMaquina, double cantidad) {
        Maquina maquina = recuperarMaquina(codigoMaquina);
        Cliente cliente = buscarClientePorCodigo(codigoCliente);

        if (maquina != null && cliente != null) {
            double valorServido = maquina.servirCerveza(cantidad);
            registrarConsumo(cliente, valorServido);
        }
    }
    
    
    public double consultarValorVendido() {
        double totalVendido = 0;
        for (int i = 0; i < clientes.size(); i++) {
            Cliente c = clientes.get(i);
            totalVendido += c.getTotalConsumido();
        }
        return totalVendido;
    }
    
    
}
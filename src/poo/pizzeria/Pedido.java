/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.pizzeria;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Candelaria
 */
public class Pedido {
    private Date fechaHoraCreacion;
    private Date fechaHoraEntrega;    
    private String nombreCliente;
    private int numero;
    private Factura factura;
    private Estado estado;
    private List<DetallePedido> detallesPedido;

    /**
     * Constructor por defecto de la clase Pedido
     */
    public Pedido() {
        detallesPedido= new ArrayList();
    }  
    
    /** 
     * Constructor sin atributos referenciales de la clase Pedido.
     * @param fechaHoraCreacion
     * @param fechaHoraEntrega     
     * @param nombreCliente
     * @param numero 
     */
    public Pedido(Date fechaHoraCreacion, Date fechaHoraEntrega, String nombreCliente, int numero) {
        this.fechaHoraEntrega = fechaHoraEntrega;
        this.fechaHoraCreacion = fechaHoraCreacion;
        this.nombreCliente = nombreCliente;
        this.numero = numero;
    }
    
    /**
     * Constructor con todos los atributos de la clase Pedido.
     * @param fechaHoraCreacion
     * @param fechaHoraEntrega
     * @param nombreCliente
     * @param numero
     * @param factura
     * @param estado
     * @param detallesPedido 
     */
    public Pedido(Date fechaHoraCreacion,Date fechaHoraEntrega,String nombreCliente, int numero, Factura factura, Estado estado, List<DetallePedido> detallesPedido) {
        this.fechaHoraEntrega = fechaHoraEntrega;
        this.fechaHoraCreacion = fechaHoraCreacion;
        this.nombreCliente = nombreCliente;
        this.numero = numero;
        this.factura = factura;
        this.estado = estado;
        this.detallesPedido = detallesPedido;
    }
    
    /**
     * Método que devuelve true si el estado es Pendiente de Facturación.
     * @return boolean
     */
    public boolean esPteFacturacion(){
        return estado.esPteFacturacion();
    }
    
     /**
     * Método que calcula el total del pedido, es decir suma todos los subtotales de los detalles.
     * @return BigDecimal
     */
    public BigDecimal calcTotalPedido()
    {
       BigDecimal total= new BigDecimal(0);
       Iterator it= detallesPedido.iterator();
       while(it.hasNext())
       {
           DetallePedido detalle= (DetallePedido)it.next();
           total.add(detalle.calcTotalItem());
       }
       return total;
    }
    
    // A continuación se listan todos los métodos de seteo
    // de cada atributo de la clase

    public Date getFechaHoraEntrega() {
        return fechaHoraEntrega;
    }

    public void setFechaHoraEntrega(Date fechaHoraEntrega) {
        this.fechaHoraEntrega = fechaHoraEntrega;
    }

    public Date getFechaHoraCreacion() {
        return fechaHoraCreacion;
    }

    public void setFechaHoraCreacion(Date fechaHoraCreacion) {
        this.fechaHoraCreacion = fechaHoraCreacion;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<DetallePedido> getDetallesPedido() {
        return detallesPedido;
    }

    public void setDetallesPedido(List<DetallePedido> detallesPedido) {
        this.detallesPedido = detallesPedido;
    }    

    @Override
    public String toString() {
        StringBuilder retorno = new StringBuilder().append("\n Pedido: Fecha Hora Creacion: ").append(fechaHoraCreacion).append(" FechaHoraEntrega: ").append(fechaHoraEntrega).append("\n - N° Pedido: ").append(numero).append("\n - Cliente: ").append(nombreCliente).append(" - Estado: ").append(estado.getNombre());
        Iterator it = detallesPedido.iterator();
        while(it.hasNext())
        {
            retorno.append("\n");
            DetallePedido detalle= (DetallePedido)it.next();
            retorno.append(detalle.toString());
        }
        return  retorno.toString();
    }
    
    
}
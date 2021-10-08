/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author @yotis56
 */
public class Reserva {
  int codigoReserva;
  int solo_ida;
  int cantidadPasajeros;
  int adultos;
  int infantes;
  Cliente cliente;
  //String documentoCliente;
  int tarifa;
  Vuelo vueloAsociado;
  //int codigoVueloAsoc;

  public Reserva() {
  }

  public Reserva(int codigoReserva, int solo_ida, int cantidadPasajeros, int adultos, int infantes, Cliente cliente, int tarifa, Vuelo vueloAsociado) {
    this.codigoReserva = codigoReserva;
    this.solo_ida = solo_ida;
    this.cantidadPasajeros = cantidadPasajeros;
    this.adultos = adultos;
    this.infantes = infantes;
    this.cliente = cliente;
    this.tarifa = tarifa;
    this.vueloAsociado = vueloAsociado;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public Vuelo getVueloAsociado() {
    return vueloAsociado;
  }

  public void setVueloAsociado(Vuelo vueloAsociado) {
    this.vueloAsociado = vueloAsociado;
  }

  public int getCodigoReserva() {
    return codigoReserva;
  }

  public void setCodigoReserva(int codigoReserva) {
    this.codigoReserva = codigoReserva;
  }

  public int getSolo_ida() {
    return solo_ida;
  }

  public void setSolo_ida(int solo_ida) {
    this.solo_ida = solo_ida;
  }

  public int getCantidadPasajeros() {
    return cantidadPasajeros;
  }

  public void setCantidadPasajeros(int cantidadPasajeros) {
    this.cantidadPasajeros = cantidadPasajeros;
  }

  public int getAdultos() {
    return adultos;
  }

  public void setAdultos(int adultos) {
    this.adultos = adultos;
  }

  public int getInfantes() {
    return infantes;
  }

  public void setInfantes(int infantes) {
    this.infantes = infantes;
  }

  public int getTarifa() {
    return tarifa;
  }

  public void setTarifa(int tarifa) {
    this.tarifa = tarifa;
  }
  
}

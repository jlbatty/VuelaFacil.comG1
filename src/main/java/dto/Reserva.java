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
  String documentoCliente;
  int tarifa;

  public Reserva() {
  }

  public Reserva(int codigoReserva, int solo_ida, int cantidadPasajeros, int adultos, int infantes, String documentoCliente, int tarifa) {
    this.codigoReserva = codigoReserva;
    this.solo_ida = solo_ida;
    this.cantidadPasajeros = cantidadPasajeros;
    this.adultos = adultos;
    this.infantes = infantes;
    this.documentoCliente = documentoCliente;
    this.tarifa = tarifa;
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

  public String getDocumentoCliente() {
    return documentoCliente;
  }

  public void setDocumentoCliente(String documentoCliente) {
    this.documentoCliente = documentoCliente;
  }

  public int getTarifa() {
    return tarifa;
  }

  public void setTarifa(int tarifa) {
    this.tarifa = tarifa;
  }
  
}

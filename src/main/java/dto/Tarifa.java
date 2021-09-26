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
public class Tarifa {
  int codigoTarifa;
  String nombreTarifa;
  int precioTarifa;

  public Tarifa() {
  }

  public Tarifa(int codigoTarifa, String nombreTarifa, int precioTarifa) {
    this.codigoTarifa = codigoTarifa;
    this.nombreTarifa = nombreTarifa;
    this.precioTarifa = precioTarifa;
  }

  public int getCodigoTarifa() {
    return codigoTarifa;
  }

  public void setCodigoTarifa(int codigoTarifa) {
    this.codigoTarifa = codigoTarifa;
  }

  public String getNombreTarifa() {
    return nombreTarifa;
  }

  public void setNombreTarifa(String nombreTarifa) {
    this.nombreTarifa = nombreTarifa;
  }

  public int getPrecioTarifa() {
    return precioTarifa;
  }

  public void setPrecioTarifa(int precioTarifa) {
    this.precioTarifa = precioTarifa;
  }
  
  
}

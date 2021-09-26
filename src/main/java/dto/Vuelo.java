/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.sql.Date;

/**
 *
 * @author @yotis56
 */
public class Vuelo {
  int idVuelo;
  Date fechaVuelo;
  //debería usar un Timestamp?
  int codigoReservaAsoc;
  String matriculaAvion;
  int codigoRutaAsoc;

  public Vuelo() {
  }

  public Vuelo(int idVuelo, Date fechaVuelo, int codigoReservaAsoc, String matriculaAvion, int codigoRutaAsoc) {
    this.idVuelo = idVuelo;
    this.fechaVuelo = fechaVuelo;
    this.codigoReservaAsoc = codigoReservaAsoc;
    this.matriculaAvion = matriculaAvion;
    this.codigoRutaAsoc = codigoRutaAsoc;
  }

  public int getIdVuelo() {
    return idVuelo;
  }

  public void setIdVuelo(int idVuelo) {
    this.idVuelo = idVuelo;
  }

  public Date getFechaVuelo() {
    return fechaVuelo;
  }

  public void setFechaVuelo(Date fechaVuelo) {
    this.fechaVuelo = fechaVuelo;
  }

  public int getCodigoReservaAsoc() {
    return codigoReservaAsoc;
  }

  public void setCodigoReservaAsoc(int codigoReservaAsoc) {
    this.codigoReservaAsoc = codigoReservaAsoc;
  }

  public String getMatriculaAvion() {
    return matriculaAvion;
  }

  public void setMatriculaAvion(String matriculaAvion) {
    this.matriculaAvion = matriculaAvion;
  }

  public int getCodigoRutaAsoc() {
    return codigoRutaAsoc;
  }

  public void setCodigoRutaAsoc(int codigoRutaAsoc) {
    this.codigoRutaAsoc = codigoRutaAsoc;
  }
  
}

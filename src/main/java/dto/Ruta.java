/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author @yotis56
 */
public class Ruta {
  int codigoRuta;
  String Salida;
  String IATASalida;
  String destino;
  String IATADestino;
  //Probablemente sea redundante poner a salida/destino como IATA, y como string en el nombre
  Time tiempoAprox;
  //¿Deberíamos usar Timestamp de sql?
  float distancia;

  public Ruta() {
  }

  public Ruta(int codigoRuta, String Salida, String IATASalida, String destino, String IATADestino, Time tiempoAprox, float distancia) {
    this.codigoRuta = codigoRuta;
    this.Salida = Salida;
    this.IATASalida = IATASalida;
    this.destino = destino;
    this.IATADestino = IATADestino;
    this.tiempoAprox = tiempoAprox;
    this.distancia = distancia;
  }

  public int getCodigoRuta() {
    return codigoRuta;
  }

  public void setCodigoRuta(int codigoRuta) {
    this.codigoRuta = codigoRuta;
  }

  public String getSalida() {
    return Salida;
  }

  public void setSalida(String Salida) {
    this.Salida = Salida;
  }

  public String getIATASalida() {
    return IATASalida;
  }

  public void setIATASalida(String IATASalida) {
    this.IATASalida = IATASalida;
  }

  public String getDestino() {
    return destino;
  }

  public void setDestino(String destino) {
    this.destino = destino;
  }

  public String getIATADestino() {
    return IATADestino;
  }

  public void setIATADestino(String IATADestino) {
    this.IATADestino = IATADestino;
  }

  public Time getTiempoAprox() {
    return tiempoAprox;
  }

  public void setTiempoAprox(Time tiempoAprox) {
    //este método podría retornar el tiempo como String, en formato 'HH:MM:SS'
    this.tiempoAprox = tiempoAprox;
  }

  public float getDistancia() {
    return distancia;
  }

  public void setDistancia(float distancia) {
    this.distancia = distancia;
  }
  
}

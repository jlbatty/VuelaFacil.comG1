/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalTime;

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
  LocalTime tiempoAprox;
  //¿Deberíamos usar Timestamp de sql?
  float distancia;

  public Ruta() {
  }

  public Ruta(int codigoRuta, String Salida, String IATASalida, String destino, String IATADestino, LocalTime tiempoAprox, float distancia) {
    this.codigoRuta = codigoRuta;
    this.Salida = Salida;
    this.IATASalida = IATASalida;
    this.destino = destino;
    this.IATADestino = IATADestino;
    this.tiempoAprox = tiempoAprox;
    this.distancia = distancia;
  }
  
  public String separarCiudadAeropuerto (int indice, String ciudad){
    //el índice funciona así: 0 para obtener la ciudad, 1 para obtener el aeropuerto
    String[] slicedString = ciudad.split("-");
    return slicedString[indice];
  }
  
  public String getCiudadSalida(){
    return this.separarCiudadAeropuerto(0, Salida);
  }
  public String getAeropuertoSalida() {
    return separarCiudadAeropuerto(1, Salida);
  }
  public String getCiudadDestino(){
    return this.separarCiudadAeropuerto(0, destino);
  }
  public String getAeropuertoDestino() {
    return separarCiudadAeropuerto(1, destino);
  }
  //public 
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

  public LocalTime getTiempoAprox() {
    return tiempoAprox;
  }

  public void setTiempoAprox(LocalTime tiempoAprox) {
    //este método podría retornar el tiempo como String, en formato 'HH:MM:SS'
    this.tiempoAprox = tiempoAprox;
  }

  public float getDistancia() {
    return distancia;
  }

  public void setDistancia(float distancia) {
    this.distancia = distancia;
  }

  @Override
  public String toString() {
    return "Ruta{" + "codigoRuta=" + codigoRuta + ", Salida=" + Salida + ", IATASalida=" + IATASalida + ", destino=" + destino + ", IATADestino=" + IATADestino + ", tiempoAprox=" + tiempoAprox + ", distancia=" + distancia + '}';
  }
  
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 *
 * @author @yotis56
 */
public class Vuelo {
  private int idVuelo;
  private Date fechaVuelo;
  private Timestamp horaVuelo;
  private Avion avionAsociado;
  //String matriculaAvion;
  private Ruta rutaAsociada;
  //int codigoRutaAsoc;
  private int ejecutivaDisponible; 
  private int economicaDisponible;
          
  public Vuelo() {
  }

  public Vuelo(int idVuelo, Date fechaVuelo, Timestamp horaVuelo, Avion avionAsociado, Ruta rutaAsociada, int ejecutivaDisponible, int economicaDisponible) {
    this.idVuelo = idVuelo;
    this.fechaVuelo = fechaVuelo;
    this.horaVuelo = horaVuelo;
    this.avionAsociado = avionAsociado;
    this.rutaAsociada = rutaAsociada;
    this.ejecutivaDisponible = ejecutivaDisponible;
    this.economicaDisponible = economicaDisponible;
  }

  public String getHoraVuelo() {
    ZoneId zone = ZoneId.of("America/Bogota");
    LocalDateTime salida = this.horaVuelo.toInstant().atZone(zone).toLocalDateTime();
    return salida.toLocalTime().toString();
  }
  
  public String getHoraLlegada(){
    //acá tengo que sumar las horas
    ZoneId zone = ZoneId.of("America/Bogota");
    //aca convertí la fecha de salida, a un localDateTime
    LocalDateTime salida = this.horaVuelo.toInstant().atZone(zone).toLocalDateTime();
    salida = salida.plusHours(this.rutaAsociada.getTiempoAprox().getHour());
    salida = salida.plusMinutes(this.rutaAsociada.getTiempoAprox().getMinute());
    salida = salida.plusSeconds(this.rutaAsociada.getTiempoAprox().getSecond());
    return salida.toLocalTime().toString();
  } 

  public void setHoraVuelo(Timestamp horaVuelo) {
    this.horaVuelo = horaVuelo;
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

  public Avion getAvionAsociado() {
    return avionAsociado;
  }

  public void setAvionAsociado(Avion avionAsociado) {
    this.avionAsociado = avionAsociado;
  }

  public Ruta getRutaAsociada() {
    return rutaAsociada;
  }

  public void setRutaAsociada(Ruta rutaAsociada) {
    this.rutaAsociada = rutaAsociada;
  }

  public int getEjecutivaDisponible() {
    return ejecutivaDisponible;
  }

  public void setEjecutivaDisponible(int ejecutivaDisponible) {
    this.ejecutivaDisponible = ejecutivaDisponible;
  }

  public int getEconomicaDisponible() {
    return economicaDisponible;
  }

  public void setEconomicaDisponible(int economicaDisponible) {
    this.economicaDisponible = economicaDisponible;
  }

  @Override
  public String toString() {
    return "Vuelo{" + "idVuelo=" + idVuelo + ", fechaVuelo=" + fechaVuelo + ", avionAsociado=" + avionAsociado + ", rutaAsociada=" + rutaAsociada + ", ejecutivaDisponible=" + ejecutivaDisponible + ", economicaDisponible=" + economicaDisponible + '}';
  }

  
  
}

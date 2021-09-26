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
public class Avion {
  String matrícula;
  String marca;
  String modelo;
  int capacidadTotal;
  int capacidadEjecutiva;
  int capacidadEconómica;
  int totalDisponible;
  int ejecutivaDisponble;
  int economicaDisponible;

  public Avion() {
  }

  public Avion(String matrícula, String marca, String modelo, int capacidadTotal, int capacidadEjecutiva, int capacidadEconómica, int totalDisponible, int ejecutivaDisponble, int economicaDisponible) {
    this.matrícula = matrícula;
    this.marca = marca;
    this.modelo = modelo;
    this.capacidadTotal = capacidadTotal;
    this.capacidadEjecutiva = capacidadEjecutiva;
    this.capacidadEconómica = capacidadEconómica;
    this.totalDisponible = totalDisponible;
    this.ejecutivaDisponble = ejecutivaDisponble;
    this.economicaDisponible = economicaDisponible;
  }

  public String getMatrícula() {
    return matrícula;
  }

  public void setMatrícula(String matrícula) {
    this.matrícula = matrícula;
  }

  public String getMarca() {
    return marca;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public String getModelo() {
    return modelo;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public int getCapacidadTotal() {
    return capacidadTotal;
  }

  public void setCapacidadTotal(int capacidadTotal) {
    this.capacidadTotal = capacidadTotal;
  }

  public int getCapacidadEjecutiva() {
    return capacidadEjecutiva;
  }

  public void setCapacidadEjecutiva(int capacidadEjecutiva) {
    this.capacidadEjecutiva = capacidadEjecutiva;
  }

  public int getCapacidadEconómica() {
    return capacidadEconómica;
  }

  public void setCapacidadEconómica(int capacidadEconómica) {
    this.capacidadEconómica = capacidadEconómica;
  }

  public int getTotalDisponible() {
    return totalDisponible;
  }

  public void setTotalDisponible(int totalDisponible) {
    this.totalDisponible = totalDisponible;
  }

  public int getEjecutivaDisponble() {
    return ejecutivaDisponble;
  }

  public void setEjecutivaDisponble(int ejecutivaDisponble) {
    this.ejecutivaDisponble = ejecutivaDisponble;
  }

  public int getEconomicaDisponible() {
    return economicaDisponible;
  }

  public void setEconomicaDisponible(int economicaDisponible) {
    this.economicaDisponible = economicaDisponible;
  }
  
  
}

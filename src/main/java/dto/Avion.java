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
  int capacidadEconomica;

  public Avion() {
  }

  public Avion(String matrícula, String marca, String modelo, int capacidadTotal, int capacidadEjecutiva, int capacidadEconomica) {
    this.matrícula = matrícula;
    this.marca = marca;
    this.modelo = modelo;
    this.capacidadTotal = capacidadTotal;
    this.capacidadEjecutiva = capacidadEjecutiva;
    this.capacidadEconomica = capacidadEconomica;
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

  public int getCapacidadEconomica() {
    return capacidadEconomica;
  }

  public void setCapacidadEconomica(int capacidadEconomica) {
    this.capacidadEconomica = capacidadEconomica;
  }
  
}

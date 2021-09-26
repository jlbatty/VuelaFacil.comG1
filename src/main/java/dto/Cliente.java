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
public class Cliente {
  //Revisar qué anotaciones hay que hacerle a las propiedades.
  
  //si fuera un id auto-incrementable:
  //@GeneratedValue(strategy = GenerationType.IDENTITY)
  private String numerodocumento;
  private String tipoDocumento;
  private String nombres;
  private String apellidos;
  private String telefono;
  private String correoElectronico;
  
  public Cliente() {
  }

  public Cliente(String numerodocumento, String tipoDocumento, String nombres, String apellidos, String telefono, String correoElectronico) {
    this.numerodocumento = numerodocumento;
    this.tipoDocumento = tipoDocumento;
    this.nombres = nombres;
    this.apellidos = apellidos;
    this.telefono = telefono;
    this.correoElectronico = correoElectronico;
  }

  public String getNumerodocumento() {
    return numerodocumento;
  }

  public void setNumerodocumento(String numerodocumento) {
    this.numerodocumento = numerodocumento;
  }

  public String getTipoDocumento() {
    return tipoDocumento;
  }

  public void setTipoDocumento(String tipoDocumento) {
    this.tipoDocumento = tipoDocumento;
  }

  public String getNombres() {
    return nombres;
  }

  public void setNombres(String nombres) {
    this.nombres = nombres;
  }

  public String getApellidos() {
    return apellidos;
  }

  public void setApellidos(String apellidos) {
    this.apellidos = apellidos;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public String getCorreoElectronico() {
    return correoElectronico;
  }

  public void setCorreoElectronico(String correoElectronico) {
    this.correoElectronico = correoElectronico;
  }
  
}

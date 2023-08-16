package com.vp.springserver.model.prospecto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Prospecto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String nombre;
  private String apellidop;
  private String apellidom;
  private String calle;
  private String numero;
  private String colonia;
  private String cp;
  private String telefono;
  private String rfc;
  private int idarchivos;
  private int estatus;
  private String descripcion;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellidop() {
    return apellidop;
  }

  public void setApellidop(String apellidop) {
    this.apellidop = apellidop;
  }

  public String getApellidom() {
    return apellidom;
  }

  public void setApellidom(String apellidom) {
    this.apellidom = apellidom;
  }
  
   public String getCalle() {
    return calle;
  }

  public void setCalle(String calle) {
    this.calle = calle;
  }
  
  public String getNumero() {
    return numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }
  
  public String getColonia() {
    return colonia;
  }

  public void setColonia(String colonia) {
    this.colonia = colonia;
  }
  
  public String getCp() {
    return cp;
  }

  public void setCp(String cp) {
    this.cp = cp;
  }
  
  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }
  
  public String getRfc() {
    return rfc;
  }

  public void setRfc(String rfc) {
    this.rfc = rfc;
  }
  
    public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }
  
  public int getIdarchivos() {
    return idarchivos;
  }

  public void setIdarchivos(int idarchivos) {
    this.idarchivos = idarchivos;
  }
  
  public int getEstatus() {
    return estatus;
  }

  public void setEstatus(int estatus) {
    this.estatus = estatus;
  }
  
  @Override
  public String toString() {
    return "Prospecto{" +
        "id=" + id +
        ", nombre='" + nombre + '\'' +
        ", apellidop='" + apellidop + '\'' +
        ", apellidom='" + apellidom + '\'' +
        ", calle='" + calle + '\'' +
        ", numero='" + numero + '\'' +
        ", colonia='" + colonia + '\'' +
        ", cp='" + cp + '\'' +
        ", telefono='" + telefono + '\'' +
        ", rfc='" + rfc + '\'' +
        ", descripcion='" + descripcion + '\'' +
        ", idarchivos='" + idarchivos + '\'' +
        ", estatus='" + estatus + '\'' +
        '}';
  }
}

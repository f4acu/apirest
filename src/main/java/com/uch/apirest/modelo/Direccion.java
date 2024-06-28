package com.uch.apirest.modelo;

import jakarta.persistence.*;

@Entity
@Table(name="Direccion")
public class Direccion {

    @Id
    @Column (name = "name_id")
    private Long id;
    @Column (name= "calle", nullable = false)
    private String calle;
    @Column (name = "numero", nullable = false)
    private int numero;
    @Column (name = "ciudad", nullable = false)
    private String ciudad;

    public Direccion(){

    }
    public Direccion (String calle, int numero, String ciudad) {
        this.calle = calle;
        this.numero = numero;
        this.ciudad = ciudad;
    }
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @MapsId
    @JoinColumn(name = "name_id")
    private Name name;

    public String getCalle() {
        return calle;
    }
    public void setCalle(String calle) {
        this.calle = calle;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setName(Name name) {
        this.name = name;
    }
}


package com.uch.apirest.modelo;

import jakarta.persistence.*;

@Entity
@Table(name="name")
public class Name{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column (name = "Nombre")
    private String nombre;
    @Column (name= "Edad")
    private int edad;

    @OneToOne(mappedBy = "name", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Direccion direccion;

    public Name(){

    }

    public Name(String nombre, int edad, Direccion direccion){
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
}



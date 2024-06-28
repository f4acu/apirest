package com.uch.apirest.modelo;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Name")
public class Name{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column (name = "Nombre")
    private String nombre;
    @Column (name= "Edad")
    private int edad;

    @OneToOne(mappedBy = "name", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Direccion direccion;

    @OneToMany(mappedBy = "name", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Phone> phones = new ArrayList<>();

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

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public void addPhones (Phone phone) {
        phones.add(phone);
        phone.setName(this);
    }

    public void removePhone (Phone phone) {
        phones.remove(phone);
        phone.setName(null);
    }
}

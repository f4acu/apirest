package com.uch.apirest.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table (name = "Phone")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "numero")
    private Long number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "name_id")
    @JsonBackReference
    private Name name;

    public Phone() {}

    public Phone(Long number) {
        this.number = number;
    }

    public Long getId(){
        return id;
    }

    public Long getNumber(){
        return number;
    }

    public void setNumber(Long number){
        this.number = number;
    }

    public Name getName(){
        return name;
    }

    public void setName(Name name){
        this.name = name;
    }
}

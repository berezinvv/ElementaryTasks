package com.ssitacademy.berezinvv.storage.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ssitacademy.berezinvv.storage.annotations.ModelEntity;
import com.ssitacademy.berezinvv.storage.annotations.OneToOne;

import java.io.Serializable;

@ModelEntity(nameTable = "engine")
public class Engine implements Serializable {
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("feul")
    //@OneToOne
    private Fuel feul;

    @JsonCreator
    public Engine(@JsonProperty("id")int id, @JsonProperty("name")String name, @JsonProperty("feul")Fuel feul) {
        this.id = id;
        this.name = name;
        this.feul = feul;
    }

    public Engine() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Fuel getFeul() {
        return feul;
    }

    public void setFeul(Fuel feul) {
        this.feul = feul;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", feul=" + feul +
                '}';
    }
}

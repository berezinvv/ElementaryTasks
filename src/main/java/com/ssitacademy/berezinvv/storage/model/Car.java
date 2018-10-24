package com.ssitacademy.berezinvv.storage.model;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ssitacademy.berezinvv.storage.annotations.ModelEntity;
import com.ssitacademy.berezinvv.storage.annotations.OneToMany;
import com.ssitacademy.berezinvv.storage.annotations.OneToOne;

import java.io.Serializable;
import java.util.List;

@ModelEntity(nameTable = "storage")
public class Car implements Serializable {
    @JsonProperty("id")
    private int id;
    @JsonProperty("brand")
    private String brand;
    @JsonProperty("model")
    private String model;
    @JsonProperty("engine")
    @OneToOne
    private Engine engine;
    @JsonProperty("owner")
    @OneToOne
    private Owner owner;
    @JsonProperty("noteMaintenanceList")
    @OneToMany(mapping = "car")
    private List<NoteMaintenance> noteMaintenanceList;

    @JsonCreator
    public Car(@JsonProperty("id") int id, @JsonProperty("brand") String brand, @JsonProperty("model") String model,
               @JsonProperty("engine") Engine engine, @JsonProperty("owner") Owner owner) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.engine = engine;
        this.owner = owner;
    }

    public Car() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public List<NoteMaintenance> getNoteMaintenanceList() {
        return noteMaintenanceList;
    }

    public void setNoteMaintenanceList(List<NoteMaintenance> noteMaintenanceList) {
        this.noteMaintenanceList = noteMaintenanceList;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", engine=" + engine +
                ", owner=" + owner +
                ", noteMaintenanceList=" + noteMaintenanceList +
                '}';
    }
}

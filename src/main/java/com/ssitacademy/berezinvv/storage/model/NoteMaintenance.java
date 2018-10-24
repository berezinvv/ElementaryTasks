package com.ssitacademy.berezinvv.storage.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ssitacademy.berezinvv.storage.annotations.ManyToOne;
import com.ssitacademy.berezinvv.storage.annotations.ModelEntity;

@ModelEntity(nameTable = "maintenance")
public class NoteMaintenance {
    @JsonProperty("id")
    private int id;
    @JsonProperty("car")
    @ManyToOne
    private Car car;
    @JsonProperty("enumerator")
    private double enumerator;
    @JsonProperty("typeMaintenance")
    private String typeMaintenance;

    @JsonCreator
    public NoteMaintenance(@JsonProperty("id") int id, @JsonProperty("car") Car car, @JsonProperty("enumerator") double enumerator, @JsonProperty("typeMaintenance") String typeMaintenance) {
        this.id = id;
        this.car = car;
        this.enumerator = enumerator;
        this.typeMaintenance = typeMaintenance;
    }

    public NoteMaintenance() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public double getEnumerator() {
        return enumerator;
    }

    public void setEnumerator(double enumerator) {
        this.enumerator = enumerator;
    }

    public String getTypeMaintenance() {
        return typeMaintenance;
    }

    public void setTypeMaintenance(String typeMaintenance) {
        this.typeMaintenance = typeMaintenance;
    }

    @Override
    public String toString() {
        String carInfo = (car!=null)?", car=" + car:"";
        return "NoteMaintenance{" +
                "id=" + id + carInfo +
                ", enumerator=" + enumerator +
                ", typeMaintenance='" + typeMaintenance + '\'' +
                '}';
    }
}

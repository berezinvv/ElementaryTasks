package com.ssitacademy.berezinvv.storage.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class Storage {

    @JsonProperty("id")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

package com.devsuperior.uri2621.dto;

import com.devsuperior.uri2621.projections.ProdMinProjections;

public class ProdMinDTO {
    private String name;

    public ProdMinDTO() {
    }
    public ProdMinDTO(String name) {
        this.name = name;
    }
    public ProdMinDTO(ProdMinProjections proj) {
        name = proj.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Produto: " +
                "name= " + name;
    }
}

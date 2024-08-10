package com.devsuperior.uri2611.dto;

import com.devsuperior.uri2611.projections.MovMinProjection;

public class MovMinDTO {
    private Long id;
    private String name;


    public MovMinDTO() {
    }
    public MovMinDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    public MovMinDTO(MovMinProjection proj) {
        id = proj.getId();
        name = proj.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Movie : \n" +
                "id=" + id +
                ", name='" + name + '\'';
    }
}

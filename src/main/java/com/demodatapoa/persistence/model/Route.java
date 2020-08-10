package com.demodatapoa.persistence.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Route {

    @Id   //   @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Código é obrigatório")
    @JsonProperty("codigo")
    private String code;

    @NotBlank(message = "Nome é obrigatório")
    @JsonProperty("nome")
    private String name;

//    @OneToMany(mappedBy="route")
//    private Set<RoutePoint> points;

    public Route() {};

    public Route(long id, @NotBlank(message = "Código é obrigatório") String code, @NotBlank(message = "Nome é obrigatório") String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", codigo='" + code + '\'' +
                ", nome='" + name + '\'' +
                '}';
    }
}

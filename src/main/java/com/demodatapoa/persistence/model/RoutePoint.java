package com.demodatapoa.persistence.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Entity
public class RoutePoint {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

//    @ManyToOne
//    @JoinColumn(name="route_id", nullable=false)
//    private Route route;
    private long routeId;

    @NotBlank(message = "Número do ponto é obrigatório")
    private int number;

    @NotBlank(message = "Latitude é obrigatório")
    private BigDecimal lat;

    @NotBlank(message = "Longitude é obrigatório")
    private BigDecimal lng;

    public RoutePoint() {
    }

    public RoutePoint(long routeId, int number, BigDecimal lat, BigDecimal lng) {
        this.id = id;
        this.routeId = routeId;
        this.number = number;
        this.lat = lat;
        this.lng = lng;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

//    public Route getRoute() {
//        return route;
//    }
//
//    public void setRoute(Route route) {
//        this.route = route;
//    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public BigDecimal getLat() {
        return lat;
    }

    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }

    public BigDecimal getLng() {
        return lng;
    }

    public void setLng(BigDecimal lng) {
        this.lng = lng;
    }

    public long getRouteId() {
        return routeId;
    }

    public void setRouteId(long routeId) {
        this.routeId = routeId;
    }
}

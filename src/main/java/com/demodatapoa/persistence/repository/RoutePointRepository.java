package com.demodatapoa.persistence.repository;

import com.demodatapoa.persistence.model.Route;
import com.demodatapoa.persistence.model.RoutePoint;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoutePointRepository extends CrudRepository<RoutePoint, Long> {

    List<RoutePoint> findByRoute(Route route);
}

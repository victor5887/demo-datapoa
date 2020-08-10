package com.demodatapoa.persistence.repository;

import com.demodatapoa.persistence.model.Route;
import com.demodatapoa.persistence.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepository extends CrudRepository<Route, Long> {

    List<Route> findByName(String name);

    Route getById(long routeId);
}

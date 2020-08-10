package com.demodatapoa.controller;

import com.demodatapoa.persistence.model.Route;
import com.demodatapoa.persistence.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.demodatapoa.config.types.Endpoints.BUS_ROUTE;


@Controller
@RequestMapping("books")
public class RouteController {

    private final RouteRepository routeRepository;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    public RouteController(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    @GetMapping("/new-route")
    public String showSignUpForm(Route route) {
        return "add-route";
    }

    @PostMapping("/add-route")
    public String addRoute(@Valid Route route, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-route";
        }

        routeRepository.save(route);
        model.addAttribute("routes", routeRepository.findAll());
        return "redirect:/route";
    }

    @GetMapping("/edit-route/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Route route = routeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid route Id:" + id));
        model.addAttribute("route", route);
        return "update-route";
    }

    @PostMapping("/update-route/{id}")
    public String updateRoute(@PathVariable("id") long id, @Valid Route route, BindingResult result, Model model) {
        if (result.hasErrors()) {
            route.setId(id);
            return "update-route";
        }

        routeRepository.save(route);
        model.addAttribute("routes", routeRepository.findAll());
        return "redirect:/route";
    }

    @GetMapping("/delete-route/{id}")
    public String deleteRoute(@PathVariable("id") long id, Model model) {
        Route route = routeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid route Id:" + id));
        routeRepository.delete(route);
        model.addAttribute("routes", routeRepository.findAll());
        return "route";
    }

//    @RequestMapping(value = "/route-get-all")
    @GetMapping(value = "/route-get-all")
    public String getRouteList() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);
        this.restTemplate.setMessageConverters(messageConverters);

        routeRepository.deleteAll();

        ArrayList<Route> routes = new ArrayList<>(); //  = Arrays.asList(restTemplate.getForObject(BUS_ROUTE.location(),  Route[].class));
        Collections.addAll(routes, restTemplate.getForObject(BUS_ROUTE.location(),  Route[].class));

        for (Route route: routes) {
            routeRepository.save(route);
            System.out.println(route.toString());
        }

//        return "redirect:/route";
        return "route";
    }

    @RequestMapping(value = "/route-delete-all")
    public String deleteAllRoutes() {
        routeRepository.deleteAll();
        return "redirect:/route";
    }

}

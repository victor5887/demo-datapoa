//package com.demodatapoa.controller;
//
//import com.demodatapoa.persistence.model.Route;
//import com.demodatapoa.persistence.model.RoutePoint;
//import com.demodatapoa.persistence.repository.RoutePointRepository;
//import com.demodatapoa.persistence.repository.RouteRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
//import static com.demodatapoa.config.types.Endpoints.BUS_ROUTE;
//import static com.demodatapoa.config.types.Endpoints.ITINERARY;
//
//public class RoutePointController {
//
//    private final RoutePointRepository routePointRepository;
//
//    @Autowired
//    public RoutePointController(RoutePointRepository routePointRepository) {
//        this.routePointRepository = routePointRepository;
//    }
//
//    @Autowired
//    RestTemplate restTemplate;
//
//    @GetMapping("{/route/{route-id}/delete-route-point/{id}")
//    public String deleteRoute(@PathVariable("id") long id, Model model) {
//        RoutePoint route = routePointRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid route-point Id:" + id));
//        routePointRepository.delete(route);
//        model.addAttribute("route-points", routePointRepository.findAll());
//        return "route-point";
//    }
//
////    route/{route-id}/
//    @GetMapping(value = "/route-point-get-all")
//    public String getRouteList(@PathVariable("route-id") long routeId, Model model) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        HttpEntity<String> entity = new HttpEntity<String>(headers);
//        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
//        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
//        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
//        messageConverters.add(converter);
//        this.restTemplate.setMessageConverters(messageConverters);
//
//        //routeRepository.getById(routeId);
//        Iterable<Route> routes = routeRepository.findAll();
//        ArrayList<RoutePoint> routePoints = new ArrayList<>(); //  = Arrays.asList(restTemplate.getForObject(BUS_ROUTE.location(),  Route[].class));
//
//        //routePointRepository.deleteAll();
//
//        for (Route route: routes) {
//            Collections.addAll(routePoints, restTemplate.getForObject(ITINERARY.location(route.getId()), RoutePoint[].class));
//
//            for (RoutePoint routePoint : routePoints) {
//                routePointRepository.save(routePoint);
//                System.out.println(routePoint.toString());
//            }
//        }
//
//        return "redirect:/route-point";
//    }
//
//}

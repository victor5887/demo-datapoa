package com.demodatapoa.controller;

import com.demodatapoa.persistence.repository.RouteRepository;
import com.demodatapoa.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class MainController {

    @Value("${spring.application.name}")
    String appName;

    private final UserRepository userRepository;
    private final RouteRepository routeRepository;

    @Autowired
    public MainController (UserRepository userRepository, RouteRepository routeRepository) {
        this.userRepository = userRepository;
        this.routeRepository = routeRepository;
    }

    @RequestMapping("/")
    public String homePage(Model model) {
        //model.addAttribute("appName", appName);

        //model.addAttribute("users", userRepository.findAll());
        return "home";
    }

    @RequestMapping("/home")
    public String homePageAlternative(Model model) {
        //model.addAttribute("appName", appName);

        //model.addAttribute("users", userRepository.findAll());
        return "home";
    }

    @RequestMapping("/user")
    public String userPage(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "user";
    }

    @RequestMapping("/route")
    public String routeSearchPage(@RequestParam("s") Optional<String> name, Model model) {
        if (name.isPresent())
            model.addAttribute("routes", routeRepository.findByName(name.get()));
        else
            model.addAttribute("routes", routeRepository.findAll());

        return "route";
    }

}
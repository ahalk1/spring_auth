package edu.rit.auth.controller;

import edu.rit.auth.service.HomeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private HomeService homeService;

   @GetMapping("/")
    public String home(Model model) {
       LOG.debug("Getting home page");
       return homeService.getHomePage(model);
    }
}
